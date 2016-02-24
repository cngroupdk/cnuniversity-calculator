package dk.cngroup.university.input.operation;

import dk.cngroup.university.exception.DivisionByZeroException;
import dk.cngroup.university.input.Operation;

public class Division extends Operation{

    public static final String KEYWORD = "divide";

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new DivisionByZeroException();
        }
        return operand1 / operand2;
    }
}
