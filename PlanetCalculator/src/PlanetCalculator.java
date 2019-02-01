
public class PlanetCalculator {
	static double ONE_ASTRONOMICAL_UNIT = 92957100;

	public static void main(String args[]) {
		double dist;
		double distToMercury;
		distToMercury = 35983610;
		dist = distToMercury / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to mercury is " + dist + " AU");
		
		double distToVenus;
		distToVenus = 67232360;
		dist = distToVenus / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to venus is " + dist + " AU");
		
		double distToEarth;
		distToEarth = 92957100;
		dist = distToEarth / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to earth is " + dist + " AU");
		
		double distToMars;
		distToMars = 141635300;
		dist = distToMars / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to mars is " + dist + " AU");
		
		double distToJupiter;
		distToJupiter = 483632000;
		dist = distToJupiter / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to jupiter is " + dist + " AU");
		
		double distToSatern;
		distToSatern = 888188000;
		dist = distToSatern / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to satern is " + dist + " AU");
		
		double distToUranus;
		distToUranus = 1783950000;
		dist = distToUranus / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to uranus is " + dist + " AU");
		
		double distToNeptune;
		distToNeptune = 2798842000.;
		dist = distToNeptune / ONE_ASTRONOMICAL_UNIT;
		System.out.println("distance to neptune is " + dist + " AU");
		
		
	}
}