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
    
    /**
     * Construtor
     */
    public BlackHoles(){
        /**
         * Adicionamos a imagem ao objeto
         */
        setImage("blackhole.png");
        getImage().scale(80,80);
    }
    
    public void act() 
    {
        /**
         * Para tornar o buraco negro mais realista adicionamos uma rotação ao objeto
         */
        getImage().rotate(5);
    }    
}
