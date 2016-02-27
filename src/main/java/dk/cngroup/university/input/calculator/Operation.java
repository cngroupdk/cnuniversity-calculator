package dk.cngroup.university.input.calculator;

public abstract class Operation extends CalculatorInput {

    @Override
    public boolean isOperation() {
        return true;
    }

    public abstract int calculate(int operand1, int operand2);

}
