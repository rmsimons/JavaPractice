
public class removeVowels {

	public static void main(String[] args) {

		string1();
		string2();
		string3();
	}

	public static void string1() {

		String str = "FOObar";
		stringTest(str);

	}

	public static void string2() {
		String str = "LKJHGFDS";
		stringTest(str);

	}

	public static void string3() {

		String str = "GLASS HALF FULL";
		stringTest(str);

	}

	public static void stringTest(String str) {

		str = str.replaceAll("[AEIOU]", "");

		if (str != null && !str.isEmpty()) {

		}

		System.out.println(str);

	}
}
