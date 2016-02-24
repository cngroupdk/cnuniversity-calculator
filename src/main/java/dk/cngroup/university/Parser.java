package dk.cngroup.university;

import org.apache.commons.lang3.StringUtils;
import dk.cngroup.university.exception.MalformedInputException;
import dk.cngroup.university.input.iface.IGeneralInput;
import dk.cngroup.university.input.DoneSignal;
import dk.cngroup.university.input.NumberInput;
import dk.cngroup.university.input.operation.Adding;
import dk.cngroup.university.input.operation.Division;

import java.io.InputStream;
import java.util.Scanner;

public class Parser {

        private Scanner scanner;

        public Parser(InputStream in){
            scanner = new Scanner(in);
        }


        public IGeneralInput parseNextLine() throws MalformedInputException {
            String line = scanner.next();

            if (line.equals(DoneSignal.KEYWORD)) {
                return new DoneSignal();
            } else if (line.equals(Adding.KEYWORD)) {
                return new Adding();
            } else if (line.equals(Division.KEYWORD)) {
                return new Division();
            } else if (StringUtils.isNumeric(line)) {
                return new NumberInput(Integer.parseInt(line));
            } else {
                throw new MalformedInputException();
            }
        }

}
