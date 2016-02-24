package dk.cngroup.university;

import dk.cngroup.university.exception.NoInputsException;
import dk.cngroup.university.input.NumberInput;
import dk.cngroup.university.input.Operation;
import dk.cngroup.university.input.enumeration.InputType;
import dk.cngroup.university.input.iface.IGeneralInput;
import dk.cngroup.university.input.operation.Adding;

import java.util.List;

public class Calculator {

    private List<IGeneralInput> inputs;
    private Operation currentOperation;

    public Calculator() {
        currentOperation = new Adding();
    }

    public Calculator(List<IGeneralInput> inputs) {
        this();
        this.inputs = inputs;
    }

    public void setInputs(List<IGeneralInput> inputs) {
        this.inputs = inputs;
    }

    public int calculate() throws NoInputsException {
        if (inputs == null || inputs.size() == 0) {
            throw new NoInputsException();
        }

        int result = 0;
        for (IGeneralInput input : inputs) {
            // here it expects that it cannot be DoneSignal - only Operation or NumberInput
            // it would crash if one of the inputs is DoneSignal - not very good design
            // TODO refactor so it accepts only Operation or NumberInput
            if (input.getType() == InputType.OPERATION) {
                currentOperation = (Operation)input;
            } else {
                result = currentOperation.calculate(result, ((NumberInput)input).getNumber());
            }

        }
        return result;
    }

}
