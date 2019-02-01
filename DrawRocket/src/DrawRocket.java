					//This program produces a rocket of varying height
					//Change the integer of the height variable to see
public class DrawRocket {   
	public static final int HEIGHT = 3;

	public static void main(String[] args) {

		drawNose();
		drawLine();
		drawUpperPyramid();
		drawLowerPyramid();
		drawLine();
		drawLowerPyramid();
		drawUpperPyramid();
		drawLine();
		drawNose();

	}
					//method for drawing the tip and exhaust of the rocket
	public static void drawNose() { 
		for (int line = 1; line <= HEIGHT * 2 - 1; line++) {
			for (int i = 1; i <= (HEIGHT * 2) - line; i++) {
				System.out.print(" ");
			}

			for (int i = 1; i <= line; i++) {
				System.out.print("/");
			}

			System.out.print("**");
			for (int i = 1; i <= line; i++) {
				System.out.print("\\");
			}
			System.out.println();
		}
	}
					//method for drawing the section breaks of the rocket
	public static void drawLine() {
		System.out.print("+");

		for (int i = 1; i <= HEIGHT * 2; i++) {
			System.out.print("=*");
		}
		System.out.print("+");
		System.out.println();

	}
					//method for drawing half of each mid section
	public static void drawUpperPyramid() {

		for (int line = 1; line <= HEIGHT; line++) {
			System.out.print("|");

			for (int i = 1; i <= HEIGHT - line; i++) {
				System.out.print(".");
			}
			for (int i = 1; i <= line; i++) {
				System.out.print("/\\");

			}
			for (int i = 1; i <= (HEIGHT * 2) - (line * 2); i++) {
				System.out.print(".");
			}
			for (int i = 1; i <= line; i++) {
				System.out.print("/\\");

			}
			for (int i = 1; i <= HEIGHT - line; i++) {
				System.out.print(".");
			}
			System.out.print("|");
			System.out.println();

		}

	}
					//method for drawing other half of each mid section
	public static void drawLowerPyramid() {

		for (int line = 1; line <= HEIGHT; line++) {
			System.out.print("|");

			for (int i = 1; i <= line - 1; i++) {
				System.out.print(".");
			}

			for (int i = 1; i <= (HEIGHT + 1) - line; i++) {
				System.out.print("\\/");

			}
			for (int i = 1; i <= (line - 1) * 2; i++) {
				System.out.print(".");
			}

			for (int i = 1; i <= (HEIGHT + 1) - line; i++) {
				System.out.print("\\/");

			}

			for (int i = 1; i <= line - 1; i++) {
				System.out.print(".");
			}
			System.out.print("|");
			System.out.println();

		}

	}

}
