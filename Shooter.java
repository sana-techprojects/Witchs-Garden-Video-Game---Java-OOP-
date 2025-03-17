import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class representing plants that shoot peas at zombies.
 * Provides common functionalities and attributes for all shooter plant types.
 * 
 * @author Vincent Wu
 * Modified by: Harithan Raveendran
 * @version January 18th, 2024
 */
public abstract class Shooter extends Plants
{
    // Counter for tracking shooting time
    protected int time;

    // Amount of time between shots
    protected int timeAmount;

    // Flag indicating if peas should move slower
    protected boolean slower;

    // Flag indicating if the shooter is currently shooting
    protected boolean shooting;

    /**
     * Constructor for objects of class Shooter.
     * Initializes default values for shooting parameters.
     * 
     * @return void
     */
    public Shooter() {
        super();
        GreenfootImage image = new GreenfootImage("pea.png");
        image.scale(60, 60);
        setImage(image);
        health = 100;
        time = 0;
        timeAmount = 100;
        slower = false;
        shooting = false;
    }

    /**
     * Act method for the Shooter class.
     * Calls detectZombie and handles shooting logic if placed and shooting.
     * 
     * @return void
     */
    public void act()
    {
        detectZombie();
        if (placed && shooting) {
            shoot();
        }
        super.act();
    }

    /**
     * Abstract method for shooting peas. Must be implemented by subclasses.
     * 
     * @return void
     */
    public abstract void shoot();

    /**
     * Speeds up the shooting rate of the shooter.
     * 
     * @return void
     */
    public void speedUp(){
        timeAmount = 50;
    }

    /**
     * Slows down the speed of peas shot by the shooter.
     * 
     * @return void
     */
    public void slowPeas(){
        slower = true;
    }

    /**
     * Detects the presence of zombies within shooting range and sets the shooting flag accordingly.
     * 
     * @return void
     */
    public void detectZombie() {
        Zombies zombie = (Zombies) getOneObjectAtOffset(400, 0, Zombies.class);
        if (zombie == null) {
            zombie = (Zombies) getOneObjectAtOffset(200, 0, Zombies.class);
        }
        Projectile projectile = (Projectile) getOneObjectAtOffset(400, 0, Projectile.class);
        if (zombie != null) {
            shooting = true;
        }
    }

    /**
     * Gets the current shooting status of the shooter.
     * 
     * @return boolean Returns true if the shooter is currently shooting, false otherwise.
     */
    public boolean getShooting(){
        return shooting;
    }

    /**
     * Sets the shooting status of the shooter.
     * 
     * @param shooting The shooting status to set.
     * @return void
     */
    public void setShooting(boolean shooting){
        this.shooting = shooting;
    }
}
