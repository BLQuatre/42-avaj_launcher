package fr.cauvray.launcher.tower;

import fr.cauvray.launcher.WeatherProvider;
import fr.cauvray.launcher.scenarios.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getCurrentWeather(coordinates);
	}

	public void changeWeather() {
		this.conditionChanged();
	}
}
