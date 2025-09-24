package fr.cauvray.launcher;

import fr.cauvray.launcher.scenarios.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WeatherProvider {
	private static final ArrayList<String> weather = new ArrayList<>(
			Arrays.stream(WeatherType.values()).map(Enum::name).toList()
	);

	private WeatherProvider() {}

	public static String getCurrentWeather(Coordinates coordinates) {
		int seed = coordinates.getLongitude() * 73856093
				^ coordinates.getLatitude() * 19349663
				^ coordinates.getHeight() * 83492791;
		Random localRandom = new Random(seed);
		return weather.get(localRandom.nextInt(weather.size()));
	}
}
