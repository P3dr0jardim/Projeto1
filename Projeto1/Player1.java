import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    private GreenfootImage player1Back, player1Front, player1DownLeft, player1DownRight, player1Left, player1Right, player1UpperLeft, player1UpperRight;
    
    private int reloadtime = 10,
        magSize = 1000,
        currentAmmo = magSize,
        charWidth = getImage().getWidth()-25;
        
    private int back = 1, front = 2, downLeft = 3, downRight = 4, left = 5, right = 6, upperLeft = 7, upperRight = 8;
    private int position, rotation, time;
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public Player1()
    {
        GreenfootImage player1Image = getImage();
        player1Image.scale(100,100);
        setImage(player1Image);
        player1Back = new GreenfootImage("player1-back.png");
        player1Back.scale(100,100);
        player1Front = new GreenfootImage("player1-front.png");
        player1Front.scale(100,100);
        player1DownLeft = new GreenfootImage("player1-down-left.png");
        player1DownLeft.scale(100,100);
        player1DownRight = new GreenfootImage("player1-down-right.png");
        player1DownRight.scale(100,100);
        player1Left = new GreenfootImage("player1-left.png");
        player1Left.scale(100,100);
        player1Right = new GreenfootImage("player1-right.png");
        player1Right.scale(100,100);
        player1UpperLeft = new GreenfootImage("player1-upper-left.png");
        player1UpperLeft.scale(100,100);
        player1UpperRight = new GreenfootImage("player1-upper-right.png");
        player1UpperRight.scale(100,100);
        
    }
    
    public void act() 
    {
        time++;
        moveAround();
        fireBullet();
        isHitByAlien();
    }   
    
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-2);
            setImage(player1Back);
            position = back;
            rotation = 270;
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+2);
            setImage(player1Front);
            position = front;
            rotation = 90;
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-2,getY());
            setImage(player1Left);
            position = left;
            rotation = 180;
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+2,getY());
            setImage(player1Right);
            position = right;
            rotation = 0;
        }
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w")){
           setLocation(getX()-2,getY()-2);
           setImage(player1UpperLeft); 
           position = upperLeft;
           rotation = 225;
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w")){
           setLocation(getX()+2,getY()-2);
           setImage(player1UpperRight); 
           position = upperRight;
           rotation = 315;
           
        }
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")){
           setLocation(getX()-2,getY()+2);
           setImage(player1DownLeft); 
           position = downLeft;
           rotation = 135;
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")){
           setLocation(getX()+2,getY()+2);
           setImage(player1DownRight); 
           position = downRight;
           rotation = 45;
        }
    }
    
    public void fireBullet(){
        if(Greenfoot.isKeyDown("g")){
            if(currentAmmo > 0){
                currentAmmo--;
                    getWorld().addObject(new Bullet(rotation), getX(), getY());
            }
        }
    }
    
    public boolean isHitByAlien(){
        Actor alien = getOneObjectAtOffset(0, 0, Alien.class);
        if(alien!=null){
            return true;
        }else{
            return false;
        }
    }
}
