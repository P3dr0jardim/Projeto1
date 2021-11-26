
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
    private int count = 0;
    //Spawn speed will be faster if you lower value of spawnSpeed
    private int spawnSpeed = 50;
    private int randomSpawn = Greenfoot.getRandomNumber(8);
    private int life = 50;
    private Player player1;
    private Player player2;
    private Score score;
    private HealthBar healthBarPlayer;
    private HealthBar healthBarPlayer2;
    private PlayerName player1Name;
    private PlayerName player2Name;
    private int player1Id = 1;
    private int player2Id = 2;
    private Timer time;
    private BulletsInfo player1BulletsInfo;
    private BulletsInfo player2BulletsInfo;
    private int bullets = 50;
    private String meteorImage = "Meteor0.png";
    private String meteorType = "Meteor";
    private String bulletsBoxImage = "BulletsBox.png";
    private String bulletsBoxType = "BulletsBox";
    private String healthSuplyImage = "HealthSuply.png";
    private String healthSuplyType = "HealthSuply";
    private int health = 50;
    private BlackHoles blackHole1;
    private BlackHoles blackHole2;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 700, 1);
        inicializeBulletsInfo();
        populateWorld();
        inicializeHealthBar();
        inicializeScore();
        inicializeStats();
        addBlackHoles();
        
    }
    
    private void inicializeScore(){
        score = new Score(40, "Score");
        addObject(score, getWidth()/2, getHeight()-20);
    }
    
    private void inicializeBulletsInfo(){
        player1BulletsInfo = new BulletsInfo(20, "Bullets", player1);
        player2BulletsInfo = new BulletsInfo(20, "Bullets", player2);
    }
    
    private void inicializeHealthBar(){
        healthBarPlayer = new HealthBar(player1);
        healthBarPlayer2 = new HealthBar(player2);
        healthBarPlayer.setHealth(health);
        healthBarPlayer2.setHealth(health);
    } 
    
    private void inicializeStats(){
        
        player1Name = new PlayerName(25, "Player", player1Id);
        player2Name = new PlayerName(25, "Player", player2Id);
        time = new Timer(40, "Time");
        
        addObject(time, getWidth()/2,20);
        
        addObject(player1Name, getWidth()/10,getHeight()/20);
        addObject(player1BulletsInfo, player1Name.getX(),player1Name.getY()+20);
        addObject(healthBarPlayer, player1Name.getX() + 70,player1Name.getY());
        
        addObject(player2Name, getWidth()/10,getHeight()/8);
        addObject(player2BulletsInfo, player2Name.getX(),player2Name.getY()+20);
        addObject(healthBarPlayer2, player2Name.getX() + 70,player2Name.getY());
        
    }
    
    private void populateWorld()
    {
        player1BulletsInfo.setBullets(bullets);
        player2BulletsInfo.setBullets(bullets);
        inicializeHealthBar();
        player1 = new Player(player1Id, player1BulletsInfo, healthBarPlayer);
        player2 = new Player(player2Id, player2BulletsInfo, healthBarPlayer2);
        
        addObject(player1,getWidth()/10,getHeight()/10);
        addObject(player2,getWidth()/10 + 50,getHeight()/10);
    }
    
    private void addBlackHoles(){
        blackHole1 = new BlackHoles();
        blackHole2 = new BlackHoles();
        
        addObject(blackHole1, 100, 600);
        addObject(blackHole2, 700,100);
    }
    
    public void act(){
        count++;
        spawAliens();
        lauchMeteors();
        lauchBulletsBoxes();
        lauchHealthSuply();
        defeat();
        victory();
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
    
    public void lauchMeteors(){
        if(count % (spawnSpeed*2) == 0){
            int randomWidth = Greenfoot.getRandomNumber(getWidth());
            addObject(new Meteor(meteorImage, meteorType), randomWidth,0);
                
        }
    }
    
    public void lauchBulletsBoxes(){
        
        if(count % (spawnSpeed*4) == 0){
            int randomWidth = Greenfoot.getRandomNumber(getWidth());
            addObject(new BulletsBox(bulletsBoxImage, bulletsBoxType), randomWidth,0);
                
        }
    }
    
    public void lauchHealthSuply(){
        if(count % (spawnSpeed*6) == 0){
            int randomWidth = Greenfoot.getRandomNumber(getWidth());
            addObject(new Health(healthSuplyImage, healthSuplyType), randomWidth,0);
                
        }
    }
    
    public void defeat(){
        if(player1.isDead() && player2.isDead()){
            showText("You Lose! " + "Your Score was: " + score.getScore() + " " + time.getTime()/60 + "seconds remaning until help arrive", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }
    
     public void victory(){
        if(time.getTimeOver()){
            showText("You Win! " + "Your Score was: " + score.getScore() + "Help arrived just in time!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }
}
