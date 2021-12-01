import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * A classe score é uma subclasse da superclasse Stats
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
        
        setImage(new GreenfootImage(label + ": " + bullets, size, Color.WHITE, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
        setImage(new GreenfootImage(getLabel() + ": " + bullets, getSize(), Color.WHITE, new Color (0,0,0,0)));
    }    
    
    /**
     * getter bullets
     */
    public int getBullets(){
        return bullets;
    }
    
    /**
     * setter bullets
     */
     public void setBullets(int bullets){
        this.bullets = bullets;
    }
    
    /**
     * decrementa as balas
     */
    public int decreaseBullets(){
        return bullets--;
    }
    
    /**
     * incrementa as balas em 25 unidades
     */
    public int increaseBullets(){
        return bullets = bullets + 25;
    }
}
