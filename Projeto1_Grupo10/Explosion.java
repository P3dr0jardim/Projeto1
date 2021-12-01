import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Declaração de um array
     */
    private GreenfootImage[] images; 
    /**
     * Index para percorrer o array
     */
    private int index; 
    
    /**
     * Construtor
     */
    public Explosion()
    {
        images = new GreenfootImage [20];
        
        /**
         * Preencher o array com imagens de tamanho crescente
         */
        for (int i =0; i < images.length; i++ )
        {
            images[i] = new GreenfootImage("explosion.png");
            images[i].scale(5*i + 5, 5*i + 5);
        }
        setImage(images[0]); 
    }
    
    public void act() 
    {
        animateExplosion();
    }
    /**
     * Método para fazer a animação da explosão
     */
    public void animateExplosion()
    {
        index++;
        if (index < images.length)
            setImage(images[index]);
        else
            getImage().clear();
    }
}
