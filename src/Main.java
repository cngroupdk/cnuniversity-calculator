import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {

	public static void main(String[] arguments) {


		Scanner scanner = new Scanner(System.in);

		String line1 = scanner.next();
		int number1 = 0;
		if (StringUtils.isNumeric(line1)) {
			number1 = Integer.parseInt(line1);
		} else {
			System.out.println("not a number");
			System.exit(0);
		}


		String line2 = scanner.next();
		int number2 = 0;
		if (StringUtils.isNumeric(line2)) {
			number2 = Integer.parseInt(line2);
		} else {
			System.out.println("not a number");
			System.exit(0);
		}

		int result = number1 + number2;

		System.out.println(result);

	}

}
