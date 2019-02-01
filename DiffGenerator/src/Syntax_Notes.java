
public class Syntax_Notes {

	public static void main(String[] args) {
		//public String lCS(String s1, String s2) {
//		int length1 = s1.length();
//		int length2 = s2.length();
	//	
//		if (length1 == 0 || length2 == 0) {
//			return "";
//		} else if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
//			return lCS(s1.substring(0, length1 - 1), s2.substring(0, length2 - 1)) 
//					+ s1.charAt(length1 - 1);
//		} else {
//			String longest1 = lCS(s1, s2.substring(0, length2 - 1));
//			String longest2 = lCS(s1.substring(0, length1 - 1), s2);
//			return  (longest1.length() > longest2.length()) ? longest1 : longest2;
//		}
	//}

//		public String lCS(String s1, String s2, String diff) {
//			int length1 = s1.length();
//			int length2 = s2.length();
//			
//			if (length1 == 0 || length2 == 0) {
//				return diff;
//			} else if (s1.charAt(0) == s2.charAt(0)) {
//				return lCS(s1.substring((length1 + 1) - length1, length1), s2.substring((length2 + 1) - length2, length2), 
//						diff + "0");
//			} else {
//				String longest1 = lCS(s1, s2.substring((length2 + 1) - length2, length2), diff + "+");
//				String longest2 = lCS(s1.substring((length1 + 1) - length1, length1), s2, diff + "-");
//				return  (longest1.length() > longest2.length()) ? longest1 : longest2;
//			}
//		}

	}

}
//This was the answer, it works fine, I just cleaned it up a bit for the final

//public String lCS(String s1, String s2, String diff) {
//int length1 = s1.length();
//int length2 = s2.length();
//if (length1 == 0 || length2 == 0) {
//	if (length1 == 0 && length2 != 0) {
//		return lCS(s1, s2.substring((length2 + 1) - length2), diff + "+");
//	} else if (length1 != 0 && length2 == 0) {
//		return lCS(s1.substring((length1 + 1) - length1), s2, diff + "-");
//	} else {
//		return diff;
//	}
//} else if (s1.charAt(0) == s2.charAt(0)) {
//	return lCS(s1.substring((length1 + 1) - length1), s2.substring((length2 + 1) - length2), 
//			diff + "0");
//} else { 
//	int awayFrom1 = s2.indexOf(s1.charAt(0));
//	int awayFrom2 = s1.indexOf(s2.charAt(0));
//	String awayFrom1Str = "";
//	String awayFrom2Str = "";
//	for (int i = 0; i <= awayFrom1; i++) {
//		awayFrom1Str += "-";
//		}
//	for (int j = 0; j <= awayFrom2; j++) {
//		awayFrom2Str += "+";
//	}
//	if (awayFrom1 == -1) {
//		return lCS(s1.substring((length1 + 1) - length1), s2, diff + "-");
//	} else if (awayFrom2 == -1) {
//		return lCS(s1, s2.substring((length2 + 1) - length2), diff +"+");
//	} else {
//	return (awayFrom1 > awayFrom2) ? 
//			lCS(s1.substring(awayFrom1), s2, diff + awayFrom1Str) :
//			lCS(s1, s2.substring(awayFrom2), diff + awayFrom2Str);
//	}
//}	
//}
