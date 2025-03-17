import greenfoot.*;

/**
 * SlowProjectile class represents a version of the normal projectile that slows down zombies when hit.
 * 
 * @author Harithan Raveendran
 * @version December 16, 2024
 */
public class SlowProjectile extends Projectile
{
    /**
     * Constructor for SlowProjectile with a specified image.
     * 
     * @param image The image representing the projectile.
     */
    public SlowProjectile(String image){
        super("ball.png"); // Call the superclass constructor
        setImage(projectileImage); // Set the image for the projectile
        speed = 8; // Set the speed of the projectile
        type = 2; // Set the type of the projectile to slow (2)
    }
    
    /**
     * Constructor for SlowProjectile with specified image and projectile speed.
     * 
     * @param projectileSpeed The speed at which the projectile moves.
     * @param image The image representing the projectile.
     */
    public SlowProjectile(int projectileSpeed, String image){
        super(image, projectileSpeed, 60); // Call the superclass constructor
        type = 2; // Set the type of the projectile to slow (2)
    }
}
