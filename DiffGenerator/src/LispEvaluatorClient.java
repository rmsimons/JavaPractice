import java.util.Arrays;

public class LispEvaluatorClient {

	public static void main(String[] args) {
		String s = "(* 2 3 ( - 5 3 ) )";
		String s1 = s.replaceAll("\\s+","");
		String[] str = s1.split("(?!^)");
		System.out.println(Arrays.toString(str));
		for (String n : str) {
			if (("0123456789").contains(n)) {
				System.out.println(n);
			}
			else {
				System.out.println("operator");
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(s1.toCharArray()));
		for (char c : s1.toCharArray()) {
			if (c >= '0' && c <= '9') {
				System.out.println(c);
			}
			else {
				System.out.println("operator");
			}
		}
		
		LispEvaluator test1 = new LispEvaluator("(+ (/ 10 3) (% 10 3)) ");
		
		
		double answer1 = test1.evaluate();
		
		System.out.println(answer1);
		
		
		
		
	}

}
