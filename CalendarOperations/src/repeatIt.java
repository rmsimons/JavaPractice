
public class repeatIt {

	public static void main(String[] args) {
		System.out.println(repeat("foobar", 3));
		System.out.println(repeat("lollipop", 7));
	}

	public static String repeat(String inStr, int n) {

		String resultStr = "";

		for (int i = 0; i < inStr.length(); i++) {

			Character c = inStr.charAt(i);

			if (i % 2 == 0) {
				resultStr += c;
				for (int j = 1; j <= n; j++) {
					resultStr += c;
				}
			} else {
				resultStr += c;
			}
		}
		return resultStr;

	}

}
