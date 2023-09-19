package onboarding;

import onboarding.problem4.Problem4Enum;

import static onboarding.problem4.Problem4Constant.*;
import static onboarding.problem4.Problem4Enum.*;

public class Problem4 {
    public static String solution(String word) {
        return convertWord(word);
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
