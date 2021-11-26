import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Entities
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int count, health = 1;
    private Player player1;
    private Player player2;
    private Score score;
    
    public Enemy(Player player1, Player player2, Score score){
        this.player1 = player1;
        this.player2 = player2;
        this.score = score;
    }
    
    public void act() 
    {
         count++;
         moveAround();
         hitByBullet();
         isTouchingBlackHole();
    } 
    
    public void moveAround(){
        move(1);
        double player1Distance = Math.sqrt(Math.pow(getX()-player1.getX(),2)+Math.pow(getY()-player1.getY(),2));
        double player2Distance = Math.sqrt(Math.pow(getX()-player2.getX(),2)+Math.pow(getY()-player2.getY(),2));
        
        if(player1Distance > player2Distance){
            turnTowards(player2.getX(), player2.getY());
        }else{
            turnTowards(player1.getX(), player1.getY());
        } 
        
        if(player1.isDead()){
            turnTowards(player2.getX(), player2.getY());
        }else if(player2.isDead()){
            turnTowards(player1.getX(), player1.getY());
        }
    }
    
    public void hitByBullet(){
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            health--;
            
            getWorld().removeObject(bullet);
        }
        
        if(health == 0){
            score.increaseScore();
            getWorld().removeObject(this);
            
        }
    }
}
