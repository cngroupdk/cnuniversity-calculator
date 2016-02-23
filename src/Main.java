import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class Main {

	public static void main(String[] arguments) {

		Scanner scanner = new Scanner(System.in);

		int number1 = convertStringToNumber(scanner.next());
		int number2 = convertStringToNumber(scanner.next());

		int result = number1 + number2;

		System.out.println(result);

	}

	public static int convertStringToNumber(String line) {
		int number = 0;
		if(StringUtils.isNumeric(line)) {
			number = Integer.parseInt(line);
		} else {
			System.out.println("not a number");
			System.exit(0);
		}
		return number;
	}


}
