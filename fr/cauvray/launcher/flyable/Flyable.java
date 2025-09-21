package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.tower.WeatherTower;

public abstract class Flyable {
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower tower) {
	}
}
