import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entities extends Actor
{
    /**
     * Act - do whatever the Entities wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        isTouchingBlackHole();
    }  
    
    public void isTouchingBlackHole() {
        Actor blackHole = getOneObjectAtOffset(0, 0, BlackHoles.class);
        if (blackHole != null) {
            if(getX() > 100 && getX() < 120 && getY() > 600 && getY() < 620){
                setLocation(601, 101);
            }else if(getX() > 700 && getX() < 720 &&  getY() > 100 && getY() < 120){
                setLocation(101, 701);
            }
        }
    }
}
