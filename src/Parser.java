import org.apache.commons.lang3.StringUtils;

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

            if (line.equals("done")) {
                input = new CalculatorInput();
            } else if (StringUtils.isNumeric(line)) {
                input = new CalculatorInput(Integer.parseInt(line));
            } else {
                System.out.println("not a number");
                System.exit(0);
            }

            return input;
        }

}
