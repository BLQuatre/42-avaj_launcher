package fr.cauvray.launcher.exceptions;

public class AircraftNotFoundException extends Exception {
	public AircraftNotFoundException(String type) {
		super("Aircraft of type: " + type + " not found!");
	}
}
