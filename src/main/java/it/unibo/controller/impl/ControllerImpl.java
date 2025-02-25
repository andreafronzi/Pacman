package it.unibo.controller.impl;

import java.util.ResourceBundle.Control;

import it.unibo.controller.api.Controller;
import it.unibo.model.api.Context;
import it.unibo.model.api.Position;
import it.unibo.model.api.SpeedVectorFactory;
import it.unibo.model.impl.ContextImpl;
import it.unibo.model.impl.PositionImpl;
import it.unibo.model.impl.SpeedVectorFactoryImpl;

public class ControllerImpl implements Controller{

    private static final Position DEFAULTPOSITION = new PositionImpl(0, 0);

    private final SpeedVectorFactory speedFactory;
    private final Context context;

    public ControllerImpl() {
        this.speedFactory = new SpeedVectorFactoryImpl();
        this.context = new ContextImpl();
    }

    @Override
    public boolean moveDown() {
        this.context.getPacman().setSpeed(this.speedFactory.getSouthSpeedVector());        
        return true;
    }

    @Override
    public boolean moveUp() {
        this.context.getPacman().setSpeed(this.speedFactory.getNorthSpeedVector());
        return true;
    }

    @Override
    public boolean moveRight() {
        this.context.getPacman().setSpeed(this.speedFactory.getEastSpeedVector());
        return true;    
    }

    @Override
    public boolean moveLeft() {
        this.context.getPacman().setSpeed(this.speedFactory.getWestSpeedVector());
        return true;
    }

}
