package fr.cauvray.launcher.tower;

import fr.cauvray.launcher.OutfileWriter;
import fr.cauvray.launcher.flyable.Aircraft;
import fr.cauvray.launcher.flyable.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private final List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable)) {
			return;
		}

		if (!(flyable instanceof Aircraft aircraft)) {
			return;
		}

		observers.add(aircraft);

		OutfileWriter.addLine("Tower says: " + aircraft.getClass().getSimpleName()
				+ "#" + aircraft.getName()
				+ "(" + aircraft.getId() + ") registered to weather tower.");
	}

	public void unregister(Flyable flyable) {
		if (!observers.contains(flyable)) {
			return;
		}

		if (!(flyable instanceof Aircraft aircraft)) {
			return;
		}

		observers.remove(flyable);
		OutfileWriter.addLine("Tower says: " + aircraft.getClass().getSimpleName()
				+ "#" + aircraft.getName()
				+ "(" + aircraft.getId() + ") unregistered to weather tower.");

	}

	protected void conditionChanged() {
		new ArrayList<>(this.observers).forEach(Flyable::updateConditions);
	}
}
