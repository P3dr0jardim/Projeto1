import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 650, 1); 
        setBackground("myWorldBackground.jpg");
        populateWorld();
    }
    
    private void populateWorld()
    {
        Player1 player1 = new Player1();
        addObject(player1,getWidth()/10,getHeight()/10);
        Player2 player2 = new Player2();
        addObject(player2,getWidth()/10 + 50,getHeight()/10);
    }
}
