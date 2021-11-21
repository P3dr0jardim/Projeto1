import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int health = 50;
    
    public void HealthBar(){ 
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    
    public void act() 
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer1().getX(), myWorld.getPlayer1().getY() - 40);
        loseHealth();
    }  
    
    public void loseHealth(){
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer1().isHitByAlien()){
            health--;
        };
    }
}
