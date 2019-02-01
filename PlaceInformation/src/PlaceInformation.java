
public class PlaceInformation {

	private String name;
	private String address;
	private String tag;
	private double latitude;
	private double longitude;
	private GeoLocation g;

	public PlaceInformation(String name, String address, String tag, double latitude, double longitude) {
		this.name = name;
		this.address = address;
		this.tag = tag;
		this.latitude = latitude;
		this.longitude = longitude;
		g = new GeoLocation(latitude, longitude);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getTag() {
		return tag;

	}

	public String toString() {
		return name + " (latitude: " + latitude + ", longitude: " + longitude + ")";

	}

	public GeoLocation getLocation() {
		return g;
	}

	public double distanceFrom(GeoLocation spot) {
		return g.distanceFrom(spot);

	}

}
