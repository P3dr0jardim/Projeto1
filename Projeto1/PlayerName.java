import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerName extends Stats
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int playerId;
    
    public PlayerName(int size, String label, int playerId){
        super(size, label);
        this.playerId = playerId;
        
        setImage(new GreenfootImage(label + playerId + ": ", size, Color.BLACK, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
    }    
}
