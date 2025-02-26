package it.unibo.controller.api;


/**
 * this interface rapresente the controller component of the application
 */
public interface Controller {

    /**
     * il seguente metodo permette il movimento verso il basso
     */
    boolean moveDown();
    
    /**
     * il seguente metodo permette il movimetno verso l'alto
     */
    boolean moveUp();
    
    /**
     * il seguente metodo permette il movimento verso destra
     */
    boolean moveRight();
    

    /**
     * il seguente metodo permetto il movimento verso sinistra
     */
    boolean moveLeft();

    /**
     * il seguente metodo permette di rendere visibile la GUI 
     */
    void start();

}
