
public class sphereVolume {

	public static void main(String[] args) {
		System.out.print("Spherical Volume = " + sphereVolume(2.0));
		;

	}

	public static double sphereVolume(double radius) {
		double Volume = (4) * (Math.PI) * (radius * radius * radius) / 3;
		return Volume;

	}

}
