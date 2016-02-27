package dk.cngroup.university;

import dk.cngroup.university.exception.NoInputsException;
import dk.cngroup.university.input.NumberInput;

import java.util.List;

public class Calculator {

    private List<NumberInput> inputs;

    public Calculator() {}

    public Calculator(List<NumberInput> inputs) {
        this.inputs = inputs;
    }

    public void setInputs(List<NumberInput> inputs) {
        this.inputs = inputs;
    }

    public int calculate() throws NoInputsException {
        if (inputs == null || inputs.size() == 0) {
            throw new NoInputsException();
        }

        int result = 0;
        for (NumberInput input : inputs) {
            result += input.getNumber();
        }
        return result;
    }

}
