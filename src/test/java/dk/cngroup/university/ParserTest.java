package dk.cngroup.university;

import dk.cngroup.university.exception.MalformedInputException;
import dk.cngroup.university.input.DoneSignal;
import dk.cngroup.university.input.calculator.CalculatorInput;
import dk.cngroup.university.input.calculator.NumberInput;
import dk.cngroup.university.input.calculator.operation.*;
import dk.cngroup.university.input.iface.IGeneralInput;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class ParserTest {

    @Test
    public void shouldReturnDoneInput() {
        Parser p = new Parser(new ByteArrayInputStream("done\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input instanceof DoneSignal);
        Assert.assertFalse(input.isCalculatorInput());
    }

    @Test
    public void shouldReturnNumberInput() {
        Parser p = new Parser(new ByteArrayInputStream("85\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        Assert.assertTrue(input instanceof NumberInput);
    }

    @Test
    public void shouldReturnCorrectNumberInput() {
        Parser p = new Parser(new ByteArrayInputStream("85\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        Assert.assertTrue(input instanceof NumberInput);
        Assert.assertEquals(85, ((NumberInput) input).getNumber());
    }

    @Test
    public void shouldReturnAddingOperation() {
        Parser p = new Parser(new ByteArrayInputStream("add\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        CalculatorInput cInput = (CalculatorInput)input;
        Assert.assertTrue(cInput.isOperation());
        Assert.assertTrue(cInput instanceof Adding);
    }

    @Test
    public void shouldReturnSubtractionOperation() {
        Parser p = new Parser(new ByteArrayInputStream("subtract\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        CalculatorInput cInput = (CalculatorInput)input;
        Assert.assertTrue(cInput.isOperation());
        Assert.assertTrue(cInput instanceof Subtraction);
    }

    @Test
    public void shouldReturnMultiplicationOperation() {
        Parser p = new Parser(new ByteArrayInputStream("multiply\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        CalculatorInput cInput = (CalculatorInput)input;
        Assert.assertTrue(cInput.isOperation());
        Assert.assertTrue(cInput instanceof Multiplication);
    }

    @Test
    public void shouldReturnDivisionOperation() {
        Parser p = new Parser(new ByteArrayInputStream("divide\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        CalculatorInput cInput = (CalculatorInput)input;
        Assert.assertTrue(cInput.isOperation());
        Assert.assertTrue(cInput instanceof Division);
    }

    @Test
    public void shouldReturnModulusOperation() {
        Parser p = new Parser(new ByteArrayInputStream("mod\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input.isCalculatorInput());
        CalculatorInput cInput = (CalculatorInput)input;
        Assert.assertTrue(cInput.isOperation());
        Assert.assertTrue(cInput instanceof Modulus);
    }

    @Test(expected = MalformedInputException.class)
    public void shouldThrowMalformedInputException() {
        Parser p = new Parser(new ByteArrayInputStream("sdsd\nasdf".getBytes()));
        p.parseNextLine();
    }

    @Test
    public void shouldReadNumberFromResourceFile() {
        Parser p = new Parser(getClass().getResourceAsStream("/input.txt"));

        IGeneralInput input = p.parseNextLine();
        Assert.assertEquals(1, ((NumberInput)input).getNumber());
        input = p.parseNextLine();
        Assert.assertEquals(2, ((NumberInput)input).getNumber());
        input = p.parseNextLine();
        Assert.assertEquals(3, ((NumberInput)input).getNumber());
        input = p.parseNextLine();
        Assert.assertFalse(input.isCalculatorInput());
    }
}