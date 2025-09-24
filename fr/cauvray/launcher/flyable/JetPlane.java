package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String message = "";

		switch (WeatherType.valueOf(weatherTower.getWeather(coordinates))) {
			case SUN:
				coordinates.updateLatitude(10);
				coordinates.updateHeight(2);
				message = "Sun’s out, jet’s out!";
				break;
			case RAIN:
				coordinates.updateLatitude(5);
				message = "Free shower service, who ordered it?";
				break;
			case FOG:
				coordinates.updateLatitude(1);
				message = "Instruments say straight ahead… hope they’re right.";
				break;
			case SNOW:
				coordinates.updateHeight(-7);
				message = "Winter is here, time to cosplay as a penguin.";
				break;
		}

		System.out.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + "): " + message);

		super.updateConditions();
	}
}
