//Robert Simons
//This class keeps track of an inventory of letters of the alphabet
public class LetterInventory {
	private int[] numData;
	private int size;

	public static final int LETTERS_IN_ALPHABET = 26;

	//Constructs an inventory of the letters in a string while ignoring case
	//Keeps track of the amount of letters with the size variable, not the size
	//of the corresponding int[]
	public LetterInventory(String data) {
		String tempStr = data.toLowerCase().replaceAll("[^a-z]+", "");
		char[] strData = tempStr.toCharArray();
		this.numData = new int[LETTERS_IN_ALPHABET];
		for (int i = 0; i < strData.length; i++) {
			numData[strData[i] - 'a'] += 1;
			size++;
		}
	}

	//Returns the sum of the inventory
	public int size() {
		return size;
	}

	//Returns true if the inventory is empty, false if it is not
	public boolean isEmpty() {
		return size == 0;
	}

	//pre: letter must be an alphanumeric character, throws exception otherwise  
	//Returns the count of the specified letter in the inventory
	public int get(char letter) {
		if (letter < 65 || (letter > 90 && letter < 97) || letter > 122) {
			throw new IllegalArgumentException("Not a valid character");
		}
		letter = Character.toLowerCase(letter);
		return numData[letter - 'a'];
	}

	//Returns a string representation of the inventory in a [abc..xyz] format
	//Casts the numbers int the int[] to char then to String type
	public String toString() {
		String s = "";
		for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
			for (int j = 0; j < numData[i]; j++)
				s += (char) (i + 'a');
		}
		return "[" + s + "]";
	}

	//pre: letter must be alphanumeric && value positive, throws an exception otherwise
	//Sets the count for the given letter to the given value
	//size computation: computes the change in size due to the letter value
	public void set(char letter, int value) {
		if (letter < 65 || (letter > 90 && letter < 97) || letter > 122 || value < 0) {
			throw new IllegalArgumentException("Not a valid character and/or number");
		}
		letter = Character.toLowerCase(letter);
		size += value - numData[letter - 'a'];
		numData[letter - 'a'] = value;
	}

	//Constructs and returns a new LetterInventory object that represents the sum of 
	//this. and other. 
	public LetterInventory add(LetterInventory other) {
		LetterInventory add = new LetterInventory("");
		for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
			add.numData[i] = this.numData[i] + other.numData[i];
		}
		add.size = this.size + other.size;
		return add;
	}

	//Constructs and returns a new LetterInventory object that represents the subtraction 
	//of this. and other. If the result is negative, returns null
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory subtract = new LetterInventory("");
		for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
			if (other.numData[i] > this.numData[i]) {
				return null;
			} else {
				subtract.numData[i] = this.numData[i] - other.numData[i];
			}
		}
		subtract.size = this.size - other.size;
		return subtract;
	}

}