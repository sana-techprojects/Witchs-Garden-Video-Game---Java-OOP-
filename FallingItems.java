import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class representing falling items in the game.
 * Subclasses must implement the click method to handle the item click behavior.
 * 
 * Note: Assumes that falling items move vertically and may repeat or be removed when reaching the bottom of the world.
 * 
 * @author (Your Name)
 * @version (A version number or a date)
 */
public abstract class FallingItems extends Actor
{
    // The speed at which the item falls
    protected int fallSpeed;
    
    // Flag indicating whether the item should repeat or be removed when reaching the bottom
    protected boolean repeating;

    /**
     * Act method for the falling item.
     * Updates the item's position based on its fall speed.
     * Checks if the item reaches the bottom of the world and handles repetition or removal accordingly.
     * Invokes the click method to handle item click behavior.
     * 
     * @return void
     */
    public void act()
    {
        setLocation(getX(), getY() + fallSpeed);

        // Check if the item reaches the bottom of the world
        if (getY() >= getWorld().getHeight() - 1) {
            // If it reaches the bottom, reset its position to the top if repeating is true
            if (repeating) {
                setLocation(getX(), 0);
            } else {
                // Otherwise, remove the item from the world
                getWorld().removeObject(this);
            }
        }
        // Invoke the click method to handle item click behavior
        click();
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Handles the behavior when the falling item is clicked.
     * 
     * @return void
     */
    public abstract void click();
}
