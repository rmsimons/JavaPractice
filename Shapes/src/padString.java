
public class padString {

	public static void main(String[] args) {
		padString("hello", 8);

	}

	public static void padString(String word, int charNum) {

		int spaceing = charNum - word.length();
		if (word.length() >= charNum) {
			System.out.print("\"" + word + "\"");

		} else {
			System.out.print("\"" + word);
			for (int i = 1; i <= spaceing; i++) {
				System.out.print(" ");
				;
			}
			System.out.print("\"");

		}
	}
}
