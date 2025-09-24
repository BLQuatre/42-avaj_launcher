package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.OutfileWriter;
import fr.cauvray.launcher.WeatherType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class Baloon extends Aircraft {
	public Baloon(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String message = "";

		switch (WeatherType.valueOf(weatherTower.getWeather(coordinates))) {
			case SUN:
				coordinates.updateLongitude(2);
				coordinates.updateHeight(4);
				message = "Solar-powered happiness mode: ON.";
				break;
			case RAIN:
				coordinates.updateHeight(-5);
				message = "I should've brought a giant umbrella…";
				break;
			case FOG:
				coordinates.updateHeight(-3);
				message = "Guess I'm flying in Silent Hill now.";
				break;
			case SNOW:
				coordinates.updateHeight(-15);
				message = "Frosty the Snowman just waved at me... oh wait, that's ice.";
				break;
		}

		OutfileWriter.addLine(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + "): " + message);

		super.updateConditions();
	}
}
