package onboarding.problem7;


import onboarding.problem7.Problem7ExceptionType;

public class Problem7Exception extends RuntimeException{
    private final Problem7ExceptionType type;

    public Problem7Exception(Problem7ExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public Problem7ExceptionType getType() {
        return type;
    }
}