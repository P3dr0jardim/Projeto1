import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletsBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends FallingObjects
{
    /**
     * Act - do whatever the BulletsBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Health(String image, String type){
        super(image, type);
        setImage(image);
        getImage().scale(25,25);
    }
    
    public void act() 
    {
        movement();
        hitTheEdge();
    }   
}
