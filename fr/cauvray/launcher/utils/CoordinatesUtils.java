package fr.cauvray.launcher.utils;

public class CoordinatesUtils {
	public static Coordinates getCoordinates(int longitude, int latitude, int height) {
		return new Coordinates(longitude, latitude, height);
	}
}