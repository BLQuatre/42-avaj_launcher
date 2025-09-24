package fr.cauvray.launcher;

import fr.cauvray.launcher.exceptions.InvalidScenarioException;
import fr.cauvray.launcher.flyable.Flyable;
import fr.cauvray.launcher.scenarios.Scenario;
import fr.cauvray.launcher.scenarios.ScenarioCreator;
import fr.cauvray.launcher.tower.WeatherTower;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java fr.cauvray.launcher.Main <scenario>");
			return;
		}

		try {
			OutfileWriter.createFile();
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			System.exit(1);
			return;
		}

		Scenario scenario;
		try {
			scenario = ScenarioCreator.createScenario(args[0]);
		} catch (FileNotFoundException | InvalidScenarioException ex) {
			System.err.println("Error: " + ex.getMessage());
			System.exit(1);
			return;
		}

		WeatherTower weatherTower = new WeatherTower();

		for (Flyable flyable : scenario.flyables()) {
			flyable.registerTower(weatherTower);
			weatherTower.register(flyable);
		}

		for (int i = 1; i < scenario.iterations(); i++) {
			weatherTower.changeWeather();
		}

		try {
			OutfileWriter.writeToFile();
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			System.exit(1);
		}
	}
}
