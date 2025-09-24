package fr.cauvray.launcher;

import fr.cauvray.launcher.exceptions.AicraftCreationFailedException;
import fr.cauvray.launcher.flyable.Flyable;
import fr.cauvray.launcher.flyable.FlyableType;
import fr.cauvray.launcher.scenarios.Coordinates;

public class AircraftFactory {
	private static int id = 1;

	public static Flyable newAircraft(String type, String name, Coordinates coordinates) throws AicraftCreationFailedException {
		FlyableType flyableType;

		try {
			flyableType = FlyableType.valueOf(type);
		} catch (IllegalArgumentException ex) {
			throw new AicraftCreationFailedException(type, name);
		}

		Flyable flyable = flyableType.create(id, name, coordinates);
		id++;

		if (flyable == null) {
			throw new AicraftCreationFailedException(type, name);
		}

		return flyable;
	}
}
