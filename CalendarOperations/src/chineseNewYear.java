
import java.util.Scanner;

public class chineseNewYear {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a year: ");
		int year = input.nextInt();

		switch (year % 12) {
		case 0:
			System.out.println("Your Chinese Zodiac Sign is monkey");
		case 1:
			System.out.println("Your Chinese Zodiac Sign is rooster");
		case 2:
			System.out.println("Your Chinese Zodiac Sign is dog");
		case 3:
			System.out.println("Your Chinese Zodiac Sign is pig");
		case 4:
			System.out.println("Your Chinese Zodiac Sign is rat");
		case 5:
			System.out.println("Your Chinese Zodiac Sign is ox");
		case 6:
			System.out.println("Your Chinese Zodiac Sign is tiger");
		case 7:
			System.out.println("Your Chinese Zodiac Sign is rabbit");
		case 8:
			System.out.println("Your Chinese Zodiac Sign is dragon");
		case 9:
			System.out.println("Your Chinese Zodiac Sign is snake");
		case 10:
			System.out.println("Your Chinese Zodiac Sign is horse");
		case 11:
			System.out.println("Your Chinese Zodiac Sign is sheep");

		}
	}

}
