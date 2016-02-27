package dk.cngroup.university;

import dk.cngroup.university.exception.NoInputsException;
import dk.cngroup.university.input.calculator.CalculatorInput;
import dk.cngroup.university.input.calculator.NumberInput;
import org.junit.Assert;
import dk.cngroup.university.input.iface.IGeneralInput;
import dk.cngroup.university.input.calculator.operation.Adding;
import dk.cngroup.university.input.calculator.operation.Division;
import org.junit.Test;

import java.util.LinkedList;

public class CalculatorTest {

    @Test(expected = NoInputsException.class)
    public void testCalculateNullInputs() {
        new Calculator().calculate();
    }

    @Test(expected = NoInputsException.class)
    public void testCalculateEmptyInputs() {
        new Calculator(new LinkedList<>()).calculate();
    }

    @Test
    public void testCalculate() {
        LinkedList<CalculatorInput> inputs = new LinkedList<>();
        inputs.add(new NumberInput(3));
        inputs.add(new NumberInput(5));
        inputs.add(new Division());
        inputs.add(new NumberInput(2));
        inputs.add(new Adding());
        inputs.add(new NumberInput(10));
        Calculator calculator = new Calculator(inputs);
        Assert.assertEquals(14, calculator.calculate());
    }

    @Test
    public void testTwoCalculations() {
        LinkedList<CalculatorInput> inputs = new LinkedList<>();
        inputs.add(new NumberInput(1));
        inputs.add(new NumberInput(2));
        Calculator calculator = new Calculator(inputs);
        Assert.assertEquals(3, calculator.calculate());

        inputs = new LinkedList<>();
        inputs.add(new NumberInput(4));
        inputs.add(new NumberInput(2));
        calculator.setInputs(inputs);
        Assert.assertEquals(6, calculator.calculate());
    }

}