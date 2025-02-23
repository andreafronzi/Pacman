package it.unibo.model.impl;

import it.unibo.model.api.Boundary;

public record BoundaryImpl(int x0, int y0, int x1, int y1) implements Boundary{

    @Override
    public int X0() {
       return this.x0();
    }

    @Override
    public int Y0() {
        return this.y0();
    }

    @Override
    public int X1() {
        return this.x1();
    }

    @Override
    public int Y1() {
        return this.y1();
    }
}