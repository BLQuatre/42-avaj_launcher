package fr.cauvray.launcher.instructions;

import fr.cauvray.launcher.exceptions.InvalidIterationsNumberException;
import fr.cauvray.launcher.exceptions.InvalidScenarioInstructionHeightException;
import fr.cauvray.launcher.exceptions.InvalidScenarioInstructionSizeException;
import fr.cauvray.launcher.flyable.FlyableType;
import fr.cauvray.launcher.utils.Coordinates;
import fr.cauvray.launcher.utils.CoordinatesUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructionsManager {
	private int iterations = -1;
	private final ArrayList<Instruction> instructions = new ArrayList<>();

	public InstructionsManager(String fileName) {
		File file = new File(fileName);

		try (Scanner fileScanner = new Scanner(file)) {

			if (fileScanner.hasNextLine()) {
				String firstLine = fileScanner.nextLine();
				this.iterations = Integer.parseInt(firstLine);
				if (this.iterations < 0) {
					throw new InvalidIterationsNumberException(firstLine);
				}
			}

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				String[] splittedLine = line.split(" ");
				if (splittedLine.length != 5) {
					throw new InvalidScenarioInstructionSizeException(line, splittedLine.length);
				}

				FlyableType flyableType = FlyableType.valueOf(splittedLine[0]);
				String name = splittedLine[1];

				int longitude = Integer.parseInt(splittedLine[2]);
				int latitude = Integer.parseInt(splittedLine[3]);
				int height = Integer.parseInt(splittedLine[4]);
				if (height < 0 || height > 100) {
					throw new InvalidScenarioInstructionHeightException(height);
				}

				Coordinates coordinates = CoordinatesUtils.getCoordinates(longitude, latitude, height);

				this.instructions.add(new Instruction(flyableType, name, coordinates));
			}
		} catch (FileNotFoundException
				 | InvalidScenarioInstructionSizeException
				 | InvalidIterationsNumberException
				 | InvalidScenarioInstructionHeightException ex) {
			System.out.println("Error: " + ex.getMessage());

		} catch (NumberFormatException ex) {
			System.out.println("Error: Invalid number:" + ex.getMessage());
		}
	}

	public int getIterations() {
		return this.iterations;
	}

	public ArrayList<Instruction> getInstructions() {
		return this.instructions;
	}
}
