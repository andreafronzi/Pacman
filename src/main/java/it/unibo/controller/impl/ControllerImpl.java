package it.unibo.controller.impl;

import java.util.ResourceBundle.Control;

import it.unibo.controller.api.Controller;
import it.unibo.model.api.Context;
import it.unibo.model.api.Position;
import it.unibo.model.api.SpeedVectorFactory;
import it.unibo.model.impl.ContextImpl;
import it.unibo.model.impl.PositionImpl;
import it.unibo.model.impl.SpeedVectorFactoryImpl;
import it.unibo.view.api.GameView;
import it.unibo.view.impl.GameViewImpl;

public class ControllerImpl implements Controller{

    private static final Position DEFAULTPOSITION = new PositionImpl(0, 0);

    private final SpeedVectorFactory speedFactory;
    private final Context context;
    private final GameView view;

    public ControllerImpl() {
        this.speedFactory = new SpeedVectorFactoryImpl();
        this.context = new ContextImpl();
        this.view = new GameViewImpl();
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

    @Override
    public void start() {
        this.view.open();
    }
    
    public static void main(final String... args) {
        final Controller controller = new ControllerImpl();
        controller.start();
    }
}
