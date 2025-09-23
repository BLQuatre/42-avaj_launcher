package fr.cauvray.launcher.scenarios;

import fr.cauvray.launcher.AircraftFactory;
import fr.cauvray.launcher.exceptions.AicraftCreationFailedException;
import fr.cauvray.launcher.exceptions.InvalidScenarioException;
import fr.cauvray.launcher.flyable.Flyable;
import fr.cauvray.launcher.flyable.FlyableType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ScenarioCreator {
	private static int customParseInt(String str) throws InvalidScenarioException {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new InvalidScenarioException("Expected an integer, Got '" + str + "'");
		}
	}

	public static Scenario createScenario(String fileName) throws FileNotFoundException, InvalidScenarioException {
		File file = new File(fileName);

		Scanner fileScanner = new Scanner(file);

		int iterations = 0;
		HashMap<String, Flyable> flyables = new HashMap<>();

		if (fileScanner.hasNextLine()) {
			String firstLine = fileScanner.nextLine();
			iterations = customParseInt(firstLine);
			if (iterations < 0) {
				throw new InvalidScenarioException("Expected positive number of instructions. Got " + iterations);
			}
		}

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			String[] splitLine = line.split(" ");
			if (splitLine.length != 5) {
				throw new InvalidScenarioException(
						"Expected 5 values (Type Name Longitude Latitude Height)\n" +
								"Got '" + line + "' (" + splitLine.length + " values)"
				);
			}

			FlyableType flyableType;
			try {
				flyableType = FlyableType.valueOf(splitLine[0]);
			} catch (IllegalArgumentException e) {
				throw new InvalidScenarioException("No aircraft of type '" + splitLine[0] + "' in enum AircraftType!");
			}

			String name = splitLine[1];
			if (flyables.containsKey(name)) {
				throw new InvalidScenarioException("Duplicate name '" + name + "'");
			}

			int longitude = customParseInt(splitLine[2]);
			int latitude = customParseInt(splitLine[3]);
			int height = Integer.min(Integer.max(0, customParseInt(splitLine[4])), 100);

			Coordinates coordinates = new Coordinates(longitude, latitude, height);

			try {
				flyables.put(name, AircraftFactory.newAircraft(flyableType.name(), name, coordinates));
			} catch (AicraftCreationFailedException ex) {
				throw new InvalidScenarioException(ex.getMessage());
			}
		}

		return new Scenario(iterations, flyables.values());
	}
}
