package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		switch (WeatherType.valueOf(weatherTower.getWeather(coordinates))) {
			case SUN:
				coordinates.updateLatitude(10);
				coordinates.updateHeight(2);
				break;
			case RAIN:
				coordinates.updateLatitude(5);
				break;
			case FOG:
				coordinates.updateLatitude(1);
				break;
			case SNOW:
				coordinates.updateHeight(7);
				break;
		}

		super.updateConditions();
	}
}
