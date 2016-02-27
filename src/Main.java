import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class Main {

	public static void main(String[] arguments) {

		Scanner scanner = new Scanner(System.in);

		int result = 0;
		String line = scanner.next();
		while (!line.equals("done")) {
			int number = convertStringToNumber(line);
			result += number;
			line = scanner.next();
		}


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
