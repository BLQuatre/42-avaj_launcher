package fr.cauvray.launcher.exceptions;

public class InvalidScenarioException extends Exception {
	public InvalidScenarioException(String message) {
		super("Scenario file is invalid: " + message);
	}
}
