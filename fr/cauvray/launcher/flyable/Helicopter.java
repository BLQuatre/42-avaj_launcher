package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.OutfileWriter;
import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String message = "";

		switch (WeatherType.valueOf(weatherTower.getWeather(coordinates))) {
			case SUN:
				coordinates.updateLongitude(10);
				coordinates.updateHeight(2);
				message = "Someone turn off the oven, I’m cooking up here!";
				break;
			case RAIN:
				coordinates.updateLongitude(5);
				message = "I swear I’m not a washing machine!";
				break;
			case FOG:
				coordinates.updateLongitude(1);
				message = "Hide and seek with buildings, let’s gooo.";
				break;
			case SNOW:
				coordinates.updateHeight(-12);
				message = "My rotor is now an ice cream machine!";
				break;
		}

		OutfileWriter.addLine(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + "): " + message);

		super.updateConditions();
	}
}
