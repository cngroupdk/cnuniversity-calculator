package dk.cngroup.university.exception;

public class DivisionByZeroException extends AbstractCalculatorException {

    @Override
    public String getMessage() {
        return "division by zero";
    }
}
