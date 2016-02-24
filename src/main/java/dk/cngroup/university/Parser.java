package dk.cngroup.university;

import org.apache.commons.lang3.StringUtils;
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


        public CalculatorInput parseNextLine(){
            String line = scanner.next();
            CalculatorInput input = null;

            if (line.equals(DoneInput.KEYWORD)) {
                input = new DoneInput();
            } else if (StringUtils.isNumeric(line)) {
                input = new NumberInput(Integer.parseInt(line));
            } else {
                System.out.println("not a number");
                System.exit(0);
            }

            return input;
        }

}
