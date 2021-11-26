import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletsInfo extends Stats
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int bullets;
    private Player player;
    public BulletsInfo(int size, String label, Player player){
        super(size, label);
        this.player = player;
        setImage(new GreenfootImage(label + ": " + bullets, size, Color.BLACK, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
        setImage(new GreenfootImage(getLabel() + ": " + bullets, getSize(), Color.BLACK, new Color (0,0,0,0)));
    }    
    
    public int getBullets(){
        return bullets;
    }
    
     public void setBullets(int bullets){
        this.bullets = bullets;
    }
    
    public int decreaseBullets(){
        return bullets--;
    }
    
    public int increaseBullets(){
        return bullets = bullets + 25;
    }
}
