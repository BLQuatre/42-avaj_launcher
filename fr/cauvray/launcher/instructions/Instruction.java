package fr.cauvray.launcher.instructions;

import fr.cauvray.launcher.flyable.FlyableType;
import fr.cauvray.launcher.utils.Coordinates;

public class Instruction {
	private final FlyableType flyableType;
	private final String flyableName;
	private final Coordinates flyableCoords;

	public Instruction(FlyableType flyableType, String flyableName, Coordinates flyableCoords) {
		this.flyableType = flyableType;
		this.flyableName = flyableName;
		this.flyableCoords = flyableCoords;
	}

	public FlyableType getFlyableType() {
		return this.flyableType;
	}

	public String getFlyableName() {
		return this.flyableName;
	}

	public Coordinates getFlyableCoords() {
		return this.flyableCoords;
	}
}
