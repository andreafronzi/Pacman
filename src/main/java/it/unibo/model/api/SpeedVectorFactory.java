package it.unibo.model.api;


/**
 * SpeedVectorFactory deal with Abstract Factory for creation of several SpeedVector
 */
public interface SpeedVectorFactory {

    /**
     * 
     * @return new SpeedVector whose direction is Up (0,1)
     */
    SpeedVector getNorthSpeedVector(); 

    /**
     * 
     * @return new SpeedVector whose direction is Down (0,-1)
     */
    SpeedVector getSouthSpeedVector();

    /**
     * 
     * @return new SpeedVector whose direction is Left (-1,0)
     */
    SpeedVector getWestSpeedVector();

    /**
     * 
     * @return new SpeedVector whose direction is Right (1,0)
     */
    SpeedVector getEastSpeedVector();

    /**
     * 
     * @return deafault SpeedVector: no movement
     */
    SpeedVector getDefaultSpeedVector();
}
