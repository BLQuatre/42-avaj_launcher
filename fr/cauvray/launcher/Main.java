package fr.cauvray.launcher;

import fr.cauvray.launcher.exceptions.InvalidScenarioInstructionException;
import fr.cauvray.launcher.instructions.Instruction;
import fr.cauvray.launcher.instructions.InstructionsManager;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java fr.cauvray.launcher.Main <scenario>");
			return;
		}

		InstructionsManager instructionsManager;
		try {
			instructionsManager = new InstructionsManager(args[0]);
		} catch (FileNotFoundException | InvalidScenarioInstructionException ex) {
			System.err.println("Error: " + ex.getMessage());
			System.exit(1);
			return;
		}

		System.out.println("Iterations: " + instructionsManager.getIterations());
		System.out.println("Instructions:");
		for (Instruction  instruction : instructionsManager.getInstructions()) {
			System.out.println("Long: " + instruction.getFlyableCoords().getLongitude() +
					", Lat: " + instruction.getFlyableCoords().getLatitude() +
					", H: " + instruction.getFlyableCoords().getHeight() +
					", Type: " + instruction.getFlyableType().name() +
					", Name: " + instruction.getFlyableName()
			);
		}
	}
}
