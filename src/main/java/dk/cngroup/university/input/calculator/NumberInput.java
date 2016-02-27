package dk.cngroup.university.input.calculator;

public class NumberInput extends CalculatorInput {

    private Integer number;

    public NumberInput(int number){
        this.number = number;
    }

    @Override
    public boolean isOperation() {
        return false;
    }

    public int getNumber(){
        return number;
    }

}
