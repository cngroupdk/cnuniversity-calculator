package dk.cngroup.university.exception;

public class MalformedInputException extends AbstractCalculatorException {

    @Override
    public String getMessage() {
        return "input is neither a number nor a known keyword";
    }
}
