package dk.cngroup.university;

import dk.cngroup.university.exception.NoInputsException;
import dk.cngroup.university.input.calculator.CalculatorInput;
import dk.cngroup.university.input.calculator.NumberInput;
import dk.cngroup.university.input.calculator.Operation;
import dk.cngroup.university.input.calculator.operation.Adding;

import java.util.List;

public class Calculator {

    private List<CalculatorInput> inputs;
    private Operation currentOperation;

    public Calculator() {
        currentOperation = new Adding();
    }

    public Calculator(List<CalculatorInput> inputs) {
        this();
        this.inputs = inputs;
    }

    public void setInputs(List<CalculatorInput> inputs) {
        this.inputs = inputs;
    }

    public int calculate() throws NoInputsException {
        if (inputs == null || inputs.size() == 0) {
            throw new NoInputsException();
        }

        int result = 0;
        for (CalculatorInput input : inputs) {
            if (input.isOperation()) {
                currentOperation = (Operation)input;
            } else {
                result = currentOperation.calculate(result, ((NumberInput)input).getNumber());
            }

        }
        return result;
    }

}
