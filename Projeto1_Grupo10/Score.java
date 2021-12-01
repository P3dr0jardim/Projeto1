import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * A classe score é uma subclasse da superclasse Stats
 */
public class Score extends Stats
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int score;
    
    public Score(int size, String label){
        /**
         * Super é usado para aceder ao construtor da superclasse
         */
        super(size, label);
        
        /**
         * Criação de uma image Com texto para retornar o score
         */
        setImage(new GreenfootImage(getLabel() + ": " + score, getSize(), Color.WHITE, new Color (0,0,0,0)));
    }
    
    public void act() 
    {
         /**
         * Colocamos a imagem aqui para ser atualizada conforme o score incrementa
         */
        setImage(new GreenfootImage(getLabel() + ": " + score, getSize(), Color.WHITE, new Color (0,0,0,0)));

    }
    
    /**
     * Retorna o score
     */
    public int getScore(){
        return score;
    }
    
    /**
     * incrementa o score
     */
    public int increaseScore(){
        return score++;
    }
}
