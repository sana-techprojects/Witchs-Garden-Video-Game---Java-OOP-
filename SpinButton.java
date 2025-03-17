import greenfoot.*;

/**
 * The SpinButton class represents a button that, when clicked, starts spinning a SpinnerWheel.
 * The button has an associated SpinnerWheel instance.
 * 
 * @author Sana
 */
public class SpinButton extends Actor {
    SpinnerWheel spinner;
    private boolean isSpinning = false;

    /**
     * Constructor for the SpinButton class.
     * Initializes the SpinButton with a given SpinnerWheel.
     * 
     * @param spinner The associated SpinnerWheel instance.
     */
    public SpinButton(SpinnerWheel spinner) {
        this.spinner = spinner;
        GreenfootImage image = new GreenfootImage("button.png"); // Replace with the actual button image
        image.scale(300, 250);
        setImage(image);
    }

    /**
     * The act() method is called on every act cycle.
     * It checks for mouse clicks on the button.
     */
    public void act() {
        checkMouseClick();
    }

    /**
     * Checks for a mouse click on the button.
     * If the button is clicked and not already spinning, it starts the spinning process.
     */
    private void checkMouseClick() {
        if (Greenfoot.mouseClicked(this) && !isSpinning) {
            startSpinning();
        }
    }

    /**
     * Initiates the spinning process.
     * Sets the isSpinning flag to true and starts the spinning of the associated SpinnerWheel.
     */
    private void startSpinning() {
        isSpinning = true;
        spinner.startSpinning();
    }
}
