package it.unibo.model.api;

public interface Context {

    Boundary getBoundary();

    Position getPacmanPosition();

    Pacman getPacman();
}
