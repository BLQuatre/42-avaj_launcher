package fr.cauvray.launcher;

import fr.cauvray.launcher.exceptions.AicraftCreationFailedException;
import fr.cauvray.launcher.flyable.Flyable;
import fr.cauvray.launcher.flyable.FlyableType;
import fr.cauvray.launcher.instructions.Coordinates;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, Coordinates coordinates) throws AicraftCreationFailedException {
		FlyableType flyableType;

		try {
			flyableType = FlyableType.valueOf(type);
		} catch (IllegalArgumentException ex) {
			throw new AicraftCreationFailedException(type, name);
		}

		Flyable flyable = flyableType.create(1, name, coordinates);

		if (flyable == null) {
			throw new AicraftCreationFailedException(type, name);
		}

		return flyable;
	}
}
