import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletsBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Subclasse da superclasse FallingObjects
 */
public class Health extends FallingObjects
{
    /**
     * Act - do whatever the BulletsBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int horizontalMove;
    
    public Health(String image, String type, int horizontalMove ){
        super(image, type);
        /**
         * Para se tornar mais dificil de apanhar uma recarga de vida 
         * colocamos esta variavel 
         * para o objeto poder se mover na horizontal
         * assim ele desce na diagonal
         */
        this.horizontalMove = horizontalMove;
        setImage(image);
        getImage().scale(25,25);
    }
    
    public void act() 
    {
        movement(horizontalMove);
        hitTheEdge();
    }   
    
    /**
     * Método para o movimento da recarga da vida
     * Aqui foi feito overload ao método movement, para o objeto poder se descolar na diagonal
     */
    public void movement(int horizontalMove){
        setLocation(getX() + horizontalMove ,getY() + getSpeed()); 
    }
}
