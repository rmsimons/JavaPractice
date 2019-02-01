//Robert Simons
//6.12.2017
//This program creates a list of all possible anagrams
//for the given word or words


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {
	private List<String> originalDictionary;
	private Map<String, LetterInventory> dict;
	private Map<String, LetterInventory> chosenWords;
	private LetterInventory branch;
	private LetterInventory branch_2;

	//Initialize new Anagram object and computes all inventories in advance
	public Anagrams(List<String> dictionary) {
		this.originalDictionary = dictionary;
		this.chosenWords = new HashMap<String, LetterInventory>();
		this.dict = new HashMap<String, LetterInventory>();
		for (int i = 0; i < dictionary.size(); i++) {
			String temp = dictionary.get(i);
			LetterInventory inv = new LetterInventory(temp);
			this.dict.put(temp, inv);
		}
	}

	//Uses recursive backtracking to find combinations of words that have the same
	//letters as the given string and prints them
	//when max is zero this means any number of words
	public void print(String text, int max) {
		if (max < 0) {
			throw new IllegalArgumentException("Not a valid number of words");
		}
		LetterInventory input = new LetterInventory(text);
		List<List<String>> output = new ArrayList<List<String>>();
		for (String word : dict.keySet()) {
			if (input.subtract(dict.get(word)) != null)
				chosenWords.put(word, dict.get(word));
		}
		ArrayList<String> list = new ArrayList<String>();
		output.add(shortPrint(input, list, max, chosenWords, 0));
	}

	//Creates a short list of the words and recurses down the tree
	//saves correct anagrams
	private List<String> shortPrint(LetterInventory temp,
		ArrayList<String> list, int max,
		Map<String, LetterInventory> smallDict, int climbTree) {
		ArrayList<String> answer = new ArrayList<String>();
		if (climbTree < max || max == 0) {
			Iterator<String> itr = smallDict.keySet().iterator();
			while (itr.hasNext()) {
				String tempStr = itr.next();
				this.branch = new LetterInventory(tempStr);
				this.branch_2 = temp;
				if (this.branch_2.subtract(this.branch) != null) {
					list.add(tempStr);
					this.branch_2 = temp.subtract(this.branch);
					if (this.branch_2.isEmpty()) {
						System.out.println(list.toString());
						answer = list;
					} else {
						shortPrint(this.branch_2, list, max, smallDict, climbTree + 1);
						list.remove(list.size() - 1);
					}
				}
			}
		}
		return answer;
	}
}





