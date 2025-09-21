package fr.cauvray.launcher.exceptions;

public class InvalidIterationsNumberException extends Exception {
	public InvalidIterationsNumberException(String value) {
		super("Invalid iterations number: " + value);
	}
}
