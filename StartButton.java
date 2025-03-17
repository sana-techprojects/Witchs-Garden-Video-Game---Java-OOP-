import greenfoot.*;  // Import necessary Greenfoot classes

/**
 * The StartButton class represents a button to start the game.
 * 
 * Author: Rebecca
 */
public class StartButton extends Actor {
    GreenfootImage button = new GreenfootImage("Startbutton.png");  // Initialize the button image

    /**
     * Constructor for the StartButton class.
     * Sets the image of the button.
     */
    public void StartButton() {
        setImage(button);
    }

    /**
     * The act() method is called on every act cycle.
     * It checks for mouse clicks on the StartButton.
     * If clicked, it transitions to the Intro world and stops the background music.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Intro());  // Transition to the Intro world
            StartingScreen.bgMusic.stop();    // Stop the background music
        }
    }
}
