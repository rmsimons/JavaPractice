import java.util.*;

public class Problem17 {

	public static void main(String[] args) {
		String s = "i think, therefore i am";
		vowelCount(s);

	}

	public static int[] vowelCount(String s) {

		int[] count = new int[5];

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'a') {
				count[0]++;
			} else if (s.charAt(i) == 'e') {
				count[1]++;
			} else if (s.charAt(i) == 'i') {
				count[2]++;
			} else if (s.charAt(i) == 'o') {
				count[3]++;
			} else if (s.charAt(i) == 'u') {
				count[4]++;
			}

		}

		System.out.println(Arrays.toString(count));

		return count;

	}

}
