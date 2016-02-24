package dk.cngroup.university.input;

import dk.cngroup.university.input.enumeration.InputType;
import dk.cngroup.university.input.iface.IGeneralInput;

public class DoneSignal implements IGeneralInput {

    public static final String KEYWORD = "done";

    @Override
    public InputType getType() {
        return InputType.DONE;
    }

}
