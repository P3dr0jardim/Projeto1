import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Subclass da superclasse FallingObjects
 */
public class Meteor extends FallingObjects
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int speed = 2,  animateMeteor = 0, animateSpeed = 5, count;
    
    public Meteor(String image, String type){
        super(image, type);
        setImage(image);
        getImage().scale(100,100);
    }
    
    public void act() 
    {
        count++;
        animateMeteor();
        movement();
        hitTheEdge(); 
    }    
    
    /**
     * Método para mover a imagem do meteorito
     * Deixando ela assim mais real
     */
    public void animateMeteor(){
        if(count % animateSpeed == 0){
            if(animateMeteor > 2){
                animateMeteor = 0;
            }
            setImage(getType() + animateMeteor + ".png");
            getImage().scale(100,100);
            animateMeteor++;
        }
    }
    
    /**
     * Método para explosão do meteoro quando toca no limite do mundo
     * Aqui foi feito override ao método hitTheEdge
     */
    public void hitTheEdge(){
        if(isAtEdge()){
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
