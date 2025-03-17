import greenfoot.*;

/**
 * Represents a mystery box that, when clicked, removes all zombies in the world and adds an explosion effect.
 * The mystery box has multiple visual variants randomly chosen at instantiation.
 * 
 * Note: Assumes the existence of image files for the mystery box and explosion. Adjust the file paths and content as needed.
 * 
 * @author Sana
 * @version (A version number or a date)
 */
public class MysteryBox extends Actor {
    // Visual variants of the mystery box
    GreenfootImage mystery1 = new GreenfootImage("mysteryBox1.png");
    GreenfootImage mystery2 = new GreenfootImage("mysteryBox2.png");
    GreenfootImage mystery3 = new GreenfootImage("mysteryBox3.png");
    GreenfootImage mystery4 = new GreenfootImage("mysteryBox4.png");

    // Explosion effect for the mystery box
    MysteryExplosion mysteryExplosion = new MysteryExplosion();

    /**
     * Constructor for objects of class MysteryBox.
     * Initializes the visual variants of the mystery box and randomly sets the image to one of them.
     * 
     * @return void
     */
    public MysteryBox() {
        mystery1.scale(50, 50);
        mystery2.scale(50, 50);
        mystery3.scale(50, 50);
        mystery4.scale(50, 50);

        GreenfootImage[] boxImages = {new GreenfootImage(mystery1), new GreenfootImage(mystery2),
                new GreenfootImage(mystery3), new GreenfootImage(mystery4)};

        int randomIndex = Greenfoot.getRandomNumber(boxImages.length);
        setImage(boxImages[randomIndex]);
    }

    /**
     * Act method for the MysteryBox class.
     * Handles the behavior when the mystery box is clicked.
     * Removes all zombies in the world, adds an explosion effect, and removes the mystery box.
     * 
     * @return void
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            // Remove all zombies in the world
            removeZombies();
            // Add explosion effect
            getWorld().addObject(mysteryExplosion, this.getX(), this.getY());
            // Remove the mystery box
            getWorld().removeObject(this);
        }
    }

    /**
     * Removes all zombies in the world.
     * 
     * @return void
     */
    private void removeZombies() {
        World world = getWorld();
        // Get all objects of class Zombies in the world
        java.util.List<Zombies> zombies = world.getObjects(Zombies.class);
        // Remove each zombie
        for (Zombies zombie : zombies) {
            world.removeObject(zombie);
        }
    }
}
