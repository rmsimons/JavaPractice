
public class cylinderSurfaceArea {

	public static void main(String[] args) {
		System.out.print("Cylinder Surface Area = " + cylinderSurfaceArea(3.0, 4.5));

	}

	public static double cylinderSurfaceArea(double radius, double height) {

		double surfaceArea = 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;

		return surfaceArea;

	}

}
