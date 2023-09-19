package onboarding.problem3;


public class Problem3Exception extends RuntimeException{
    private final Problem3ExceptionType type;

    public Problem3Exception(Problem3ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem3ExceptionType getType() {
        return type;
    }
}