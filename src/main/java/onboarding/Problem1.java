package onboarding;

import onboarding.problem1.Problem1Exception;
import onboarding.problem1.Problem1ExceptionType;

import java.util.ArrayList;
import java.util.List;

import static onboarding.problem1.Problem1Constant.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePageNumbers(pobi);
            validatePageNumbers(crong);
        } catch (Problem1Exception e) {
            System.err.println("Error Type: " + e.getType());
            System.err.println("Error Message: " + e.getMessage());
            return -1;
        }

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

    public static void validatePageNumbers(List<Integer> pageNumbers) throws Problem1Exception {
        validatePageNumber(pageNumbers);
        validatePageSize(pageNumbers);
        validateConsecutivePages(pageNumbers);
        validateOddLeftAndEvenRightPages(pageNumbers);
    }

    private static void validatePageNumber(List<Integer> pageNumbers) throws Problem1Exception {
        if (pageNumbers.get(0) < MIN_PAGE_NUMBER || pageNumbers.get(0) > MAX_PAGE_NUMBER || pageNumbers.get(1) < MIN_PAGE_NUMBER || pageNumbers.get(1) > MAX_PAGE_NUMBER) {
            throw new Problem1Exception(Problem1ExceptionType.INVALID_PAGE_NUMBER);
        }
        if ((pageNumbers.get(0) == START_LEFT_PAGE_NUMBER && pageNumbers.get(1) == START_RIGHT_PAGE_NUMBER) || (pageNumbers.get(0) == END_LEFT_PAGE_NUMBER && pageNumbers.get(1) == END_RIGHT_PAGE_NUMBER)) {
            throw new Problem1Exception(Problem1ExceptionType.START_OR_END_PAGE_NOT_ALLOWED);
        }
    }


    private static void validatePageSize(List<Integer> pageNumbers) throws Problem1Exception {
        if (pageNumbers.size() != PAGE_NUMBERS_SIZE) {
            throw new Problem1Exception(Problem1ExceptionType.INVALID_PAGE_SIZE);
        }
    }

    private static void validateConsecutivePages(List<Integer> pageNumbers) throws Problem1Exception {
        if (pageNumbers.get(1) - pageNumbers.get(0) != PAGE_NUMBERS_GAP) {
            throw new Problem1Exception(Problem1ExceptionType.NON_CONSECUTIVE_PAGES);
        }
    }

    private static void validateOddLeftAndEvenRightPages(List<Integer> pageNumbers) throws Problem1Exception {
        if (pageNumbers.get(0) % 2 == 0) {
            throw new Problem1Exception(Problem1ExceptionType.INVALID_ODD_LEFT_PAGES);
        }
        if (pageNumbers.get(1) % 2 != 0) {
            throw new Problem1Exception(Problem1ExceptionType.INVALID_EVEN_RIGHT_PAGES);
        }
    }
}