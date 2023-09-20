package onboarding;

import onboarding.problem6.Problem6Exception;
import onboarding.problem6.Problem6ExceptionType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static onboarding.problem6.Problem6Constant.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            validateCrew(forms);
            validateEmail(forms);
            validateNickname(forms);
        } catch (Problem6Exception e) {
            System.err.println("Error Type: " + e.getType());
            System.err.println("Error Message: " + e.getMessage());
        }


        Set<String> totalTwoLenNicknames = getTotalTwoLenNicknames(forms);
        List<String> duplicatedCrewEmails = getDuplicatedCrewEmails(totalTwoLenNicknames, forms);
        List<String> answer = sortDuplicatedCrewEmails(duplicatedCrewEmails);
        return answer;
    }

    public static void validateCrew(List<List<String>> forms) throws Problem6Exception {
        if (forms.size() < CREW_MIN_SIZE || forms.size() > CREW_MAX_SIZE) {
            throw new Problem6Exception(Problem6ExceptionType.INVALID_CREW_SIZE);
        }
    }

    public static void validateEmail(List<List<String>> forms) throws Problem6Exception {
        for (List<String> form : forms) {
            String email = form.get(0);
            validateEmailLength(email);
            validateEmailFormat(email);
        }
    }

    public static void validateEmailLength(String email) throws Problem6Exception {
        if (email.length() < EMAIL_MIN_LENGTH || email.length() > EMAIL_MAX_LENGTH) {
            throw new Problem6Exception(Problem6ExceptionType.INVALID_EMAIL_LENGTH);
        }
    }

    public static void validateEmailFormat(String email) throws Problem6Exception {
        String domain = email.split("@")[1];
        if (!domain.equals(EMAIL_DOMAIN)) {
            throw new Problem6Exception(Problem6ExceptionType.INVALID_EMAIL_FORMAT);
        }
    }

    public static void validateNickname(List<List<String>> forms) throws Problem6Exception {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            validateNicknameLength(nickname);
            validateNicknameFormat(nickname);
        }
    }

    public static void validateNicknameLength(String nickname) throws Problem6Exception {
        if (nickname.length() < NICKNAME_MIN_LENGTH || nickname.length() > NICKNAME_MAX_LENGTH) {
            throw new Problem6Exception(Problem6ExceptionType.INVALID_NICKNAME_LENGTH);
        }
    }

    public static void validateNicknameFormat(String nickname) throws Problem6Exception {
        for (int i = 0; i < nickname.length(); i++) {
            if (!isKorean(nickname.substring(i, i + 1))) {
                throw new Problem6Exception(Problem6ExceptionType.INVALID_NICKNAME_FORMAT);
            }
        }
    }

    public static boolean isKorean(String str) {
        return str.matches("[가-힣]+");
    }


    public static List<String> sortDuplicatedCrewEmails(List<String> duplicatedCrewEmails) {
        return duplicatedCrewEmails.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> getDuplicatedCrewEmails(Set<String> totalTwoLenNicknames, List<List<String>> forms) {
        List<String> duplicatedCrewEmails = new ArrayList<>();
        for (List<String> form : forms) {
            if (isDuplicatedNickname(totalTwoLenNicknames, form.get(1))) {
                duplicatedCrewEmails.add(form.get(0));
            }
        }
        return duplicatedCrewEmails;
    }

    public static boolean isDuplicatedNickname(Set<String> totalTwoLenNicknames, String nickname) {
        for (String totalTwoLenNickname : totalTwoLenNicknames) {
            if (!nickname.equals(totalTwoLenNickname) && nickname.contains(totalTwoLenNickname)) return true;
        }
        return false;
    }

    public static Set<String> getTotalTwoLenNicknames(List<List<String>> forms) {
        Set<String> totalTwoLenNicknames = new HashSet<>();
        Set<String> tmpTwoLenNicknames = new HashSet<>();
        for (List<String> form : forms) {
            getTwoLenNicknames(form.get(1)).stream()
                    .forEach(entry -> {
                        if (tmpTwoLenNicknames.contains(entry)) totalTwoLenNicknames.add(entry);
                        else tmpTwoLenNicknames.add(entry);
                    });
        }
        return totalTwoLenNicknames;
    }

    public static List<String> getTwoLenNicknames(String nickname) {
        List<String> twoLenNicknames = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            twoLenNicknames.add(nickname.substring(i, i + 2));
        }
        return twoLenNicknames;
    }
}
