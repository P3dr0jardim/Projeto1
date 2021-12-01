
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
        /**
         * Criamos uma imagem ataves do getImage()
         * para fazer uma barra de vida
         */
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,getHealth(),10);
    }
    
    public void act() 
    {
        /**
         * Conforme o desenvolver do jogo o jogadores irao perder, ou ganhar vida
         */
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,getHealth(),10);
        loseHealth();
        gainHealth();
        isHealthZero();
    }
    
    /**
     * Método que reduz a vida dos jogadores
     */
    public void loseHealth(){
        if(health > 0){
            /**
             * Atraves dos metodos getIntersectingAlien e
             * getIntersectingMeteor da classe player
             * podemos verificar se os players 
             * foram atingidos por meteoritos, ou atacados 
             * por aliens
             */
            if(player.getIntersectingAlien()){
            health--;
            }
            
            if(player.getIntersectingMeteor()){
            health = health - 25;
            }
        };
    }
    
    /** 
     * Este metodo verifica se a vida do jogador esta a zero, 
     * e caso esteja é passo o argumento a true para a classe player atraves do metodo
     * isPlayerDead
     */
    public void isHealthZero(){
        if(health == 0){
            player.isPlayerDead(true);
        }else{
            player.isPlayerDead(false);
        }
    }
    
    /**
     * Getter health
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * Setter Health
     */
    public void setHealth(int health){
        this.health = health;
    }
    
    /**
     * Este metodo serve para saber quando os players
     * apanharam a recarga de vida para poder
     * ser incrementada a vida
     */
    public void gainHealth(){
       if(player.getIntersectingHealthSuply()){
            health = health + 25;
        };
    }
}
