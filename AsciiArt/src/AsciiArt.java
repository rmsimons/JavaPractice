//This program draws an American Flag from 1889 when there was just 39 states 
public class AsciiArt {

	public static void main(String[] args) {

		draw6Stars();
		halfRedLine();
		draw5Stars();
		halfWhiteLine();
		draw6Stars();
		halfRedLine();
		draw5Stars();
		halfWhiteLine();
		draw6Stars();
		halfRedLine();
		draw5Stars();
		halfWhiteLine();
		draw6Stars();
		halfRedLine();
		whiteLine();
		redLine();
		whiteLine();
		redLine();
		whiteLine();
		redLine();

	}

	public static void draw6Stars() {

		for (int i = 1; i <= 6; i++) {
			System.out.print("*_");

		}

	}

	public static void draw5Stars() {

		for (int i = 1; i <= 5; i++) {
			System.out.print("_*");

		}
		System.out.print("_");

	}

	public static void halfRedLine() {
		for (int i = 1; i <= 13; i++) {
			System.out.print("<");

		}
		System.out.println();
	}

	public static void halfWhiteLine() {
		for (int i = 1; i <= 14; i++) {
			System.out.print(">");

		}
		System.out.println();
	}

	public static void redLine() {
		for (int i = 1; i <= 25; i++) {
			System.out.print("<");
		}
		System.out.println();

	}

	public static void whiteLine() {
		for (int i = 1; i <= 25; i++) {
			System.out.print(">");
		}
		System.out.println();

	}

}
