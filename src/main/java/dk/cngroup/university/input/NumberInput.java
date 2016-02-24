package dk.cngroup.university.input;

public class NumberInput extends CalculatorInput {

    private Integer number;

    public NumberInput(int number){
        this.number = number;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    public int getNumber(){
        return number;
    }

}
