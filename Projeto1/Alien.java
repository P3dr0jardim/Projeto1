import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Enemy
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Alien(Player player1, Player player2, Score score){
        super(player1, player2, score);
        setImage("alien1.png");
        getImage().rotate(180);
        getImage().scale(80,80);
    }
    
    public void act() 
    {
        moveAround();
        hitByBullet();
        isTouchingBlackHole();
    }    
}
