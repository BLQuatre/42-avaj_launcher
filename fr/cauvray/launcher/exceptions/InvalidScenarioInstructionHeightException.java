package fr.cauvray.launcher.exceptions;

public class InvalidScenarioInstructionHeightException extends InvalidScenarioInstructionException {
	public InvalidScenarioInstructionHeightException(int size) {
		super("The height of an instruction must be between 0 and 100. Current: " + size);
	}
}
