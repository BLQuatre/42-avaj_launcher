package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class Baloon extends Aircraft {
	public Baloon(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		switch (WeatherType.valueOf(weatherTower.getWeather(coordinates))) {
			case SUN:
				coordinates.updateLongitude(2);
				coordinates.updateHeight(4);
				break;
			case RAIN:
				coordinates.updateHeight(-5);
				break;
			case FOG:
				coordinates.updateHeight(-3);
				break;
			case SNOW:
				coordinates.updateHeight(-15);
				break;
		}

		super.updateConditions();
	}
}
