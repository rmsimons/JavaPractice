// This program constructs several PlaceInformation objects and prints // information about them and the distances between them and two locations // (London and Kane Hall).  It is intended to be used to test whether the // PlaceInformation class is implemented correctly.
public class PlaceInformationClient {
	public static void main(String[] args) {
		PlaceInformation[] data = {
				new PlaceInformation("Space Needle", "400 Broad St", "attractions, monuments", 47.620633, -122.348230),
				new PlaceInformation("Key Arena", "401 1st Ave N", "theater, events", 47.622144,
						-122.354024),
				new PlaceInformation("Pacific Science Center", "200 2nd Ave N", "museum, science", 47.619433, -122.351470),
				new PlaceInformation("Pike Place Market", "1516 Western Ave", "shopping, food", 47.608530, -122.340699),
				new PlaceInformation("Seattle Art Museum", "1301 2nd Ave", "museum, art", 47.607308, -122.338142),
				};
		GeoLocation london = new GeoLocation(51.5112139, -0.1198244);
		GeoLocation kane = new GeoLocation(47.6566273, -122.3091503);
		for (PlaceInformation info : data) {
			System.out.println("name    : " + info.getName());
			System.out.println("address : " + info.getAddress());
			System.out.println("tags    : " + info.getTag());
			System.out.println("toString: " + info);
			System.out.println("London  : " + info.distanceFrom(london));
			System.out.println("Kane    : " + info.distanceFrom(kane));
			System.out.println();
		}
	}
}