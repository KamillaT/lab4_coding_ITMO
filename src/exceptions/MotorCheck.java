package exceptions;

public class MotorCheck extends RuntimeException {
    public MotorCheck(String message) {
        super(message);
    }
}

