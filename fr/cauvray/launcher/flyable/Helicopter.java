package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.WeatherProvider;
import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.utils.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		WeatherType weatherType = WeatherType.valueOf(WeatherProvider.getCurrentWeather(coordinates));

		switch (weatherType) {
			case SUN:
				coordinates.updateLongitude(10);
				coordinates.updateHeight(2);
				break;
			case RAIN:
				coordinates.updateLongitude(5);
				break;
			case FOG:
				coordinates.updateLongitude(1);
				break;
			case SNOW:
				coordinates.updateHeight(-12);
				break;
		}
	}
}
