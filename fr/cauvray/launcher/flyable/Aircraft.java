package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.utils.Coordinates;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long id, String name, Coordinates coordinates) {
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
	}

	public void updateConditions() {}
}
