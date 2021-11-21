import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int count, health = 1;
    Player1 player1;
    Player2 player2;
    Score score;
    public Alien(Player1 player1, Player2 player2, Score score){
        this.player1 = player1;
        this.player2 = player2;
        this.score = score;
        setImage("alien1.png");
         getImage().scale(80,80);
    }
    public void act() 
    {
         count++;
         moveAround();
         hitByBullet();
    } 
    
    public void moveAround(){
        move(1);
        double player1Distance = Math.sqrt(Math.pow(getX()-player1.getX(),2)+Math.pow(getY()-player1.getY(),2));
        double player2Distance = Math.sqrt(Math.pow(getX()-player2.getX(),2)+Math.pow(getY()-player2.getY(),2));
        
        System.out.println("player1Distance"+player1Distance);
        System.out.println("player2Distance"+player2Distance);
        
        if(player1Distance < player2Distance){
            turnTowards(player1.getX(), player1.getY());
        }else{
            turnTowards(player2.getX(), player2.getY());
        }

        
    }
    
    public void hitByBullet(){
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            health--;
            
            getWorld().removeObject(bullet);
        }
        
        if(health == 0){
            score.score++;
            getWorld().removeObject(this);
            
        }
    }
    
}
