package dk.cngroup.university;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class ParserTest {

    @Test
    public void shouldReturnDoneInput() {
        Parser p = new Parser(new ByteArrayInputStream("done\nasdf".getBytes()));
        CalculatorInput input = p.parseNextLine();
        Assert.assertTrue(input.isDone());
    }

    @Test
    public void shouldReturnNumberInput() {
        Parser p = new Parser(new ByteArrayInputStream("85\nasdf".getBytes()));
        CalculatorInput input = p.parseNextLine();
        Assert.assertNotNull(input.getNumber());
    }

    @Test
    public void shouldReturnCorrectNumberInput() {
        Parser p = new Parser(new ByteArrayInputStream("85\nasdf".getBytes()));
        CalculatorInput input = p.parseNextLine();
        Assert.assertEquals(85, input.getNumber());
    }

    @Test
    public void shouldReadNumberFromResourceFile() {
        Parser p = new Parser(getClass().getResourceAsStream("/input.txt"));

        CalculatorInput input = p.parseNextLine();
        Assert.assertEquals(1, input.getNumber());
        input = p.parseNextLine();
        Assert.assertEquals(2, input.getNumber());
        input = p.parseNextLine();
        Assert.assertEquals(3, input.getNumber());
        input = p.parseNextLine();
        Assert.assertTrue(input.isDone());
    }
}