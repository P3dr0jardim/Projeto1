import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Bullet(int rotation){
        System.out.println("rotation"+rotation);
        setRotation(rotation);
        speed = 15;
        
        setImage(new GreenfootImage(10,2));
        getImage().setColor(Color.BLACK);
        getImage().fillRect(0,0,10,2);
    }
    
    public void act() 
    {
        move(speed);
        hitTheEdge();
    }  
    
    public void hitTheEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

}
