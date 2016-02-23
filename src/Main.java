public class Main {

	public static void main(String[] arguments) {

		Parser parser = new Parser(System.in);
		int result = 0;

		CalculatorInput input = parser.parseNextLine();
		while (!input.isDone()) {
			result += input.getNumber();
			input = parser.parseNextLine();
		}

		System.out.println(result);

	}

}
