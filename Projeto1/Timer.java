import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Stats
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int time = 7200;
    private boolean timeOver = false;
    public Timer(int size, String label){
        super(size, label);
        setImage(new GreenfootImage(label + ": " + (time)/60, size, Color.BLACK, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
        timer();
        setImage(new GreenfootImage(getLabel() + ": " + (time)/60, getSize(), Color.BLACK, new Color (0,0,0,0)));
        isTimeOver();
    }  
    
    public int getTime(){
        return time;
    }
    
    public void isTimeOver(){
        if(time == 0){
            timeOver = true;
        }else{
            timeOver = false;
        }
    }
    
    public boolean getTimeOver(){
        return timeOver;
    }
    
    public void timer(){
        if(time > 0){
            time--;
        }
        
    }
}
