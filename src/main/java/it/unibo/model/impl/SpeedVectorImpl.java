package it.unibo.model.impl;

import java.util.function.BiFunction;
import it.unibo.model.api.Position;
import it.unibo.model.api.SpeedVector;

public class SpeedVectorImpl implements SpeedVector{

    private final int x;
    private final int y;

    public SpeedVectorImpl(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Position URM(BiFunction<SpeedVector, Long, Position> converter, final Long dt) {
        return converter.apply(this, dt);
    }

    @Override
    public int X() {
        return this.x;
    }

    @Override
    public int Y() {
        return this.y;
    }


    


}
