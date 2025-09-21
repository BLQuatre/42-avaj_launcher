package fr.cauvray.launcher;

import fr.cauvray.launcher.instructions.InstructionsManager;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java fr.cauvray.launcher.Main <scenario>");
			return;
		}

		InstructionsManager instructionsManager = new InstructionsManager(args[0]);
	}
}
