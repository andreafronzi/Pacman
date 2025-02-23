package it.unibo.model.impl;

import it.unibo.model.api.Position;

public class PositionImpl implements Position{

    private int x;
    private int y;
    
    public PositionImpl(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int X() {
        return this.x;
    }

    @Override
    public int Y() {
        return this.y;
    }

    @Override
    public void sum(final Position position) {
        this.x = this.x + position.X();
        this.y = this.y + position.Y();
    }


}
