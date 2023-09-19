package onboarding.problem4;


public class Problem4Exception extends RuntimeException{
    private final Problem4ExceptionType type;

    public Problem4Exception(Problem4ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem4ExceptionType getType() {
        return type;
    }
}