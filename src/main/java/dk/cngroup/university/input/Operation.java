package dk.cngroup.university.input;

import dk.cngroup.university.input.enumeration.InputType;
import dk.cngroup.university.input.iface.IGeneralInput;

public abstract class Operation implements IGeneralInput {

    @Override
    public InputType getType() {
        return InputType.OPERATION;
    }

    public abstract int calculate(int operand1, int operand2);

}
