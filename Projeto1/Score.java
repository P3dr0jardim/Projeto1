import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Stats
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int score;
    
    public Score(int size, String label){
        super(size, label);
        
        setImage(new GreenfootImage(label + ": " + score, size, Color.BLACK, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
        setImage(new GreenfootImage(getLabel() + ": " + score, getSize(), Color.BLACK, new Color (0,0,0,0)));

    }
    
    public int getScore(){
        return score;
    }
    
    public int increaseScore(){
        return score++;
    }
}
