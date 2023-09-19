package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> totalTwoLenNicknames = getTotalTwoLenNicknames(forms);
        List<String> duplicatedCrewEmails = getDuplicatedCrewEmails(totalTwoLenNicknames, forms);
        List<String> answer = sortDuplicatedCrewEmails(duplicatedCrewEmails);
        return answer;
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
