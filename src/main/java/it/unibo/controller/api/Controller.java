package it.unibo.controller.api;


/**
 * this interface rapresente the controller component of the application
 */
public interface Controller {

    /**
     * il seguente metodo permette il movimento verso il basso
     */
    public boolean moveDown();
    
    /**
     * il seguente metodo permette il movimetno verso l'alto
     */
    public boolean moveUp();
    
    /**
     * il seguente metodo permette il movimento verso destra
     */
    public boolean moveRight();
    

    /**
     * il seguente metodo permetto il movimento verso sinistra
     */
    public boolean moveLeft();

}
