//This program uses the GeoLocation class to display location and distance
//information for several objects
public class GeoLocationClient {

	public static void main(String[] args) {

		GeoLocation geoStash = new GeoLocation(34.988889, -106.614444);
		GeoLocation geoStudio = new GeoLocation(34.989978, -106.614357);
		GeoLocation geoBuilding = new GeoLocation(35.131281, -106.61263);

		System.out.println("the stash is at " + geoStash);
		System.out.println("ABQ studio is at " + geoStudio);
		System.out.println("FBI building is at " + geoBuilding);

		System.out.println("distance in miles between:");
		System.out.println("    stash/studio = " + geoStash.distanceFrom(geoStudio));
		System.out.println("    stash/fbi    = " + geoStash.distanceFrom(geoBuilding));

	}

}
