
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Entities {
    
    private GreenfootImage playerBack, playerFront, playerDownLeft, playerDownRight, playerLeft, playerRight, playerUpperLeft, playerUpperRight, playerDead;

    private int reloadtime = 10,charWidth = getImage().getWidth() - 25;

    private int back = 1, front = 2, downLeft = 3, downRight = 4, left = 5, right = 6, upperLeft = 7, upperRight = 8;
    private int position, rotation, time;
    private Boolean intersectAlien = false;
    private Boolean intersectMeteor = false;
    private Boolean intersectHealthSuply = false;
    private Boolean isDead = false;
    private int playerId;
    private final int player1 = 1;
    private final int player2 = 2;
    private HealthBar healthBar;
    private BulletsInfo bulletsInfo;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Player(int playerId, BulletsInfo bulletsInfo, HealthBar healthBar) {
        super();
        this.playerId = playerId;
        this.bulletsInfo = bulletsInfo;
        this.healthBar = healthBar;
        
        GreenfootImage playerImage = new GreenfootImage("player" + playerId + ".png");
        playerImage.scale(100, 100);
        setImage(playerImage);
        playerBack = new GreenfootImage("player" + playerId + "-back.png");
        playerBack.scale(100, 100);
        playerFront = new GreenfootImage("player" + playerId + "-front.png");
        playerFront.scale(100, 100);
        playerDownLeft = new GreenfootImage("player" + playerId + "-down-left.png");
        playerDownLeft.scale(100, 100);
        playerDownRight = new GreenfootImage("player" + playerId + "-down-right.png");
        playerDownRight.scale(100, 100);
        playerLeft = new GreenfootImage("player" + playerId + "-left.png");
        playerLeft.scale(100, 100);
        playerRight = new GreenfootImage("player" + playerId + "-right.png");
        playerRight.scale(100, 100);
        playerUpperLeft = new GreenfootImage("player" + playerId + "-upper-left.png");
        playerUpperLeft.scale(100, 100);
        playerUpperRight = new GreenfootImage("player" + playerId + "-upper-right.png");
        playerUpperRight.scale(100, 100);
        playerDead = new GreenfootImage("player" + playerId + "dead.png");
        playerDead.scale(100, 100);
    }

    public void act() {    
        time++;
        if(!isDead){
            moveAround();
            fireBullet();
        }
        isHitByAlien();
        isHitByMeteor();
        pickHealthSuply();
        pickAmmoBox();
        dead();
        isTouchingBlackHole();
    }

    public void moveAround() {
           switch (playerId) {
            case player1:
                if (Greenfoot.isKeyDown("w")) {
                    setLocation(getX(), getY() - 2);
                    setImage(playerBack);
                    position = back;
                    rotation = 270;
                }
                if (Greenfoot.isKeyDown("s")) {
                    setLocation(getX(), getY() + 2);
                    setImage(playerFront);
                    position = front;
                    rotation = 90;
                }
                if (Greenfoot.isKeyDown("a")) {
                    setLocation(getX() - 2, getY());
                    setImage(playerLeft);
                    position = left;
                    rotation = 180;
                }
                if (Greenfoot.isKeyDown("d")) {
                    setLocation(getX() + 2, getY());
                    setImage(playerRight);
                    position = right;
                    rotation = 0;
                }
                if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w")) {
                    setLocation(getX() - 2, getY() - 2);
                    setImage(playerUpperLeft);
                    position = upperLeft;
                    rotation = 225;
                }
                if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w")) {
                    setLocation(getX() + 2, getY() - 2);
                    setImage(playerUpperRight);
                    position = upperRight;
                    rotation = 315;

                }
                if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")) {
                    setLocation(getX() - 2, getY() + 2);
                    setImage(playerDownLeft);
                    position = downLeft;
                    rotation = 135;
                }
                if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")) {
                    setLocation(getX() + 2, getY() + 2);
                    setImage(playerDownRight);
                    position = downRight;
                    rotation = 45;
                }
                break;
                
                case player2:
                if (Greenfoot.isKeyDown("up")) {
                    setLocation(getX(), getY() - 2);
                    setImage(playerBack);
                    position = back;
                    rotation = 270;
                }
                if (Greenfoot.isKeyDown("down")) {
                    setLocation(getX(), getY() + 2);
                    setImage(playerFront);
                    position = front;
                    rotation = 90;
                }
                if (Greenfoot.isKeyDown("left")) {
                    setLocation(getX() - 2, getY());
                    setImage(playerLeft);
                    position = left;
                    rotation = 180;
                }
                if (Greenfoot.isKeyDown("right")) {
                    setLocation(getX() + 2, getY());
                    setImage(playerRight);
                    position = right;
                    rotation = 0;
                }
                if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up")) {
                    setLocation(getX() - 2, getY() - 2);
                    setImage(playerUpperLeft);
                    position = upperLeft;
                    rotation = 225;
                }
                if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up")) {
                    setLocation(getX() + 2, getY() - 2);
                    setImage(playerUpperRight);
                    position = upperRight;
                    rotation = 315;

                }
                if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down")) {
                    setLocation(getX() - 2, getY() + 2);
                    setImage(playerDownLeft);
                    position = downLeft;
                    rotation = 135;
                }
                if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down")) {
                    setLocation(getX() + 2, getY() + 2);
                    setImage(playerDownRight);
                    position = downRight;
                    rotation = 45;
                }
                break;
            }
    }

    public void fireBullet() {
        switch (playerId) {
            case player1:
                if (Greenfoot.isKeyDown("g")) {
                    if (bulletsInfo.getBullets() > 0) {
                        bulletsInfo.decreaseBullets();
                        getWorld().addObject(new Bullet(rotation), getX(), getY());
                    }
                }
                break;
            case player2:
                if (Greenfoot.isKeyDown("0")) {
                    if (bulletsInfo.getBullets() > 0) {
                        bulletsInfo.decreaseBullets();
                        getWorld().addObject(new Bullet(rotation), getX(), getY());
                    }
                }
        }


    }

    public void isHitByAlien() {
        Actor alien = getOneObjectAtOffset(0, 0, Alien.class);
        if (alien != null) {
            intersectAlien = true;

        } else {
            intersectAlien = false;
        }
    }
    
    
    
    public void pickHealthSuply() {
        Actor healthSuply = getOneObjectAtOffset(0, 0, Health.class);
        
        if (healthSuply != null) {
            intersectHealthSuply = true;
            getWorld().removeObject(healthSuply);
        } else {
            intersectHealthSuply = false;
        }
    }

    public void isHitByMeteor() {
        Actor meteor = getOneObjectAtOffset(0, 0, Meteor.class);
        if (meteor != null) {
            getWorld().removeObject(meteor);
        } else {
            intersectMeteor = false;
        }
    }
    
    public void pickAmmoBox() {
        Actor bulletsBox = getOneObjectAtOffset(0, 0, BulletsBox.class);
        if (bulletsBox != null) {
            bulletsInfo.increaseBullets();
            getWorld().removeObject(bulletsBox);
        }
    }
    
    public void dead(){
        if(isDead){
            setImage(playerDead);
        }
    }
    
    public void isPlayerDead(Boolean isDead){
        this.isDead = isDead;
    }
    
     public boolean isDead(){
        return isDead;
    }
    
    public boolean getIntersectingAlien() {
        return intersectAlien;
    }

    public boolean getIntersectingMeteor() {
        return intersectMeteor;
    }
    
    public boolean getIntersectingHealthSuply() {
        return intersectHealthSuply;
    } 
}
