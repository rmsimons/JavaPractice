
public class triangleArea {

	public static void main(String[] args) {
		System.out.print("Triangle Area = " + triangleArea(8, 5.2, 7.1));
		;

	}

	public static double triangleArea(double sideLength1, double sideLength2, double sideLength3) {
		double a = sideLength1;
		double b = sideLength2;
		double c = sideLength3;
		double s = (a + b + c) / 2;
		double tArea = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return tArea;

	}

}
