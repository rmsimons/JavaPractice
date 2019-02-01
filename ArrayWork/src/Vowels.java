
//This program determines the average number of vowels per word in an array of Strings
import java.util.Arrays;

public class Vowels {

	public static void main(String[] args) {
		String[] arrayList = { "Twas", "brillig", "and", "the", "slithy", "toves", "Did", "gyre", "and", "gimble", "in",
				"the", "wabe" };
		double avgVowel = averageVowels(arrayList);
		System.out.println("Average vowels per word: " + avgVowel);

	}

	// Converts the array of Strings into one String then counts all the vowels
	public static double averageVowels(String[] list) {
		if (list == null) {
			throw new IllegalArgumentException();

		}
		String s = Arrays.toString(list);

		int numVowels = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
					|| c == 'U') {
				numVowels++;

			}

		}

		if (numVowels == 0) {
			return 0.0;
		} else {
			double denominator = list.length;
			return numVowels / denominator;

		}

	}

}
