package dk.cngroup.university.input.calculator;

import dk.cngroup.university.input.iface.IGeneralInput;

public abstract class CalculatorInput implements IGeneralInput {

    @Override
    public boolean isCalculatorInput() {
        return true;
    }

    public abstract boolean isOperation();
}
