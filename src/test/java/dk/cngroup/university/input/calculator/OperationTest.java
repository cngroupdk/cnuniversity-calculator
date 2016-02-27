package dk.cngroup.university.input.calculator;


import dk.cngroup.university.exception.DivisionByZeroException;
import dk.cngroup.university.input.calculator.operation.*;
import org.junit.Assert;
import org.junit.Test;

public class OperationTest {

    @Test
    public void shouldAddOperands(){
        Operation operation = new Adding();
        Assert.assertEquals(4, operation.calculate(1,3));
    }

    @Test
    public void shouldSubtractOperands(){
        Operation operation = new Subtraction();
        Assert.assertEquals(7, operation.calculate(10,3));
    }

    @Test
    public void shouldMultiplyOperands(){
        Operation operation = new Multiplication();
        Assert.assertEquals(30, operation.calculate(10,3));
    }

    @Test
    public void shouldDivideOperands(){
        Operation operation = new Division();
        Assert.assertEquals(2, operation.calculate(13,5));
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldThrowDivisionByZeroWhenDividing(){
        Operation operation = new Division();
        operation.calculate(12,0);
    }

    @Test
    public void shouldCalculateModulus(){
        Operation operation = new Modulus();
        Assert.assertEquals(3, operation.calculate(13,5));
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldThrowDivisionByZeroWhenModulo(){
        Operation operation = new Modulus();
        operation.calculate(12,0);
    }

}