package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getTotalClapCount(number);
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
