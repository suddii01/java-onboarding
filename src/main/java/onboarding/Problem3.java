package onboarding;

import onboarding.problem3.Problem3Exception;
import onboarding.problem3.Problem3ExceptionType;

import static onboarding.problem3.Problem3Constant.*;

public class Problem3 {
    public static int solution(int number) {
        try {
            validateNumber(number);
        } catch (Problem3Exception e) {
            System.err.println("Error Type: " + e.getType());
            System.err.println("Error Message: " + e.getMessage());
        }
        return getTotalClapCount(number);
    }

    public static void validateNumber(int number) throws Problem3Exception {
        if (number < NUMBER_MIN_SIZE || number > NUMBER_MAX_SIZE) {
            throw new Problem3Exception(Problem3ExceptionType.INVALID_NUMBER);
        }
    }

    public static int getTotalClapCount(int number) {
        int totalClapCnt = 0;
        for (int i = 1; i <= number; i++) {
            totalClapCnt += getClapCount(i);
        }
        return totalClapCnt;
    }

    public static int getClapCount(int number) {
        Integer integer = Integer.valueOf(number);
        String s = integer.toString();
        int clapCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '3') clapCnt++;
            if (s.charAt(i) == '6') clapCnt++;
            if (s.charAt(i) == '9') clapCnt++;
        }
        return clapCnt;
    }
}
