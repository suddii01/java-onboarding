package onboarding.problem7;

public enum Problem7ExceptionType {
    INVALID_ID_LENGTH("사용자 아이디의 길이는 1자 이상 30자 이하여야 합니다."),
    INVALID_ID_FORMAT("사용자 아이디는 알파벳 소문자로만 이루어져야 합니다."),
    INVALID_FRIENDS_SIZE("friends의 전체 크기가 1 이상 10000 이여야 합니다."),
    INVALID_FRIEND_SIZE("friends의 각 원소의 길이가 2이어야 합니다."),
    INVALID_VISITORS_SIZE("visitors의 전체 크기가 1 이상 10000 이하여야 합니다.");


    private final String message;

    Problem7ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
