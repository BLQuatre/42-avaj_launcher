package fr.cauvray.launcher.instructions;

import fr.cauvray.launcher.exceptions.InvalidScenarioInstructionException;
import fr.cauvray.launcher.flyable.FlyableType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructionsManager {
	private int iterations = -1;
	private final ArrayList<Instruction> instructions = new ArrayList<>();

	private int customParseInt(String str) throws InvalidScenarioInstructionException {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new InvalidScenarioInstructionException("Expected an integer, Got '" + str + "'");
		}
	}

	public InstructionsManager(String fileName) throws FileNotFoundException, InvalidScenarioInstructionException {
		File file = new File(fileName);

		Scanner fileScanner = new Scanner(file);

		if (fileScanner.hasNextLine()) {
			String firstLine = fileScanner.nextLine();
			this.iterations = customParseInt(firstLine);
			if (this.iterations < 0) {
				throw new InvalidScenarioInstructionException("Expected positive number of instructions. Got " + this.iterations);
			}
		}

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			String[] splitLine = line.split(" ");
			if (splitLine.length != 5) {
				throw new InvalidScenarioInstructionException(
						"Expected 5 values (Type Name Longitude Latitude Height)\n" +
								"Got '" + line + "' (" + splitLine.length + " values)"
				);
			}

			FlyableType flyableType;
			try {
				flyableType = FlyableType.valueOf(splitLine[0]);
			} catch (IllegalArgumentException e) {
				throw new InvalidScenarioInstructionException("No aircraft of type '" + splitLine[0] + "' in enum AircraftType!");
			}
			String name = splitLine[1];

			int longitude =customParseInt(splitLine[2]);
			int latitude =customParseInt(splitLine[3]);
			int height = Integer.min(Integer.max(0, customParseInt(splitLine[4])), 100);

			Coordinates coordinates = new Coordinates(longitude, latitude, height);

			this.instructions.add(new Instruction(flyableType, name, coordinates));
		}
	}

	public int getIterations() {
		return this.iterations;
	}

	public ArrayList<Instruction> getInstructions() {
		return this.instructions;
	}
}
