package dk.cngroup.university;

import dk.cngroup.university.exception.MalformedInputException;
import dk.cngroup.university.input.enumeration.InputType;
import dk.cngroup.university.input.iface.IGeneralInput;
import dk.cngroup.university.input.DoneSignal;
import dk.cngroup.university.input.NumberInput;
import dk.cngroup.university.input.operation.Adding;
import dk.cngroup.university.input.operation.Division;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class ParserTest {

    @Test
    public void shouldReturnDoneInput() {
        Parser p = new Parser(new ByteArrayInputStream("done\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertTrue(input instanceof DoneSignal);
        Assert.assertEquals(input.getType(), InputType.DONE);
    }

    @Test
    public void shouldReturnNumberInput() {
        Parser p = new Parser(new ByteArrayInputStream("85\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertEquals(input.getType(), InputType.NUMBER);
    }

    @Test
    public void shouldReturnCorrectNumberInput() {
        Parser p = new Parser(new ByteArrayInputStream("85\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertEquals(input.getType(), InputType.NUMBER);
        Assert.assertEquals(85, ((NumberInput)input).getNumber());
    }

    @Test
    public void shouldReturnAddingOperation() {
        Parser p = new Parser(new ByteArrayInputStream("add\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertEquals(input.getType(), InputType.OPERATION);
        Assert.assertTrue(input instanceof Adding);
    }

    @Test
    public void shouldReturnDivisionOperation() {
        Parser p = new Parser(new ByteArrayInputStream("divide\nasdf".getBytes()));
        IGeneralInput input = p.parseNextLine();
        Assert.assertEquals(input.getType(), InputType.OPERATION);
        Assert.assertTrue(input instanceof Division);
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
        Assert.assertEquals(input.getType(), InputType.DONE);
    }
}