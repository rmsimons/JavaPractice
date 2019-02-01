import java.util.*;

/*This program plays a game with the user. The computer will
 * generate a number between 1 and MAXRANGE, and the user will 
 * try to guess it. The user may also play as many games as
 * desired. Once done playing the final results are displayed. 
 */

public class GuessingGame {

	int mInt;
	public static final int MAXRANGE = 100; // change this constant to make the game easier/harder

	public static void main(String[] args) {

		giveIntro();
		Scanner console = new Scanner(System.in);
		Random r = new Random();
		int number = r.nextInt(MAXRANGE) + 1; // range of generated numbers
		int numGuess = 0;    
		int bestGame = 0;
		int totalGuess = 0;

		oneGame(console, numGuess, bestGame, number, totalGuess); //It is assumed the user will always play one game

		int gamesPlayed = 1;

		System.out.print("Do you want to play again? ");
		String answer = console.next();

		//if the first character in users response is y or Y you will play again
		while (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
			Random loopR = new Random(); //new range of generated numbers
			int loopNumber = loopR.nextInt(MAXRANGE) + 1;
			oneGame(console, numGuess, bestGame, loopNumber, totalGuess);

			System.out.print("Do you want to play again? ");
			answer = console.next();

			gamesPlayed++;

		}

		results(totalGuess, bestGame, gamesPlayed);

	}

	//Introduction to program. It is a haiku poem. 
	public static void giveIntro() {

		System.out.println("Hey, guess my number,");
		System.out.println("between a min and a max,");
		System.out.println("I'll give you a hint.");

	}

	//Method that plays the game
	public static int oneGame(Scanner console, int numGuess, int bestGame, int number, int totalGuess) {

		numGuess = 1;

		System.out.println();
		System.out.println("I'm thinking of a number between 1 and " + MAXRANGE + "...");
		System.out.print("Your guess? ");
		int guess = console.nextInt();
		while (guess != number) {

			hint(number, guess);
			System.out.print("Your guess? ");
			guess = console.nextInt();
			numGuess++;

		}
		if (numGuess == 1) {
			System.out.print("You got it right in 1 guess!");
		} else {
			System.out.println("You got it right in " + numGuess + " guesses!");
		}

		bestGuess(numGuess, bestGame); //keeps track of the best played game

		return totalGuess = totalGuess + numGuess; //keeps track of the total guesses

	}

	//Gives hint to the user
	public static void hint(int compareNumber, int compareGuess) { 

		if (compareGuess > compareNumber) {
			System.out.println("It's lower.");

		} else {
			System.out.println("It's higher.");
		}

	}

	//Keeps track of the best game played (High Score)
	public static int bestGuess(int bestGuess, int bestGame) {
		if (bestGuess > bestGame) {
			bestGame = bestGuess;

		}
		return bestGame;

	}

	//Displays final results
	public static void results(int totalGuess, int bestGame, int gamesPlayed) {

		System.out.println();
		System.out.println("Overall results:");
		System.out.println("Total games   = " + gamesPlayed);
		System.out.println("Total guesses = " + totalGuess);
		System.out.printf("Guesses/game  = %.1f%n", (double) + totalGuess / gamesPlayed);
		System.out.println("Best game     = " + bestGame);

	}
}
