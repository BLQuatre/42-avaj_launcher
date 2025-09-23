package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		switch (WeatherType.valueOf(weatherTower.getWeather(coordinates))) {
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

		super.updateConditions();
	}
}
