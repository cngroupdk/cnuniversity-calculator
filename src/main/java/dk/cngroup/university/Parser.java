package dk.cngroup.university;

import org.apache.commons.lang3.StringUtils;
import dk.cngroup.university.exception.MalformedInputException;
import dk.cngroup.university.input.CalculatorInput;
import dk.cngroup.university.input.DoneInput;
import dk.cngroup.university.input.NumberInput;

import java.io.InputStream;
import java.util.Scanner;

public class Parser {

        private Scanner scanner;

        public Parser(InputStream in){
            scanner = new Scanner(in);
        }


        public CalculatorInput parseNextLine() throws MalformedInputException {
            String line = scanner.next();

            if (line.equals(DoneInput.KEYWORD)) {
                return new DoneInput();
            } else if (StringUtils.isNumeric(line)) {
                return new NumberInput(Integer.parseInt(line));
            } else {
                throw new MalformedInputException();
            }
        }

}
