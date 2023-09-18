package onboarding.problem1;

public class Problem1Exception extends RuntimeException {

    private final Problem1ExceptionType type;

    public Problem1Exception(Problem1ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem1ExceptionType getType() {
        return type;
    }
}