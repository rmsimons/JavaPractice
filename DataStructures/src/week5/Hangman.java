package week5;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hangman {

	public static void main(String[] args) {
		Map<String, Set> possibilities = new TreeMap<>();
		Set family = new TreeSet<String>();
		family.add("sun"); // is this already a key? if it is add, it to set, if
							// it isnt already part of a set, make a new set and
							// add it to that set
		possibilities.put("____", family);
	}

}
