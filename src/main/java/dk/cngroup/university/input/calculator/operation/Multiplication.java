package dk.cngroup.university.input.calculator.operation;

import dk.cngroup.university.input.calculator.Operation;

public class Multiplication extends Operation {

    public static final String KEYWORD = "multiply";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }
}
