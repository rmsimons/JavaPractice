
//This program asks for two students exam and GPA scores
//then displays their overall scores and which one
//seems to be the better choice for admission.

import java.util.*;

// the program's Captain
public class Admit {

	public static void main(String[] args) {
		intro();
		Scanner console = new Scanner(System.in);
		double overall1 = getOverall1(console);
		double overall2 = getOverall2(console);
		reportResults(overall1, overall2);

	}

	// introduces the program to the user
	public static void intro() {

		System.out.println("This program compares two applicants to");
		System.out.println("determine which one seems like the stronger");
		System.out.println("applicant. For each candidate I will need");
		System.out.println("either SAT or ACT scores plus a weighted GPA.");
		System.out.println();

	}

	// the program's 1st mate
	// the control method for applicant #1 data
	public static double getOverall1(Scanner console) {
		System.out.println("Information for applicant #1:");
		double satoract = satOrAct(console);
		double gpa = getGpa(console);
		double overallscore = satoract + gpa;
		return overallscore;

	}

	// the program's 2nd mate
	// the control method for applicant #2 data
	public static double getOverall2(Scanner console) {
		System.out.println("Information for applicant #2:");
		double satoract = satOrAct(console);
		double gpa = getGpa(console);
		double overallscore = satoract + gpa;
		return overallscore;
	}

	// determines if SAT or ACT scores will be used
	public static double satOrAct(Scanner console) {

		System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
		int typeScore = console.nextInt();

		if (typeScore == 1) {
			double satcalc = getSatCalc(console);
			return satcalc;

		} else {
			double actcalc = getActCalc(console);
			return actcalc;

		}
	}

	// prompts user for and calculates SAT score
	public static double getSatCalc(Scanner console) {

		System.out.print("    SAT math? ");
		int satmath = console.nextInt();
		System.out.print("    SAT critical reading? ");
		int satreading = console.nextInt();
		System.out.print("    SAT writing? ");
		int satwriting = console.nextInt();
		double satScore = (2 * satmath + satreading + satwriting) / 32;

		System.out.printf("    exam score = %.1f\n", satScore);
		return satScore;

	}

	// prompts user for and calculates ACT score
	public static double getActCalc(Scanner console) {
		System.out.print("    ACT English? ");
		int actenglish = console.nextInt();
		System.out.print("    ACT math? ");
		int actmath = console.nextInt();
		System.out.print("    ACT reading? ");
		int actreading = console.nextInt();
		System.out.print("    ACT science? ");
		int actscience = console.nextInt();
		double actScore = (actenglish + 2 * actmath + actreading + actscience) / 1.8;
		System.out.printf("    exam score = %.1f\n", actScore);
		return actScore;

	}

	// prompts user for and calculates GPA score
	public static double getGpa(Scanner console) {
		System.out.print("    overall GPA? ");
		double actual_gpa = console.nextDouble();
		System.out.print("    max GPA? ");
		double max_gpa = console.nextDouble();
		System.out.print("    Transcript Multiplier? ");
		double transcript_multiplier = console.nextDouble();
		double gpaScore = (actual_gpa / max_gpa) * 100 * transcript_multiplier;
		System.out.printf("    GPA score = %.1f\n", gpaScore);
		System.out.println();
		return gpaScore;

	}

	// reports the overall scores for both applicants
	public static void reportResults(double overall1, double overall2) {

		System.out.printf("First applicant overall score  = %.1f\n", overall1);
		System.out.printf("Second applicant overall score = %.1f\n", overall2);
		comparison(overall1, overall2);

	}

	// reports which applicant has the higher overall score
	public static void comparison(double overall1, double overall2) {

		if (overall1 > overall2) {
			System.out.print("The first applicant seems to be better");

		} else if (overall2 > overall1) {
			System.out.print("The second applicant seems to be better");

		} else {
			System.out.print("The two applicants seem to be equal");

		}
	}

}
