import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A variant of the regular peashooter that shoots two peas at a time rather than one.
 * Extends the Shooter class and provides additional functionality for repeated shooting.
 * 
 * @author Harithan Raveendran
 * @version January 18, 2024
 */
public class RepShoot extends Shooter
{
    // Image for repeater peashooter
    private GreenfootImage repeat;

    // Second time counter for shooting
    private int time2;

    // Total time amount for the second shooting
    private int timeAmount2;

    /**
     * Constructor for objects of class RepShoot.
     * Initializes default values, images, and shooting parameters.
     * 
     * @return void
     */
    public RepShoot(){
        super();
        repeat = new GreenfootImage("Repeater.png");
        repeat.scale(60, 60);
        setImage(repeat);
        time2 = 0;
        timeAmount2 = 102;
        cost = 200;
    }

    /**
     * The act() method is called on every act cycle.
     * Handles shooting and superclass act.
     * 
     * @return void
     */
    public void act()
    {
        super.act();
        //shoot();
    }

    /**
     * Shoots two projectiles simultaneously based on shooting rate.
     * Overrides the shoot() method of the Shooter class.
     * 
     * @return void
     */
    public void shoot(){
        if(placed && time <= 0) {
            time = timeAmount;
            getWorld().addObject(new NormalProjectile("shooter_projectile.png"), getX(), getY() - 20);
            getWorld().addObject(new NormalProjectile("shooter_projectile.png"), getX() - 20, getY() - 20);
        } 
        else {
            time--;
        }
    }
}
