package onboarding.problem5;

public enum Problem5ExceptionType {
    INVALID_MONEY_SIZE("money의 크기는 1 이상 1000000 이하여야 합니다.");

    private final String message;

    Problem5ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
