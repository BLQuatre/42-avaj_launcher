package fr.cauvray.launcher.scenarios;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.setLongitude(longitude);
		this.setLatitude(latitude);
		this.setHeight(height);
	}

	public int getLongitude() {
		return this.longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = Math.max(0, longitude);
	}
	public void updateLongitude(int longitude) {
		this.setLongitude(this.longitude + longitude);
	}

	public int getLatitude() {
		return this.latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = Math.max(0, latitude);
	}
	public void updateLatitude(int latitude) {
		this.setLatitude(this.latitude + latitude);
	}

	public int getHeight() {
		return this.height;
	}
	public void setHeight(int height) {
		this.height = Math.clamp(height, 0, 100);
	}
	public void updateHeight(int height) {
		this.setHeight(this.height + height);
	}
}
