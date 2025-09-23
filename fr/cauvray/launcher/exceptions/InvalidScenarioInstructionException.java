package fr.cauvray.launcher.exceptions;

public class InvalidScenarioInstructionException extends Exception {
	public InvalidScenarioInstructionException(String message) {
		super("Invalid instruction in scenario file: " + message);
	}
}
