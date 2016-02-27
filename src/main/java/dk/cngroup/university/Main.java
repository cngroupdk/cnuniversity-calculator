package dk.cngroup.university;

import dk.cngroup.university.exception.MalformedInputException;
import dk.cngroup.university.exception.NoInputsException;
import dk.cngroup.university.input.CalculatorInput;
import dk.cngroup.university.input.NumberInput;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] arguments) throws Exception {

        Parser parser;
        if (arguments.length == 0) {
            parser = new Parser(System.in);
        } else {
            parser = new Parser(new FileInputStream(arguments[0]));
        }

		try {
            List<NumberInput> inputs = new LinkedList<NumberInput>();
			CalculatorInput input = parser.parseNextLine();
			while (!input.isDone()) {
                inputs.add((NumberInput)input);
				input = parser.parseNextLine();
			}

            Calculator calculator = new Calculator(inputs);
            System.out.println(calculator.calculate());

		} catch (MalformedInputException e) {
			System.out.println(e.getMessage());
        } catch (NoInputsException e) {
            System.out.println(e.getMessage());
        }

	}

}
