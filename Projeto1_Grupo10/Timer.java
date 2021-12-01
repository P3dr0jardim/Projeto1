import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * A classe score é uma subclasse da superclasse Stats
 */

public class Timer extends Stats
{   
    private int time = 7200;
    private boolean timeOver = false;
    public Timer(int size, String label){
        super(size, label);
        setImage(new GreenfootImage(label + ": " + (time)/60, size, Color.WHITE, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
        timer();
        setImage(new GreenfootImage(getLabel() + ": " + (time)/60, getSize(), Color.WHITE, new Color (0,0,0,0)));
        isTimeOver();
    }  
    
    /**
     * Getter time
     */
    public int getTime(){
        return time;
    }
    
    /**
     * Método para saber quando o timer acabou
     */
    public void isTimeOver(){
        if(time == 0){
            timeOver = true;
        }else{
            timeOver = false;
        }
    }
    
    /**
     * O metodo devolve se o timer ja acabou ou nao
     */
    public boolean getTimeOver(){
        return timeOver;
    }
    
    /**
     * Metodo serve para decrementar o tempo
     */
    public void timer(){
        if(time > 0){
            time--;
        }
    }
}
