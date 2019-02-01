import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MakeChange {

	public static void main(String[] args) {
		
		String pattern = "----";
		TreeSet<String> words = new TreeSet<>();
		words.add("ally");
		words.add("beta");
		words.add("cool");
		words.add("deal");
		words.add("else");
		words.add("flew");
		words.add("good");
		words.add("hope");
		words.add("ibex");
		
		List<String> list = new ArrayList<>();
		list.add("kelly");
		list.add("Adam");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(words);
		TreeSet<Character> guesses = new TreeSet<>();
		guesses.add('e');
	
		Map<String, TreeSet<String>> wordFamily = new TreeMap<>();
		for (String s : words) {
			String temp = patternCalc(s, guesses, pattern);
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
		System.out.println(wordFamily);
		
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
		System.out.println(largestKey);
		System.out.println(words);
		
	}
		public static String patternCalc(String word, TreeSet<Character> guesses, String pattern) {
			Iterator<Character> i = guesses.iterator();
			while (i.hasNext()) {
				String temp = Character.toString(i.next());
				char tempChar = temp.charAt(0);
				for (int j = 0; j < word.length(); j++) {
					if (tempChar == word.charAt(j)) {
						pattern = pattern.substring(0, j) + temp + pattern.substring(j + 1);
					}
				}
			}
			return pattern;
		}
	
	
	
	
	
	
}	
	
