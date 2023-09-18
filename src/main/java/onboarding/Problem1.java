package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = calculateMaxScoreOfPlayer(pobi);
        int crongScore = calculateMaxScoreOfPlayer(crong);
        int answer = compareScores(pobiScore, crongScore);
        return answer;
    }

    private static int compareScores(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else if (pobiScore == crongScore) return 0;
        return -1;
    }

    private static int calculateMaxScoreOfPlayer(List<Integer> pageNumbers) {
        Integer leftPageNumber = pageNumbers.get(0);
        Integer rightPageNumber = pageNumbers.get(1);

        int maxValueOfLeftPage = calculateMaxScoreOfPage(leftPageNumber);
        int maxValueOfRightPage = calculateMaxScoreOfPage(rightPageNumber);

        return Math.max(maxValueOfLeftPage, maxValueOfRightPage);
    }

    private static int calculateMaxScoreOfPage(Integer pageNumber) {
        List<Integer> digits = convertPageNumberToDigits(pageNumber);
        int pageDigitSum = sumPageDigits(digits);
        int pageDigitProduct = multiplyPageDigits(digits);
        return Math.max(pageDigitSum, pageDigitProduct);
    }

    private static int sumPageDigits(List<Integer> digits) {
        int sumResult = 0;
        for (Integer digit : digits) {
            sumResult += digit;
        }
        return sumResult;
    }

    private static int multiplyPageDigits(List<Integer> digits) {
        int ans = 1;
        for (Integer digit : digits) {
            ans *= digit;
        }
        return ans;
    }

    private static List<Integer> convertPageNumberToDigits(int pageNumber) {
        List<Integer> digits = new ArrayList<>();
        while (pageNumber > 0) {
            digits.add(pageNumber % 10);
            pageNumber /= 10;
        }
        return digits;
    }
}