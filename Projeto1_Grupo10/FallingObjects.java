import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Superclasse
 */
public class FallingObjects extends Actor
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 2;
    private String image;
    private String type;
    
    public FallingObjects(String image, String type){
        this.image = image;
        this.type = type;
    }
    
    public void act() 
    {
        movement();
        hitTheEdge();
    }    
    
    /**
     * Este metodo serve para mover os 
     * objetos na vertical
     */
    public void movement(){
        setLocation(getX() ,getY() + speed); 
    }
    
     /**
     * Este metodo serve para remover o objeto quando o mesmo tocar nos limites 
     * do mundo
     */
    public void hitTheEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Getter type
     */
    public String getType(){
        return type;
    }
    
    /**
     * Getter speed
     */
    public int getSpeed(){
        return speed;
    }
}
