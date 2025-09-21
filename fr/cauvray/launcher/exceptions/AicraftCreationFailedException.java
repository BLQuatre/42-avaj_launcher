package fr.cauvray.launcher.exceptions;

public class AicraftCreationFailedException extends Exception {
	public AicraftCreationFailedException(String type, String name) {
		super("Unable to create aircraft of type: " + type + " with name: " + name);
	}
}
