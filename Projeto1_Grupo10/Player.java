
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    
    private GreenfootImage playerBack, playerFront, playerDownLeft, playerDownRight, playerLeft, playerRight, playerUpperLeft, playerUpperRight, playerDead;
    private int position, rotation, playerId;
    private Boolean intersectAlien = false, intersectMeteor = false, intersectHealthSuply = false, isDead = false;
    private final int player1 = 1,  player2 = 2;
    private HealthBar healthBar;
    private BulletsInfo bulletsInfo;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    /**
     * Construtor
     */
    public Player(int playerId, BulletsInfo bulletsInfo, HealthBar healthBar) {
        this.playerId = playerId;
        this.bulletsInfo = bulletsInfo;
        this.healthBar = healthBar;
        
        /**
         * Variações de imagens conforme o movimento do jogador
         */
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
        /**
         * Os jogadores so se podem mover e ser atingidos quando o jogador estiver vivo
         */
        if(!isDead){
            moveAround();
            fireBullet();
            isHitByAlien();
            isHitByMeteor();
            isTouchingBlackHole();
            pickHealthSuply();
            pickAmmoBox();
        }
        dead();
    }

    /**
     * Método para os jogadores se poderem mover
     */
    public void moveAround() {
        /**
         * Foi utilizado aqui um switch case para ser mais facil 
         * de ler o codigo
         */
           switch (playerId) {
            case player1:
            /**
             * Caso o id do jogador seja igual ao id do player 1 o jogador ira se movimentar
             * atraves das teclas WASD
             */
                if (Greenfoot.isKeyDown("w")) {
                    setLocation(getX(), getY() - 2);
                    /**
                     * Conforme as teclas pressionadas a imagem do jogador
                     * é alterada, assim os jogadores terao uma maior noção 
                     * das posições de cada player
                     */
                    setImage(playerBack);
                    rotation = 270;
                }
                if (Greenfoot.isKeyDown("s")) {
                    setLocation(getX(), getY() + 2);
                    setImage(playerFront);
                    rotation = 90;
                }
                if (Greenfoot.isKeyDown("a")) {
                    setLocation(getX() - 2, getY());
                    setImage(playerLeft);
                    rotation = 180;
                }
                if (Greenfoot.isKeyDown("d")) {
                    setLocation(getX() + 2, getY());
                    setImage(playerRight);
                    rotation = 0;
                }
                if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w")) {
                    setLocation(getX() - 1, getY() - 1);
                    setImage(playerUpperLeft);
                    rotation = 225;
                }
                if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w")) {
                    setLocation(getX() + 1, getY() - 1);
                    setImage(playerUpperRight);
                    rotation = 315;

                }
                if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")) {
                    setLocation(getX() - 1, getY() + 1);
                    setImage(playerDownLeft);
                    rotation = 135;
                }
                if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")) {
                    setLocation(getX() + 1, getY() + 1);
                    setImage(playerDownRight);
                    rotation = 45;
                }
                break;
                
                /**
                * Caso o id do jogador seja igual ao id do player 2 o jogador ira se movimentar
                * atraves das teclas UP DOWN LEFT RIGHT
                */
                case player2:
                if (Greenfoot.isKeyDown("up")) {
                    setLocation(getX(), getY() - 2);
                    setImage(playerBack);
                    rotation = 270;
                }
                if (Greenfoot.isKeyDown("down")) {
                    setLocation(getX(), getY() + 2);
                    setImage(playerFront);
                    rotation = 90;
                }
                if (Greenfoot.isKeyDown("left")) {
                    setLocation(getX() - 2, getY());
                    setImage(playerLeft);
                    rotation = 180;
                }
                if (Greenfoot.isKeyDown("right")) {
                    setLocation(getX() + 2, getY());
                    setImage(playerRight);
                    rotation = 0;
                }
                if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up")) {
                    setLocation(getX() - 2, getY() - 2);
                    setImage(playerUpperLeft);
                    rotation = 225;
                }
                if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up")) {
                    setLocation(getX() + 2, getY() - 2);
                    setImage(playerUpperRight);
                    rotation = 315;

                }
                if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down")) {
                    setLocation(getX() - 2, getY() + 2);
                    setImage(playerDownLeft);
                    rotation = 135;
                }
                if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down")) {
                    setLocation(getX() + 2, getY() + 2);
                    setImage(playerDownRight);
                    rotation = 45;
                }
                break;
            }
    }

    /**
     * Método para verificar se o jogador esta a tocar no buraco negro
     */
    public void isTouchingBlackHole() {
        Actor blackHole = getOneObjectAtOffset(0, 0, BlackHoles.class);
        if (blackHole != null) {
            /**
             * Caso o jogador esteja a tocar no buraco negro
             */
            if(getX() > 100 && getX() < 120 && getY() > 600 && getY() < 620){
                /**
                 * E caso esteja dentro destas coordenadas, 
                 * o player é redirecionado para o outro buraco negro
                 */
                Greenfoot.playSound("teleport.wav");
                setLocation(601, 101);
            }else if(getX() > 700 && getX() < 720 &&  getY() > 100 && getY() < 120){
                Greenfoot.playSound("teleport.wav");
                setLocation(101, 701);
            }
        }
    }
    
    /**
     * Método para o jogador poder disparar
     */
    public void fireBullet() {
        switch (playerId) {
            case player1:
            /**
            * Caso o id do jogador seja igual ao id do player 1 o jogador ira
            * disparar na tecla G
            */
                if (Greenfoot.isKeyDown("g")) {
                    if (bulletsInfo.getBullets() > 0) {
                        /**
                         * Ao disparar as balas e se o jogador ainda ter balas na arma
                         * elas irao sendo decrementadas  
                         */
                        bulletsInfo.decreaseBullets();
                        /**
                         * Conforme a rotação do jogador a bala ira nessa direção
                         */
                        getWorld().addObject(new Bullet(rotation), getX(), getY());
                    }
                }
                break;
            case player2:
            /**
            * Caso o id do jogador seja igual ao id do player 2 o jogador ira
            * disparar na tecla 0 do numpad
            */
                if (Greenfoot.isKeyDown("0")) {
                    if (bulletsInfo.getBullets() > 0) {
                        bulletsInfo.decreaseBullets();
                        getWorld().addObject(new Bullet(rotation), getX(), getY());
                    }
                }
        }
    }

    /**
     * Método para saber quando o jogador esta em contacto com o alien
     */
    public void isHitByAlien() {
        Actor alien = getOneObjectAtOffset(0, 0, Alien.class);
        if (alien != null) {
            /**
             * Sempre que o jogador estiver
             * em contacto com o alien 
             * ira perder vida
             */
            intersectAlien = true;
        } else {
            intersectAlien = false;
        }
    }
    
    
    /**
     * Método para saber quando o jogador apanha
     */
    public void pickHealthSuply() {
        Actor healthSuply = getOneObjectAtOffset(0, 0, Health.class);
        if (healthSuply != null) {
            intersectHealthSuply = true;
             /**
             * Quando o jogador apanhar uma recarga de vida 
             * a sua vida sera aumentada em 25 pontos
             */
            getWorld().removeObject(healthSuply);
        } else {
            intersectHealthSuply = false;
        }
    }

    /**
     * Método para saber quando o jogador é atingido por um meteorito
     */
    public void isHitByMeteor() {
        Actor meteor = getOneObjectAtOffset(0, 0, Meteor.class);
        if (meteor != null) {
            intersectMeteor = true;
            /**
            * Quando o jogador for atingido pelo meteorito
            * ira perder vida e sera provocada uma explosao
            */
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(meteor);
        } else {
            intersectMeteor = false;
        }
    }
    
    /**
     * Método para saber quando o jogador apanha recargas de balas
     */
    public void pickAmmoBox() {
        Actor bulletsBox = getOneObjectAtOffset(0, 0, BulletsBox.class);
        if (bulletsBox != null) {
            /**
            * Quando o jogador apanhar uma recarga
            * sera adicionado 25 balas a arma
            */
            bulletsInfo.increaseBullets();
            getWorld().removeObject(bulletsBox);
        }
    }
    
    /**
     * Método para alterar a imagem do jogador quando morrer
     */
    public void dead(){
        if(isDead){
            setImage(playerDead);
        }
    }
    
    /**
     * Este método é usado na classe healthbar 
     * e quando a vida do jogador for zero 
     * é retornado o argumento a true
     */
    public void isPlayerDead(Boolean isDead){
        this.isDead = isDead;
    }
    
    /**
     * Método para retornar se o jogador esta vivo ou morto
     */
     public boolean isDead(){
        return isDead;
    }
    
    /**
     * Método para retornar se o jogador foi atacado por um alien
     */
    public boolean getIntersectingAlien() {
        return intersectAlien;
    }

    /**
     * Método para retornar se o jogador foi atingido pelo meteoro
     */
    public boolean getIntersectingMeteor() {
        return intersectMeteor;
    }
    
    /**
     * Método para retornar se o jogador apanhou a recarga da vida
     */
    public boolean getIntersectingHealthSuply() {
        return intersectHealthSuply;
    } 
}
