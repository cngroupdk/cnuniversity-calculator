package dk.cngroup.university.input;

public class DoneInput extends CalculatorInput {

    public static final String KEYWORD = "done";

    @Override
    public boolean isDone() {
        return true;
    }

}
