package onboarding.problem4;

public enum Problem4ExceptionType {
    INVALID_WORD_SIZE("word의 길이는 1 이상 1000 이하여야 합니다.");

    private final String message;

    Problem4ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
