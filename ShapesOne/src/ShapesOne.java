public class ShapesOne {

	public static void main(String args[]) {
		drawSquare(5,6);
	}

	public static void drawSquare(int height, int width) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}