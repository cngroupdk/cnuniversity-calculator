package dk.cngroup.university.input.calculator;


import dk.cngroup.university.exception.DivisionByZeroException;
import dk.cngroup.university.input.calculator.operation.Adding;
import dk.cngroup.university.input.calculator.operation.Division;
import org.junit.Assert;
import org.junit.Test;

public class OperationTest {

    @Test
    public void shouldAddOperands(){
        Operation operation = new Adding();
        Assert.assertEquals(4, operation.calculate(1,3));
    }

    @Test
    public void shouldDivideOperands(){
        Operation operation = new Division();
        Assert.assertEquals(2, operation.calculate(13,5));
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldThrowDivisionByZeroException(){
        Operation operation = new Division();
        operation.calculate(12,0);
    }

}