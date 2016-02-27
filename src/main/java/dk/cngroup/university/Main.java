package dk.cngroup.university;

import dk.cngroup.university.exception.MalformedInputException;
import dk.cngroup.university.input.CalculatorInput;
import dk.cngroup.university.input.NumberInput;

import java.io.FileInputStream;

public class Main {

	public static void main(String[] arguments) throws Exception {

        Parser parser;
        if (arguments.length == 0) {
            parser = new Parser(System.in);
        } else {
            parser = new Parser(new FileInputStream(arguments[0]));
        }

		int result = 0;

		try {
			CalculatorInput input = parser.parseNextLine();
			while (!input.isDone()) {
				NumberInput nInput = (NumberInput)input;
				result += nInput.getNumber();
				input = parser.parseNextLine();
			}
		} catch (MalformedInputException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println(result);

	}

}
