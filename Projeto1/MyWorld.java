import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    //Spawn speed will be faster if you lower value of spawnSpeed
    int spawnSpeed = 50;
    int randomSpawn = Greenfoot.getRandomNumber(8);
    public Player1 player1 = new Player1();
    public Player2 player2 = new Player2();
    public Score score = new Score();
    public HealthBar healthBar = new HealthBar();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 650, 1); 
        populateWorld();
        inicializeScore();
        inicializeHealthBar();
    }
    
    public Player1 getPlayer1(){
        return player1;
    }
    
    private void inicializeScore(){
        addObject(score, getWidth()/2, getHeight()-20);
    }
    
    private void inicializeHealthBar(){
        addObject(healthBar, player1.getX() - 5, player1.getY() - 50);
    }
    
    private void populateWorld()
    {
        addObject(player1,getWidth()/10,getHeight()/10);
        addObject(player2,getWidth()/10 + 50,getHeight()/10);
    }
    
    public void act(){
        count++;
        spawAliens();
    }
    
    public void spawAliens(){
    if(count % spawnSpeed == 0){
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case 0 : addObject(new Alien(player1, player2, score), 0,0);
                break;
                case 1 : addObject(new Alien(player1, player2, score), getWidth()/2,0);
                break;
                case 2 : addObject(new Alien(player1, player2, score), getWidth(),0);
                break;
                case 3 : addObject(new Alien(player1, player2, score), 0, getHeight()/2);
                break;
                case 4 : addObject(new Alien(player1, player2, score), getWidth(), getHeight()/2);
                break;
                case 5 : addObject(new Alien(player1, player2, score), 0, getHeight());
                break;
                case 6 : addObject(new Alien(player1, player2, score), getWidth()/2,getHeight());
                break;
                case 7 : addObject(new Alien(player1, player2, score), getWidth(), getHeight());
                break;
            }
                
        }
    }
}
