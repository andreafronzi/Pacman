package it.unibo.model.impl;

import it.unibo.model.api.Boundary;
import it.unibo.model.api.Context;
import it.unibo.model.api.SpeedVectorFactory;
import it.unibo.model.api.Pacman;
import it.unibo.model.api.Position;

public class ContextImpl implements Context{

    private static final Position DEFAULTPOSITION = new PositionImpl(0, 0);
    
    private final Pacman pacman;
    private final Boundary bounds;

    public ContextImpl() {
        this.bounds = new BoundaryImpl(-10, -10, 10, 10);
        this.pacman = new PacmanImpl(DEFAULTPOSITION, this);
    }

    @Override
    public Boundary getBoundary() {
        return this.bounds;
    }

    public Position getPacmanPosition() {
        return this.pacman.getPosition();
    }

    @Override
    public Pacman getPacman() {
        return this.pacman;
    }

}
