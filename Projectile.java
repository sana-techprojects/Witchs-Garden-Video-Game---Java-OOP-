import greenfoot.*;

/**
 * Projectile class represents an abstract projectile in the game.
 * It provides common functionality for projectile movement and removal.
 * 
 * @author Vincent Wu
 * Modified by: Harithan
 * @version January 9th 2024
 */
public abstract class Projectile extends SuperSmoothMover
{
    protected int speed; // Speed of the projectile
    protected int type; // Type of the projectile (1 for normal, 2 for ice)
    protected boolean hit; // Flag indicating if the projectile has hit a target
    protected Zombies z; // Reference to a Zombies object (unused)
    protected GreenfootSound projectileSound = new GreenfootSound("projectile.mp3"); // Sound played when a projectile is created
    protected GreenfootImage projectileImage; // Image representing the projectile

    /**
     * Constructor for Projectile with a specified projectileType.
     * 
     * @param projectileType The type of projectile, used to determine appearance and behavior.
     */
    public Projectile(String projectileType) {
        projectileSound.play(); // Play the projectile sound
        hit = false; // Initialize hit flag
        projectileImage = new GreenfootImage(projectileType); // Load the projectile image
        
        projectileImage.scale(17, 17); // Scale the image
        //setImage(projectileImage); // Uncomment to set the image (currently commented out)
        
        // Determine the type based on projectileType
        if(projectileType.equals("ice.png")) {
            type = 2; // Ice type
        } else {
            type = 1; // Normal type
        }
    }

    /**
     * Constructor for Projectile with specified image, speed, and scale.
     * 
     * @param image The image representing the projectile.
     * @param projectileSpeed The speed at which the projectile moves.
     * @param scale The scale factor for resizing the projectile image.
     */
    public Projectile(String image, int projectileSpeed, int scale) {
        // Resizes the size of the projectile image and sets speed to move left (-20) or right (20)
        projectileImage.scale(getImage().getWidth()/60, getImage().getHeight()/60);
        setImage(projectileImage);
        projectileSound.play(); // Play the projectile sound
        speed = projectileSpeed; // Set the projectile speed
    }

    /**
     * Act - perform the projectile's actions.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Moves the projectile and removes it if touching the edge of the map
        move(speed);
        removeProjectile();
    }

    /**
     * Remove the projectile from the world when it reaches the edge or hits a target.
     */
    public void removeProjectile() {
        if(getX() >= getWorld().getWidth() - 1 || getX() == 0 || hit)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Get the type of the projectile.
     * 
     * @return int - The type of the projectile (1 for normal, 2 for ice).
     */
    public int getType(){
        return type;
    }
}
