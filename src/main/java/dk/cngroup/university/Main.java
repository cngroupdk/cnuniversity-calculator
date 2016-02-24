package dk.cngroup.university;

import dk.cngroup.university.exception.AbstractCalculatorException;
import dk.cngroup.university.input.enumeration.InputType;
import dk.cngroup.university.input.iface.IGeneralInput;

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
            List<IGeneralInput> inputs = new LinkedList<>();
			IGeneralInput input = parser.parseNextLine();
			while (input.getType() != InputType.DONE) {
                inputs.add(input);
				input = parser.parseNextLine();
			}

            Calculator calculator = new Calculator(inputs);
            System.out.println(calculator.calculate());

		} catch (AbstractCalculatorException e) {
            System.out.println(e.getMessage());
        }

	}

}
