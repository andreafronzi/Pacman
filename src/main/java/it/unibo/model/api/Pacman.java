package it.unibo.model.api;

public interface Pacman {

    void updatePosition();

    void setSpeed(SpeedVector vel);

    Position getPosition();

}
