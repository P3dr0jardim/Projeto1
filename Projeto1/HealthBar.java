
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
    
    private int health;
    private Player player;
    public HealthBar(Player player){
        this.player = player;
    }
    
    public HealthBar(){ 
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    
    public void act() 
    {
        
        System.out.println("Health " + health);
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,getHealth(),10);
        loseHealth();
        gainHealth();
        isHealthZero();
    }
    
    public void loseHealth(){
        if(health > 0){
            if(player.getIntersectingAlien()){
            health--;
            };
            
            if(player.getIntersectingMeteor()){
            health = health - 25;
            };
        };
    }
    
    public void isHealthZero(){
        if(health == 0){
            player.isPlayerDead(true);
        }else{
            player.isPlayerDead(false);
        }
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public void gainHealth(){
       if(player.getIntersectingHealthSuply()){
            health = health + 25;
        };
    }
}
