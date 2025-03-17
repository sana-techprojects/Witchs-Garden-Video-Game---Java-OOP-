import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a standing sun that, when clicked, awards points to the SunCollector to purchase plant seeds.
 * The standing sun does not fall but stays in its initial position until clicked.
 * 
 * Note: Assumes the existence of an image file named "sun1.png" for visualization.
 * Adjust the file path and content as needed.
 * 
 * @author (Your Name)
 * @version (A version number or a date)
 */
public class StandingSun extends FallingItems
{
    // Points gained when the standing sun is clicked
    private int points = 25;

    // Fall speed of the standing sun (not applicable, as it doesn't fall)
    private int fallSpeed = 0;

    // Image representing the standing sun
    GreenfootImage fallingSuns = new GreenfootImage("sun1.png");

    /**
     * Constructor for objects of class StandingSun.
     * Initializes the standing sun's image.
     * Adjust the image file path and content as needed.
     */
    public StandingSun(){
        setImage(fallingSuns);
    }

    /**
     * Act method for the standing sun.
     * Invokes the click method to handle sun click behavior.
     * 
     * @return void
     */
    public void act()
    {
        click();
    }

    /**
     * Handles the behavior when the standing sun is clicked.
     * Awards points to the SunCollector to purchase plant seeds.
     * 
     * @return void
     */
    public void click(){
        if (Greenfoot.mouseMoved(this)) {
            // If clicked, add points to the SunCollector
            SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
            sunCollector.addMoney(points);
            // Remove the standing sun from the world after the action
            getWorld().removeObject(this);
        }
    }
}
