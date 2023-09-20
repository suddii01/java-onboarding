package onboarding.problem6;


public class Problem6Exception extends RuntimeException{
    private final Problem6ExceptionType type;

    public Problem6Exception(Problem6ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem6ExceptionType getType() {
        return type;
    }
}