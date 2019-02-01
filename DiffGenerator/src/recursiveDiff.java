//Robert Simons
public class recursiveDiff {

	private String original1;
	private String original2;

	public recursiveDiff(String str1, String str2) {
		original1 = str1;
		original2 = str2;
	}

	//determines the diff between two strings
	public String lCS(String s1, String s2, String diff) {
		int length1 = s1.length();
		int length2 = s2.length();
		//base cases: 2 semi-final base cases and one absolute final
		//semi-final base cases add "+" or "-" depending on if the second or first 
		//string is remaining respectively. The absolute final base case 
		//prints the diff
		if (length1 == 0 || length2 == 0) {
			if (length1 == 0 && length2 != 0) {
				return lCS(s1, s2.substring(1), diff + "+");
			} else if (length1 != 0 && length2 == 0) {
				return lCS(s1.substring(1), s2, diff + "-");
			} else {
				return diff;
			}
		//prints "0" when the chars match and traverses to the next char
		} else if (s1.charAt(0) == s2.charAt(0)) {
			return lCS(s1.substring(1), s2.substring(1), diff + "0");
		//pre:the chars do not match
		//determines the distance the chars in the opposing string are from the next char
		//if the opposing string does not contain the char, adds the appropriate amount
		//of "-" or "+" to the diff
		//if the char is in the opposing string, whichever one is closest will be used
		// and either a "-" or "+" is added
		//traverses to the next char in all cases
		} else {
			int awayFrom1 = s2.indexOf(s1.charAt(0));
			int awayFrom2 = s1.indexOf(s2.charAt(0));
			String awayFrom1Str = "";
			String awayFrom2Str = "";
			for (int i = 0; i <= awayFrom1; i++) {
				awayFrom1Str += "-";
			}
			for (int j = 0; j <= awayFrom2; j++) {
				awayFrom2Str += "+";
			}
			if (awayFrom1 == -1) {
				return lCS(s1.substring(1), s2, diff + "-");
			} else if (awayFrom2 == -1) {
				return lCS(s1, s2.substring(1), diff + "+");
			} else {
				return (awayFrom1 > awayFrom2) ? lCS(s1.substring(awayFrom1), s2, diff + awayFrom1Str)
						: lCS(s1, s2.substring(awayFrom2), diff + awayFrom2Str);
			}
		}
	}

	public String toString() {
		return "First String: " + original1 + '\n' + "Second String: " + original2 + '\n' + "Result: "
				+ lCS(original1, original2, "");
	}
}
