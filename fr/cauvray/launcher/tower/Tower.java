package fr.cauvray.launcher.tower;

import fr.cauvray.launcher.flyable.Flyable;
import java.util.List;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionChanged() {
	}
}
