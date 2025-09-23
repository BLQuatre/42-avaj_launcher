package fr.cauvray.launcher.tower;

import fr.cauvray.launcher.flyable.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private final List<Flyable> observers =  new ArrayList<>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionChanged() {
	}
}
