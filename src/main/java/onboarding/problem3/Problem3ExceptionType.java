package onboarding.problem3;

public enum Problem3ExceptionType {
    INVALID_NUMBER("number는 1 이상 1000 이하여야 합니다.");

    private final String message;

    Problem3ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
