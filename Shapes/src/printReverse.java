
public class printReverse {

	public static void main(String[] args) {
		printReverse("hello there!");
	}

	public static String printReverse(String forwardPhrase) {
		for (int i = forwardPhrase.length() - 1; i >= 0; i--) {
			System.out.print(forwardPhrase.charAt(i));

		}

		return forwardPhrase;

	}

}
