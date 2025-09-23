package fr.cauvray.launcher.flyable;

import fr.cauvray.launcher.instructions.Coordinates;

public enum FlyableType {
	Baloon(Baloon::new),
	JetPlane(JetPlane::new),
	Helicopter(Helicopter::new);

	private final FlyableCreator creator;

	FlyableType(FlyableCreator creator) {
		this.creator = creator;
	}

	public Flyable create(int id, String name, Coordinates coordinates) {
		return creator.create(id, name, coordinates);
	}

	@FunctionalInterface
	public interface FlyableCreator {
		Flyable create(int id, String name, Coordinates coordinates);
	}
}
