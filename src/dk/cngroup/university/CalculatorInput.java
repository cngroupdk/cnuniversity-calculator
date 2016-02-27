package dk.cngroup.university;

public class CalculatorInput {

    private Integer number;

    public CalculatorInput(){}

    public CalculatorInput(int number){
        this.number = number;
    }

    public boolean isDone(){
        return number == null;
    }

    public int getNumber(){
        return number;
    }

}
