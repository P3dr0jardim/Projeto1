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
    
    private int count, health = 1;
    private Player player1, player2;
    private Score score;
    
    /**
     * Construtor
     */
     public Alien(Player player1, Player player2, Score score){
        this.player1 = player1;
        this.player2 = player2;
        this.score = score;
        
        /**
         * Aqui definimos a imagem do alien e o seu tamanho e para onde tem que estar virado
         */
        setImage("alien1.png");
        getImage().rotate(180);
        getImage().scale(80,80);
    }
    
    public void act() 
    {
         count++;
         moveAround();
         hitByBullet();
         if(health > 0){
            isTouchingBlackHole();
        }
    } 
    
    /**
     * Método para o movimento dos aliens
     */
    public void moveAround(){
        move(1);
        /**
         * Aqui foi criado estas duas variaveis double
         * para saber a distancia que os aliens estao de cada jogador
         */
        double player1Distance = Math.sqrt(Math.pow(getX()-player1.getX(),2)+Math.pow(getY()-player1.getY(),2));
        double player2Distance = Math.sqrt(Math.pow(getX()-player2.getX(),2)+Math.pow(getY()-player2.getY(),2));
        
        /**
         * Os aliens irao se mover em diração ao jogador mais proximo
         */
        if(player1Distance > player2Distance){
            turnTowards(player2.getX(), player2.getY());
        }else{
            turnTowards(player1.getX(), player1.getY());
        } 
        /**
         * E aqui verificamos se tem algum jogador morto, 
         * se tiver os aliens irao se mover em direção ao jogador vivo
         */
        if(player1.isDead()){
            turnTowards(player2.getX(), player2.getY());
        }else if(player2.isDead()){
            turnTowards(player1.getX(), player1.getY());
        }
    }
    
    /**
     * Método para verificar se o alien é atingido por uma bala
     */
    public void hitByBullet(){
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            /**
            * Aqui caso o alien seja atingido, 
            * a sua vida sera decrementada
            */
            health--;
            getWorld().removeObject(bullet);
        }
        
        /**
         * Caso o Alien morra, 
         * a pontuação sera aumentada
         * e o objeto sera removido do mundo
         */
        if(health == 0){
            score.increaseScore();
            getWorld().removeObject(this);
            
        }
    }
    
    /**
     * Este metodo verifica se o alien esta em contacto com o buraco negro
     */
    public void isTouchingBlackHole() {
        Actor blackHole = getOneObjectAtOffset(0, 0, BlackHoles.class);
        if (blackHole != null) {
             if(getX() > 100 && getX() < 120 && getY() > 600 && getY() < 620){
                 setLocation(601, 101);
             }else if(getX() > 700 && getX() < 720 &&  getY() > 100 && getY() < 120){
                 setLocation(101, 701);
             }
         }
    }
}
