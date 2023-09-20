package onboarding.problem6;

public enum Problem6ExceptionType {
    INVALID_CREW_SIZE("크루의 수는 1 이상 10000 이하여야 합니다."),
    INVALID_EMAIL_LENGTH("이메일의 전체 길이는 11 이상 20 이하여야 합니다."),
    INVALID_EMAIL_FORMAT("이메일의 도메인은 email.com이어야 합니다."),
    INVALID_NICKNAME_LENGTH("닉네임의 전체 길이는 1 이상 20 이하여야 합니다."),
    INVALID_NICKNAME_FORMAT("닉네임은 한글이어야 합니다.");

    private final String message;

    Problem6ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
