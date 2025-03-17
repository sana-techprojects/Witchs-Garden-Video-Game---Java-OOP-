import greenfoot.*;

/**
 * NormalProjectile class represents a projectile shot by peashooters that hurts zombies.
 * 
 * @author Harithan Raveendran 
 * @version December 16, 2024
 */
public class NormalProjectile extends Projectile
{
    /**
     * Constructor for NormalProjectile with a specified image.
     * 
     * @param image The image representing the projectile.
     */
    public NormalProjectile(String image){
        super("shooter_projectile.png"); // Call the superclass constructor
        setImage(projectileImage); // Set the image for the projectile
        speed = 10; // Set the speed of the projectile
        type = 1; // Set the type of the projectile to normal (1)
    }
    
    /**
     * Constructor for NormalProjectile with specified image, projectile speed, and type.
     * 
     * @param image The image representing the projectile.
     * @param projectileSpeed The speed at which the projectile moves.
     * @param type The type of the projectile (unused parameter).
     */
    public NormalProjectile(String image, int projectileSpeed, int type){
        super(image, projectileSpeed, 60); // Call the superclass constructor
        type = 1; // Set the type of the projectile to normal (1)
    }
}
