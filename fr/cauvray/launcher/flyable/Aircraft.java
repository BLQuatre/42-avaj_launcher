package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.OutfileWriter;
import fr.cauvray.launcher.scenarios.Coordinates;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long id, String name, Coordinates coordinates) {
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void updateConditions() {
		if (coordinates.getHeight() == 0) {
			OutfileWriter.addLine(this.getClass().getSimpleName()
					+ "#" + this.name
					+ "(" + this.id + ") landing.");
			weatherTower.unregister(this);
		}
	}
}
