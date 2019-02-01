import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;

public class HangmanManager {

	private TreeSet<Character> guesses;
	private TreeSet<String> words;
	private int wordLength;
	private int guessesLeft;
	private String finalPattern;
	private String pattern;

	public HangmanManager(List<String> dictionary, int length, int max) {
		if (length < 1 || max < 0) {
			throw new IllegalArgumentException(
					"Word length must be greater or equal to 1 and you must make at least 1 guess");
		}
		wordLength = length;
		guessesLeft = max;
		Iterator<String> itr = dictionary.iterator();
		while (itr.hasNext()) {
			if (itr.next().length() != length) {
				itr.remove();
			}
		}
		words = new TreeSet<String>(dictionary);
		guesses = new TreeSet<>();
		finalPattern = "";
		for (int i = 0; i < wordLength; i++) {
			finalPattern += "-";
		}
		pattern = "";
		for (int i = 0; i < wordLength; i++) {
			pattern += "-";
		}
	}

	public Set<String> words() {
		return words;
	}

	public int guessesLeft() {
		return guessesLeft;
	}

	public Set<Character> guesses() {
		return guesses;
	}

	public String pattern() {
		if (words.isEmpty()) {
			throw new IllegalStateException("Error: there are no words left in the dictionary");
		}
		return finalPattern;
	}

	private String patternCalc(String word) {
		Iterator<Character> itr = guesses.iterator();
		while (itr.hasNext()) {
			String temp = Character.toString(itr.next());
			char tempChar = temp.charAt(0);
			for (int j = 0; j < word.length(); j++) {
				if (tempChar == word.charAt(j)) {
					pattern = pattern.substring(0, j) + temp + pattern.substring(j + 1);
				}
			}
		}
		return pattern;
	}

	public int record(char guess) {
		if (guessesLeft < 1 || words.isEmpty()) {
			throw new IllegalStateException("Unable to make guess, either no guesses left or no words in dictionary");
		}
		if (!words.isEmpty() && guesses.contains(guess)) {
			throw new IllegalArgumentException("You have already guessed this letter");
		}
		guesses.add(guess);
		Map<String, TreeSet<String>> wordFamily = new TreeMap<>();
		for (String s : words) {
			String temp = patternCalc(s);
			if (wordFamily.containsKey(temp)) {
				TreeSet<String> tempSet = new TreeSet<>(wordFamily.get(temp));
				tempSet.add(s);
				wordFamily.put(temp, tempSet);
			} else {
				TreeSet<String> newSet = new TreeSet<>();
				newSet.add(s);
				wordFamily.put(temp, newSet);
			}
		}
		TreeSet<String> largestSet = new TreeSet<>();
		String largestKey = "";
		for (Map.Entry<String, TreeSet<String>> entry : wordFamily.entrySet()) {
			String tempKey = entry.getKey();
			TreeSet<String> tempValue = entry.getValue();
			if (tempValue.size() > largestSet.size()) {
				largestSet.addAll(tempValue);
				largestKey = tempKey;
			}
		}
		
		words = largestSet;
		int count = 0;
//		if (!finalPattern.equals(largestKey)) {
//			guessesLeft = guessesLeft - 1;
//			for (int i = 0; i < finalPattern.length(); i++) {
//				char c_1 = finalPattern.charAt(i);
//				char c_2 = largestKey.charAt(i);
//				if (c_1 != c_2) {
//					count++;
//				}
//			}
//			finalPattern = largestKey;
//		}
		return count;
	}

}


