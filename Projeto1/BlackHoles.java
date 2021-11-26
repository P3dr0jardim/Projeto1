import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackHoles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackHoles extends Actor
{
    /**
     * Act - do whatever the BlackHoles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //private double height, width;
    public BlackHoles(){
        setImage("blackhole.png");
        getImage().scale(80,80);
    }
    
    public void act() 
    {
        getImage().rotate(5);
    }    
    
    // public void blackHolePosition(){
        // width = getX();
        // height = getY();
    // }
    
    // public double getBlackHoleHeight(){
        // return height;
    // }
    
    // public double getBlackHoleWidth(){
        // return width;
    // }

}
