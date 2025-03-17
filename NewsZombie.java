import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The NewsZombie class represents a zombie that carries a newspaper.
 * It extends the Zombies class.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewsZombie extends Zombies
{
    private GreenfootImage news;
    private int attackValue;
    private int attackSpeed;
    private int angAmount;
    private int maxHealth;
    private boolean angry;
    private SimpleTimer angTimer;

    /**
     * Constructor for the NewsZombie class.
     * Initializes the image, attributes, and timers.
     */
    public NewsZombie(){
        news = new GreenfootImage("Newspaper zombie.png");
        news.scale(100, 100);
        setImage(news);
        speedValue = 0.25;
        attackValue = 5;
        attackSpeed = 1000;
        angAmount = 3000;
        health = 40;
        maxHealth = 40;
        attacking = false;
        angry = false;
        attTimer = new SimpleTimer();
        angTimer = new SimpleTimer();
    }
     
    /**
     * The act() method is called on every act cycle.
     * It handles the zombie's behavior, including attacking and mutation.
     */
    public void act()
    {
        attack();
        if(attacking){
            int ms = attTimer.millisElapsed();
            if(ms >= attackSpeed){
                attacking = false;
            }
        }
        mutate();
        super.act();
    }
    
    /**
     * Handles the zombie's attacking behavior.
     * If a plant is nearby, it attacks the plant.
     */
    public void attack(){
        p = (Plants)getOneObjectAtOffset(getImage().getWidth()/2 * -1, getImage().getHeight()/2, Plants.class);
        if(p != null){
            speed = 0;
            if(!attacking){
                attTimer.mark();
                p.decreaseH(attackValue);
                attacking = true;
            }
        }
        else{
            speed = speedValue;
        }
    }
    
    /**
     * Handles the zombie's mutation when its health drops below half.
     * Changes its attributes to become more dangerous.
     */
    public void mutate(){
        if(health <= maxHealth/2 && !angry){
            phase2();
            angry = true;
        }
    }
    
    /**
     * Represents the second phase of the zombie's mutation.
     * Increases its speed, attack value, and attack speed.
     */
    public void phase2(){
        speedValue = 0.8;
        attackValue = 10;
        attackSpeed = 500;
        setLocation(getX(), getY());
    }
}
