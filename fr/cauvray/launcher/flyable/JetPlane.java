package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.WeatherProvider;
import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.instructions.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		WeatherType weatherType = WeatherType.valueOf(WeatherProvider.getCurrentWeather(coordinates));

		switch (weatherType) {
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
	}
}
