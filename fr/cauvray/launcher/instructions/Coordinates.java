package fr.cauvray.launcher.instructions;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return this.longitude;
	}
	public void updateLongitude(int longitude) {
		this.longitude += longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}
	public void updateLatitude(int latitude) {
		this.latitude += latitude;
	}

	public int getHeight() {
		return this.height;
	}
	public void updateHeight(int height) {
		this.height += height;
	}
}
