package onboarding.problem2;


public class Problem2Exception extends RuntimeException{
    private final Problem2ExceptionType type;

    public Problem2Exception(Problem2ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem2ExceptionType getType() {
        return type;
    }
}