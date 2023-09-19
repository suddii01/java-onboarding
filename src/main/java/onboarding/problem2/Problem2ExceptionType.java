package onboarding.problem2;

public enum Problem2ExceptionType {
    INVALID_STRING_LENGTH("cryptogram의 길이는 1 이상 1000 이하여야 합니다."),
    INVALID_CHARACTER("cryptogram은 알파벳 소문자만 포함할 수 있습니다.");

    private final String message;

    Problem2ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
