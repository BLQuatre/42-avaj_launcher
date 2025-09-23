package fr.cauvray.launcher.scenarios;

import fr.cauvray.launcher.flyable.Flyable;

import java.util.Collection;

public record Scenario(int iterations, Collection<Flyable> flyables) {}
