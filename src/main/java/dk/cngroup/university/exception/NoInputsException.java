package dk.cngroup.university.exception;

public class NoInputsException extends RuntimeException {

    @Override
    public String getMessage() {
        return "no inputs in calculator";
    }
}
