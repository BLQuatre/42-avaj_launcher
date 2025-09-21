package fr.cauvray.launcher.exceptions;

public class InvalidScenarioInstructionSizeException extends InvalidScenarioInstructionException {
	public InvalidScenarioInstructionSizeException(String line, int size) {
		super("A instruction must contains 5 values (Type Name Longitude Latitude Height)\nCurrent: '" + line + "' (" + size + " values)");
	}
}
