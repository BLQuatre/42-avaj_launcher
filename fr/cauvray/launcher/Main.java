package fr.cauvray.launcher;

import fr.cauvray.launcher.exceptions.InvalidScenarioException;
import fr.cauvray.launcher.flyable.Flyable;
import fr.cauvray.launcher.scenarios.Scenario;
import fr.cauvray.launcher.scenarios.ScenarioCreator;
import fr.cauvray.launcher.tower.WeatherTower;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java fr.cauvray.launcher.Main <scenario>");
			return;
		}

		try {
			if (args[0].endsWith("simulation.txt")) {
				throw new InvalidScenarioException("Scenario file cannot have same name as output file (simulation.txt)");
			}

			OutfileWriter.createFile();

			Scenario scenario = ScenarioCreator.createScenario(args[0]);

			WeatherTower weatherTower = new WeatherTower();

			for (Flyable flyable : scenario.flyables()) {
				flyable.registerTower(weatherTower);
				weatherTower.register(flyable);
			}

			for (int i = 1; i < scenario.iterations(); i++) {
				weatherTower.changeWeather();
			}

			OutfileWriter.writeToFile();
		} catch (InvalidScenarioException | IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			System.exit(1);
		}
	}
}
