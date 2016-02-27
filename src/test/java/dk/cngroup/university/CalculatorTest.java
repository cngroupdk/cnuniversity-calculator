package dk.cngroup.university;

import dk.cngroup.university.exception.NoInputsException;
import dk.cngroup.university.input.NumberInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class CalculatorTest {

    @Test(expected = NoInputsException.class)
    public void testCalculateNullInputs() {
        new Calculator().calculate();
    }

    @Test(expected = NoInputsException.class)
    public void testCalculateEmptyInputs() {
        new Calculator(new LinkedList<NumberInput>()).calculate();
    }

    @Test
    public void testCalculate() {
        LinkedList<NumberInput> inputs = new LinkedList<NumberInput>();
        inputs.add(new NumberInput(4));
        inputs.add(new NumberInput(5));
        Calculator calculator = new Calculator(inputs);
        Assert.assertEquals(9, calculator.calculate());
    }

    @Test
    public void testTwoCalculations() {
        LinkedList<NumberInput> inputs = new LinkedList<NumberInput>();
        inputs.add(new NumberInput(1));
        inputs.add(new NumberInput(2));
        Calculator calculator = new Calculator(inputs);
        Assert.assertEquals(3, calculator.calculate());

        inputs = new LinkedList<NumberInput>();
        inputs.add(new NumberInput(4));
        inputs.add(new NumberInput(2));
        calculator.setInputs(inputs);
        Assert.assertEquals(6, calculator.calculate());
    }

}