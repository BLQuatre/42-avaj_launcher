package fr.cauvray.launcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutfileWriter {
	private static final File outfile = new File("simulation.txt");

	private static final ArrayList<String> lines = new ArrayList<>();

	public static void createFile() throws IOException {
		try {
			if (outfile.exists()) outfile.delete();

			if (!outfile.createNewFile()) {
				throw new IOException("Unable to create simulation.txt file");
			}
		} catch (Exception e) {
			throw new IOException("Unable to create simulation.txt file");
		}
	}

	public static void addLine(String line) {
		lines.add(line + "\n");
	}

	public static void writeToFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
		for  (String line : lines) {
			writer.write(line);
		}
		writer.close();
	}
}
