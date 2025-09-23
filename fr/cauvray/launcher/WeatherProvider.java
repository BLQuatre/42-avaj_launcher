package fr.cauvray.launcher;

import fr.cauvray.launcher.instructions.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;

public class WeatherProvider {
	private static final ArrayList<String> weather = new ArrayList<>(
			Arrays.stream(WeatherType.values()).map(Enum::name).toList()
	);

	private WeatherProvider() {}

	public static String getCurrentWeather(Coordinates coordinates) {
		int seed = coordinates.getLongitude() ^ coordinates.getLatitude() ^ coordinates.getHeight();
		int index = Math.abs(seed) % weather.size();
		return weather.get(index);
	}
}
