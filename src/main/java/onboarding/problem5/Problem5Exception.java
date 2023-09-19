package onboarding.problem5;


public class Problem5Exception extends RuntimeException{
    private final Problem5ExceptionType type;

    public Problem5Exception(Problem5ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem5ExceptionType getType() {
        return type;
    }
}