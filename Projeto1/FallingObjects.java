import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObjects extends Actor
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int animateMeteor = 0;
    private int animateSpeed = 5;
    private int meteorSpeed = 2;
    private int count;
    private String image;
    private String type;
    
    public FallingObjects(String image, String type){
        this.image = image;
        this.type = type;
    }
    
    public void act() 
    {
        count++;
        animateMeteor();
        movement();
        hitTheEdge();
    }    
    
    public void movement(){
        setLocation(getX(),getY() + meteorSpeed); 
    }
    
    public void animateMeteor(){
        if(count % animateSpeed == 0){
            if(animateMeteor > 2){
                animateMeteor = 0;
            }
            setImage(type + animateMeteor + ".png");
            getImage().scale(100,100);
            animateMeteor++;
        }
    }
    
    public void hitTheEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
