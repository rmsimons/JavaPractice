import java.util.Scanner;

public class CollegeAdmit {

	public static void main(String[] args) {
		Scanner outputConsole = new Scanner(System.in);
		System.out.println("University admission program!");
		System.out.println("What is your GPA?");
		double GPA = outputConsole.nextDouble();
		System.out.println("What is your SAT score?");
		int SAT = outputConsole.nextInt();
		if (GPA < 1.8 || SAT < 900) {
			System.out.println("Sorry you have not been admitted.");
		} else {
			System.out.println("You were accepted!");
			
		}

	}

}
