package dk.cngroup.university.input.calculator.operation;

import dk.cngroup.university.exception.DivisionByZeroException;
import dk.cngroup.university.input.calculator.Operation;

public class Modulus extends Operation {

    public static final String KEYWORD = "mod";

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new DivisionByZeroException();
        }
        return operand1 % operand2;
    }

}
