
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
    /**
     * Contador para usar nas subclasses da superclasse FallingObjects
     */
    private int count = 0;
    /**
     * Velocidade do aparecimento de aliens
     */
    private int spawnSpeed = 50, randomSpawn = Greenfoot.getRandomNumber(8), life = 50, horizontalMove = 1, player1Id = 1, player2Id = 2, bulletsQuantity = 50, health = 50;
    private Player player1, player2;
    private Score score;
    private HealthBar healthBarPlayer, healthBarPlayer2;
    private PlayerName player1Name, player2Name;
    private Timer time;
    private BulletsInfo player1BulletsInfo, player2BulletsInfo;
    private String meteorImage = "Meteor0.png", meteorType = "Meteor", bulletsBoxImage = "BulletsBox.png", bulletsBoxType = "BulletsBox", healthSuplyImage = "HealthSuply.png", 
    healthSuplyType = "HealthSuply", bulletsLabel = "Bullets", scoreLabel = "Score", playerLabel = "Player", timeLabel = "Time";
    private BlackHoles blackHole1, blackHole2;
    
    /**
     * Construtor
     */
    public MyWorld()
    {    
        super(800, 700, 1);
        /**
         * Adicionar cor ao background
         */
        GreenfootImage background = new GreenfootImage("planetBackground.jpg");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        /**
         * Inicialização dos metodos de invocação
         */
        inicializeBulletsInfo();
        populateWorld();
        inicializeHealthBar();
        inicializeScore();
        inicializeStats();
        addBlackHoles();
        
    }
    
    /** 
     * Método para inicializar o score no mundo
     */
    private void inicializeScore(){
        score = new Score(40, scoreLabel);
        addObject(score, getWidth()/2, getHeight()-20);
    }
    
    /** 
     * Método para inicializar a informação das balas no mundo
     */
    private void inicializeBulletsInfo(){
        player1BulletsInfo = new BulletsInfo(20, bulletsLabel, player1);
        player2BulletsInfo = new BulletsInfo(20, bulletsLabel, player2);
    }
    
    /** 
     * Método para inicializar a informação das barras de vida
     */
    private void inicializeHealthBar(){
        healthBarPlayer = new HealthBar(player1);
        healthBarPlayer2 = new HealthBar(player2);
        healthBarPlayer.setHealth(health);
        healthBarPlayer2.setHealth(health);
    } 
    
    /** 
     * Método para inicializar as estatisticas do jogo
     */
    private void inicializeStats(){
        
        player1Name = new PlayerName(25, playerLabel, player1Id);
        player2Name = new PlayerName(25, playerLabel, player2Id);
        time = new Timer(40, timeLabel);
        addObject(time, getWidth()/2,20);
        addObject(player1Name, getWidth()/10,getHeight()/20);
        addObject(player1BulletsInfo, player1Name.getX(),player1Name.getY()+20);
        addObject(healthBarPlayer, player1Name.getX() + 70,player1Name.getY());
        addObject(player2Name, getWidth()/10,getHeight()/8);
        addObject(player2BulletsInfo, player2Name.getX(),player2Name.getY()+20);
        addObject(healthBarPlayer2, player2Name.getX() + 70,player2Name.getY());
        
    }
    
    /** 
     * Método para inicializar os jogadores e adiciona-los no mundo
     */
    private void populateWorld()
    {
        player1BulletsInfo.setBullets(bulletsQuantity);
        player2BulletsInfo.setBullets(bulletsQuantity);
        player1 = new Player(player1Id, player1BulletsInfo, healthBarPlayer);
        player2 = new Player(player2Id, player2BulletsInfo, healthBarPlayer2);
        addObject(player1,getWidth()/10,getHeight()/10);
        addObject(player2,getWidth()/10 + 50,getHeight()/10);
    }
    
    /** 
     * Método para inicializar os buracos negros no mundo
     */
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
    
    /** 
     * Método para adicionar aliens pelas bordas do mapa
     */
    private void spawAliens(){
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
    
    /** 
     * Método para lançar meteoritos
     */
    public void lauchMeteors(){
        if(count % (spawnSpeed*2) == 0){
            int randomWidth = Greenfoot.getRandomNumber(getWidth());
            addObject(new Meteor(meteorImage, meteorType), randomWidth,0);
                
        }
    }
    
    /** 
     * Método para lançar recargas de balas
     */
    public void lauchBulletsBoxes(){
        
        if(count % (spawnSpeed*4) == 0){
            int randomWidth = Greenfoot.getRandomNumber(getWidth());
            addObject(new BulletsBox(bulletsBoxImage, bulletsBoxType), randomWidth,0);
                
        }
    }
    
    /** 
     * Método para lançar recargas de vida
     */
    public void lauchHealthSuply(){
        if(count % (spawnSpeed*6) == 0){
            int randomWidth = Greenfoot.getRandomNumber(getWidth());
            addObject(new Health(healthSuplyImage, healthSuplyType, horizontalMove), randomWidth,0);
                
        }
    }
    
    /** 
     * Método para devolver uma mensagem quando os jogadores perderem
     */
    public void defeat(){
        if(player1.isDead() && player2.isDead()){
            showText("YOU LOSE! " + "YOUR SCORE WAS: " + score.getScore() + " /// " + time.getTime()/60 + " SECONDS TO GO UNTIL HELP ARRIVED", getWidth()/2, getHeight()/2);
            Greenfoot.playSound("gameOver.wav");
            Greenfoot.stop();
        }
    }
    
    /** 
     * Método para devolver uma mensagem quando os jogadores ganharem
     */
     public void victory(){
        if(time.getTimeOver()){
            showText("YOU WIN! " + "YOUR SCORE WASs: " + score.getScore() + "HELP ARRIVED JUST IN TIME!", getWidth()/2, getHeight()/2);
            Greenfoot.playSound("victory.wav");
            Greenfoot.stop();
        }
    }
}
