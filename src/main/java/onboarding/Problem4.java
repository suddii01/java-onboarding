package onboarding;

import onboarding.problem4.Problem4Enum;
import onboarding.problem4.Problem4Exception;
import onboarding.problem4.Problem4ExceptionType;

import static onboarding.problem4.Problem4Constant.*;
import static onboarding.problem4.Problem4Enum.*;

public class Problem4 {
    public static String solution(String word) {
        try {
            validateWord(word);
        } catch (Problem4Exception e) {
            System.err.println("Error Type: " + e.getType());
            System.err.println("Error Message: " + e.getMessage());
        }

        return convertWord(word);
    }

    public static void validateWord(String word) throws Problem4Exception{
        if (word.length() < WORD_MIN_SIZE || word.length() > WORD_MAX_SIZE) {
            throw new Problem4Exception(Problem4ExceptionType.INVALID_WORD_SIZE);
        }
    }

    public static String convertWord(String word) {
        String newStr = "";
        for (int i = 0; i < word.length(); i++) {
            newStr += convertAlphabet(word.charAt(i));
        }
        return newStr;
    }

    public static char convertAlphabet(char ch) {
        if (checkCase(ch) == UPPER_CASE) return (char) (FIRST_UPPER_ALPHABET + LAST_UPPER_ALPHABET - ch);
        if (checkCase(ch) == LOWER_CASE) return (char) (FIRST_LOWER_ALPHABET + LAST_LOWER_ALPHABET - ch);
        return ch;
    }

    public static Problem4Enum checkCase(char ch) {
        if (ch >= FIRST_UPPER_ALPHABET && ch <= LAST_UPPER_ALPHABET) return UPPER_CASE;
        if (ch >= FIRST_LOWER_ALPHABET && ch <= LAST_LOWER_ALPHABET) return LOWER_CASE;
        return NO_ALPHABET;
    }
}
