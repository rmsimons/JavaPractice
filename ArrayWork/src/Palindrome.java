//This program determines if a word or phrase is a palindrome
public class Palindrome {

	public static void main(String[] args) {
		String s_1 = "To be or not to be";
		String s_2 = "A Santa as NASA";
		String s_3 = "Acrobats stab orca";
		String s_4 = "Senile felines";
		String s_5 = "A man, a plan, a canal: Panama";
		String s_6 = "Madam, I'm Adama";
		String s_7 = "Doc, note: I dissent. A fast never prevents a fatness. I diet on cod";
		String s_8 = "radar";
		palindromeTester(s_1);
		palindromeTester(s_2);
		palindromeTester(s_3);
		palindromeTester(s_4);
		palindromeTester(s_5);
		palindromeTester(s_6);
		palindromeTester(s_7);
		palindromeTester(s_8);

	}

	// Prints out if the string is a palindrome, comes from a boolean value
	public static void palindromeTester(String s) {

		if (isPalindrome(s)) {
			System.out.println("\"" + s + "\" is a palindrome");

		} else {
			System.out.println("\"" + s + "\" is NOT a palindrome");

		}

	}

	// Compares each character to see if they match
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^A-Za-z]+", "").toLowerCase();

		int a = 0;
		int b = s.length() - 1;

		while (a < b) {
			if (s.charAt(a) == s.charAt(b)) {
				a++;
				b--;
			} else {
				return false;
			}

		}
		return true;

	}

}
