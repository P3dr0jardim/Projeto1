import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends FallingObjects
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    
    public Meteor(String image, String type){
        super(image, type);
        setImage(image);
        getImage().scale(100,100);
    }
    
    public void act() 
    {
        animateMeteor();
        movement();
        hitTheEdge();
    }    
    
}
