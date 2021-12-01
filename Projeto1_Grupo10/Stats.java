import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Superclasse 
 */
public class Stats extends Actor
{
    /**
     * Act - do whatever the Stats wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int size;
    private String label;
    
    /**
     * Construtor
     */
    public Stats(int size, String label){
        this.size = size;
        this.label = label;
    }
    
    /**
     * Getter size
     */
    public int getSize(){
        return size;
    }
    
    /**
     * setter size
     */
    public void setSize(int statSize){
        this.size = statSize;
    }
    
    /**
     * getter label
     */
    public String getLabel(){
        return label;
    }
    
    /**
     * setter label
     */
    public void setLabel(String statLabel){
        this.label = statLabel;
    }
    
    public void act() 
    {
    }    
}
