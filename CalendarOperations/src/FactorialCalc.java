
public class FactorialCalc {

	public static void main(String[] args) {

		answerCalc(5);
		answerCalc(6);
		answerCalc(7);
		answerCalc(8);
		answerCalc(9);

	}

	public static void answerCalc(int num) {

		int answer = 1;

		for (int i = 1; i <= num; i++) {

			answer = answer * i;

		}
		System.out.println("The Factorial (n!) of the number " + num + " is: " + answer);

	}
}