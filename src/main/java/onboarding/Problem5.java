package onboarding;

import onboarding.problem5.Problem5Exception;
import onboarding.problem5.Problem5ExceptionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static onboarding.problem5.Problem5Constant.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        try {
            validateMoney(money);
        } catch (Problem5Exception e) {
            System.err.println("Error Type: " + e.getType());
            System.err.println("Error Message: " + e.getMessage());
        }
        return convertMoneyToList(money);
    }

    public static void validateMoney(int money) throws Problem5Exception{
        if (money < MONEY_MIN_SIZE || money > MONEY_MAX_SIZE) {
            throw new Problem5Exception(Problem5ExceptionType.INVALID_MONEY_SIZE);
        }
    }

    public static List<Integer> convertMoneyToList(int money) {
        List<Integer> currencyUnits = Arrays.asList(FIFTY_THOUSAND_WON, TEN_THOUSAND_WON, FIVE_THOUSAND_WON, ONE_THOUSAND_WON, FIVE_HUNDRED_WON, ONE_HUNDRED_WON, FIFTY_WON, TEN_WON, ONE_WON);
        List<Integer> currencyCnt = initCurrencyCnt(currencyUnits.size());
        for (int i = 0; i < currencyUnits.size(); i++) {
            Integer currencyUnit = currencyUnits.get(i);
            if (money / currencyUnit > 0) {
                currencyCnt.set(i, money / currencyUnit);
                money %= currencyUnit;
            }
        }
        return currencyCnt;
    }

    public static List<Integer> initCurrencyCnt(int size) {
        List<Integer> currencyCnt = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            currencyCnt.add(0);
        }
        return currencyCnt;
    }
}
