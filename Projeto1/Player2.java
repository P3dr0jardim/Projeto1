import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    private GreenfootImage player1Back, player1Front, player1DownLeft, player1DownRight, player1Left, player1Right, player1UpperLeft, player1UpperRight;
    
    private int reloadtime = 10,
        magSize = 1000,
        currentAmmo = magSize,
        charWidth = getImage().getWidth()-25;
        
    private int back = 1, front = 2, downLeft = 3, downRight = 4, left = 5, right = 6, upperLeft = 7, upperRight = 8;
    private int position, rotation, time;
    private Boolean intersectAlien=false;
    private Boolean intersectMeteor=false;
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public Player2()
    {
        GreenfootImage player2Image = getImage();
        player2Image.scale(100,100);
        setImage(player2Image);
    }
    
    public void act() 
    {
        time++;
        moveAround();
        fireBullet();
        isHitByAlien();
        isHitByMeteor();
        //loseGame();
    }   
    
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-2);
          
            position = back;
            rotation = 90;
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+2);
          
            position = front;
            rotation = 270;
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-2,getY());
         
            position = left;
            rotation = 180;
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+2,getY());
            
            position = right;
            rotation = 0;
        }
        if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up")){
           setLocation(getX()-2,getY()-2);
          
           position = upperLeft;
           rotation = 225;
        }
        if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up")){
           setLocation(getX()+2,getY()-2);
           
           position = upperRight;
           rotation = 315;
           
        }
        if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down")){
           setLocation(getX()-2,getY()+2);
           
           position = downLeft;
           rotation = 135;
        }
        if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down")){
           setLocation(getX()+2,getY()+2);
          
           position = downRight;
           rotation = 45;
        }
    }
    
    public void fireBullet(){
        if(Greenfoot.isKeyDown("0")){
            if(currentAmmo > 0){
                currentAmmo--;
                    getWorld().addObject(new Bullet(rotation), getX(), getY());
            }
        }
    }
    
     public void isHitByAlien(){
                        Actor alien = getOneObjectAtOffset(0, 0, Alien.class);
                    if(alien!=null){
                        intersectAlien= true ;   
                        
                    }else{
                        intersectAlien = false;
                }
                
                
}
    
       public void isHitByMeteor(){
           Actor meteor = getOneObjectAtOffset(0, 0, Meteor.class);
           if(meteor!=null){
               intersectMeteor = true ;
               getWorld().removeObject(meteor);
           }else{
               intersectMeteor = false;
        }
    }
    
    public boolean getIntersectingAlien(){
        return intersectAlien;
    }
    
    public boolean getIntersectingMeteor(){
        return intersectMeteor;
    }
    
    public void loseGame(){
        if(isTouching(Alien.class)){
            getWorld().showText("You Lose! - You lasted " + (time/60) + "seconds!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
