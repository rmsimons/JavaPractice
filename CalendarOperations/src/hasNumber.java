
public class hasNumber {

	public static void main(String[] args) {
		

		string1();
		string2();

	}

	public static void string1() {

		String s = "Christmas 2016";
		stringTest(s);

	}

	public static void string2() {
		String s = "Sunscreen";
		stringTest(s);

	}

	public static void stringTest(String s) {

		if (s.matches(".*\\d+.*")) {

			System.out.println("True");

		} else if (s != null && !s.isEmpty()) {
			System.out.println("False");

		} else {
			System.out.println("False");

		}

	}
}

