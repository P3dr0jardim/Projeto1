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
        moveAround();
    }   
    
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-2);
            setImage(player1Back);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+2);
            setImage(player1Front);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-2,getY());
            setImage(player1Left);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+2,getY());
            setImage(player1Right);
        }
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w")){
           setLocation(getX()-2,getY()-2);
           setImage(player1UpperLeft); 
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w")){
           setLocation(getX()+2,getY()-2);
           setImage(player1UpperRight); 
        }
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")){
           setLocation(getX()-2,getY()+2);
           setImage(player1DownLeft); 
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")){
           setLocation(getX()+2,getY()+2);
           setImage(player1DownRight); 
        }
    }
}
