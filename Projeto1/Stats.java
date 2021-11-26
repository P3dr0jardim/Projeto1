import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stats extends Actor
{
    /**
     * Act - do whatever the Stats wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int size;
    private String label;
    public Stats(int size, String label){
        this.size = size;
        this.label = label;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int statSize){
        this.size = statSize;
    }
    
    public String getLabel(){
        return label;
    }
    
    public void setSize(String statLabel){
        this.label = statLabel;
    }
    
    public void act() 
    {
        
    }    
}
