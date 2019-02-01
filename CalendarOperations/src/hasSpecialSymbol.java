
public class hasSpecialSymbol {

	public static void main(String[] args) {

		string1();
		string2();

	}

	public static void string1() {

		String s = "running scared";
		stringTest(s);

	}

	public static void string2() {
		String s = "!running scared!";
		stringTest(s);

	}

	public static void stringTest(String s) {

		if (s.matches("[&@#%^#!]")) {

			System.out.println("True");

		} else if (s != null && !s.isEmpty()) {
			System.out.println("False");

		} else {
			System.out.println("False");

		}

	}
}
