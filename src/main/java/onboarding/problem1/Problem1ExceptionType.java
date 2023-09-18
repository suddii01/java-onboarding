package onboarding.problem1;

public enum Problem1ExceptionType {
    INVALID_PAGE_NUMBER("페이지 번호가 유효하지 않습니다."),
    START_OR_END_PAGE_NOT_ALLOWED("첫 페이지와 마지막 페이지는 허용되지 않습니다."),
    INVALID_PAGE_SIZE("페이지 크기가 유효하지 않습니다."),

    NON_CONSECUTIVE_PAGES("페이지 번호는 연속되어야 합니다."),

    INVALID_ODD_LEFT_PAGES("왼쪽 페이지 번호는 반드시 홀수여야 합니다."),

    INVALID_EVEN_RIGHT_PAGES("오른쪽 페이지 번호는 반드시 짝수여야 합니다.");

    private final String message;

    Problem1ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
