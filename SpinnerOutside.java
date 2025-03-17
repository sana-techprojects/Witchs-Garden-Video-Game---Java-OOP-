import greenfoot.*;

/**
 * The SpinnerOutside class represents an actor displaying the outside appearance of a spinner.
 * 
 * @author Sana
 */
public class SpinnerOutside extends Actor {
    GreenfootImage spinnerOutside = new GreenfootImage("download.png");

    /**
     * Constructor for the SpinnerOutside class.
     * Initializes the SpinnerOutside with an image and scales it.
     */
    public SpinnerOutside() {
        spinnerOutside.scale(450, 450);
        setImage(spinnerOutside);
    }

    /**
     * The act() method is called on every act cycle.
     * Add your specific action code here if needed.
     */
    public void act() {
        // Add your action code here.
    }
}
