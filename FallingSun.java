import greenfoot.*;

/**
 * Represents a falling sun that, when clicked, awards points to the SunCollector to purchase plant seeds.
 * The sun falls randomly throughout the game, and when the user clicks on it, "money" is gained.
 * 
 * Note: Assumes the existence of an image file named "sun1.png" for visualization and a sound file named "short-success-sound-glockenspiel-treasure-video-game-6346.mp3" for sound effects.
 * Adjust the file paths and content as needed.
 * 
 * @author Sana Pardiwala
 * Modified by: Harithan Raveendran
 * @version January 1, 2024
 */
public class FallingSun extends FallingItems
{
    // Points gained when the sun is clicked
    private int points = 25;
    
    // Fall speed of the sun
    private int fallSpeed = 2;

    // Image representing the falling sun
    GreenfootImage fallingSuns = new GreenfootImage("sun1.png");
    
    // Sound effect for sun collected
    GreenfootSound sunCollected = new GreenfootSound("short-success-sound-glockenspiel-treasure-video-game-6346.mp3");

    /**
     * Constructor for objects of class FallingSun.
     * Initializes the falling sun's image and sets repetition to true.
     * Adjust the image file path and content as needed.
     */
    public FallingSun()
    {
        setImage(fallingSuns);
        repeating = true;
    }

    /**
     * Act method for the falling sun.
     * Updates the sun's position based on its fall speed.
     * Checks if the sun reaches the bottom of the world and resets its position to the top if needed.
     * Invokes the click method to handle sun click behavior.
     * 
     * @return void
     */
    public void act()
    {
        setLocation(getX(), getY() + fallSpeed);
        
        // Check if the sun reaches the bottom of the world
        if (getY() >= getWorld().getHeight() - 1) {
            // If it reaches the bottom, reset its position to the top
            setLocation(getX(), 0);
        }
        // Invoke the click method to handle sun click behavior
        click();
    }

    /**
     * Handles the behavior when the falling sun is clicked.
     * Awards points to the SunCollector to purchase plant seeds and plays a sound effect.
     * 
     * @return void
     */
    public void click(){
        if (Greenfoot.mouseMoved(this)) {
            sunCollected.play();
            // If clicked, add points to the SunCollector
            SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
            sunCollector.addMoney(points);
            // Remove the falling sun from the world after the action
            getWorld().removeObject(this);
        }
    }
}
