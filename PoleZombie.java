import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PoleZombie class represents a zombie that pole vaults over the first plant in its way,
 * and then behaves like a normal zombie. It extends the Zombies class.
 * 
 * @author Harithan Raveendran
 * @version January 19, 2024
 */
public class PoleZombie extends Zombies
{
    private GreenfootImage pole;
    private static final int ATTACK_COOLDOWN = 1000;
    private boolean vaulted;

    /**
     * Constructor for the PoleZombie class.
     * Initializes the image, attributes, and timers.
     */
    public PoleZombie(){
        pole = new GreenfootImage("Pole Zombie.png");
        pole.scale(100, 100);
        setImage(pole);
        speedValue = 0.60;
        speed = speedValue;
        health = 20;
        attacking = false;
        vaulted = false;
        attTimer = new SimpleTimer();
    }
    
    /**
     * The act() method is called on every act cycle.
     * It handles the zombie's behavior, including attacking and pole vaulting.
     */
    public void act()
    {
        attack();
        if(attacking){
            int ms = attTimer.millisElapsed();
            if(ms >= ATTACK_COOLDOWN){
                attacking = false;
            }
        }
        super.act();     
    }
    
    /**
     * Handles the zombie's attacking behavior.
     * If a plant is nearby, it attacks the plant.
     * If the zombie hasn't vaulted, it pole vaults over the first plant in its way.
     */
    public void attack(){
        p = (Plants)getOneObjectAtOffset(getImage().getWidth()/2 * -1, getImage().getHeight()/2, Plants.class);
        if(p != null){
            if(!vaulted){
                setLocation(p.getX() - 50, getY()); // Adjust the value as needed
                speedValue = 0.25;
                vaulted = true;
            }
            speed = 0;
            if(!attacking){
                attTimer.mark();
                p.decreaseH(5);
                attacking = true;
            }
        }
        else{
            speed = speedValue;
        }
    }
}
