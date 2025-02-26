package it.unibo.model.impl;

import java.util.logging.Logger;

import it.unibo.model.api.Boundary;
import it.unibo.model.api.Context;
import it.unibo.model.api.Pacman;
import it.unibo.model.api.SpeedVector;
import it.unibo.model.api.Position;

public class PacmanImpl implements Pacman,Runnable{

    private static final long DELAY = 500L;

    private Position actualPosition;
    private SpeedVector actualSpeed;
    private final Boundary bounds;
    private long lastUpdate;
    
    public PacmanImpl(final Position position, final Context ctx) {
        this.actualPosition = position;
        this.bounds = ctx.getBoundary();
    }


    private void updateTime(final long time) {
        this.lastUpdate = time;
    }

    @Override
    public void setSpeed(final SpeedVector vel) {
        this.actualSpeed = vel;
    }    

    @Override
    public void updatePosition() {
        final long actualTime = System.currentTimeMillis();
        final long dt = actualTime - lastUpdate;
        updateTime(actualTime);
        this.actualPosition.sum(this.actualSpeed.URM((v,t) -> { return new PositionImpl(((int)(v.X() * t)), ((int)(v.Y() * t))); },
                                        Long.valueOf(dt)));
        verifyBorderTouch();
    }
    
    private void verifyBorderTouch() {
        if(this.actualPosition.X() < bounds.X0()) {
            this.actualPosition = new PositionImpl(bounds.X0(), this.actualPosition.Y());
        } else if (this.actualPosition.X() > bounds.X1()) {
            this.actualPosition = new PositionImpl(bounds.X1(), this.actualPosition.Y());
        } else if(this.actualPosition.Y() < bounds.Y0()) {
            this.actualPosition = new PositionImpl(this.actualPosition.X(), bounds.Y0());
        } else if (this.actualPosition.Y() > bounds.Y1()) {
            this.actualPosition = new PositionImpl(this.actualPosition.Y(), this.bounds.Y0());
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("ciao");
            updatePosition();
            try {
                Thread.sleep(DELAY);
            } catch (Exception e) {
                Logger myLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
                myLogger.info("error");
            }
        }
    }


    @Override
    public Position getPosition() { 
        return this.actualPosition;
    }
}
