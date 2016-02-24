package dk.cngroup.university.input;

import dk.cngroup.university.input.enumeration.InputType;
import dk.cngroup.university.input.iface.IGeneralInput;

public class NumberInput implements IGeneralInput {

    private Integer number;

    public NumberInput(int number){
        this.number = number;
    }

    @Override
    public InputType getType() {
        return InputType.NUMBER;
    }

    public int getNumber(){
        return number;
    }

}
