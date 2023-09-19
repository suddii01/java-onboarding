package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static String solution(String cryptogram) {
        while (hasDuplicatedChars(cryptogram)) {
            cryptogram = removeDuplicatedChars(cryptogram);
        }
        return cryptogram;
    }

    public static boolean hasDuplicatedChars(String cryptogram) {
        if (cryptogram.length() == 1 || cryptogram.length() == 0) return false;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return true;
        }
        return false;
    }

    public static String removeDuplicatedChars(String cryptogram) {
        List<Boolean> isDuplicated = initBooleanList(cryptogram.length());
        isDuplicated = checkDuplicatedChars(isDuplicated, cryptogram);
        String newCryptogram = getNewCryptogram(isDuplicated, cryptogram);
        return newCryptogram;
    }

    public static List<Boolean> initBooleanList(int size) {
        List<Boolean> booleanList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            booleanList.add(Boolean.FALSE);
        }
        return booleanList;
    }

    public static List<Boolean> checkDuplicatedChars(List<Boolean> isDuplicated, String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                isDuplicated.set(i, Boolean.TRUE);
                isDuplicated.set(i + 1, Boolean.TRUE);
            }
        }
        return isDuplicated;
    }

    public static String getNewCryptogram(List<Boolean> isDuplicated, String cryptogram) {
        String newCryptogram = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            if (isDuplicated.get(i)) continue;
            newCryptogram += cryptogram.charAt(i);
        }
        return newCryptogram;
    }
}