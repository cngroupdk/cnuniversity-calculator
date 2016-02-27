package dk.cngroup.university.exception;

public class NoInputsException extends AbstractCalculatorException {

    @Override
    public String getMessage() {
        return "no inputs in calculator";
    }
}
