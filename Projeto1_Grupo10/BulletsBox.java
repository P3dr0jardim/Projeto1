import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletsBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Subclass da superclasse FallingObjects
 */
public class BulletsBox extends FallingObjects
{
    /**
     * Act - do whatever the BulletsBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BulletsBox(String image, String type){
        super(image, type);
        setImage(image);
        getImage().scale(25,25);
    }
    
    public void act() 
    {
        /**
         * Aqui apenas usamos os metodos da superclasse FallingObjects
         */
        movement();
        hitTheEdge();
    }   
}
