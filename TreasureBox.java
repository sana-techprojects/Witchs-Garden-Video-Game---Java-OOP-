import greenfoot.*;

/**
 * TreasureBox class represents a clickable treasure box that can open a mini-game.
 * 
 * @version January 16, 2024
 */
public class TreasureBox extends Actor {
    private GreenfootImage box = new GreenfootImage("image-removebg-preview (1).png");

    /**
     * Constructor for TreasureBox. Sets up the initial image for the treasure box.
     */
    public TreasureBox() {
        box.scale(70, 70);
        setImage(box);
    }

    /**
     * Act method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * Checks for mouse click on the treasure box and opens the mini-game if conditions are met.
     */
    public void act() {
        checkForClick();
    }

    /**
     * Checks if the treasure box is clicked. If clicked and the user's money is 25 or less,
     * switches to the SpinWheelMiniGame world.
     */
    private void checkForClick() {
        if (Greenfoot.mouseClicked(this)) {
            // Get a reference to the SunCollector object in the world
            SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);

            // Check if the user's money is 25 or less
            if (sunCollector.getMoney() <= 25) {
                // Switch to the SpinWheelMiniGame world
                Greenfoot.setWorld(new SpinWheelMiniGame());
            } else {
                // Provide feedback to the user (optional)
                // System.out.println("You need 25 or less money to open the treasure box!");
            }
        }
    }
}
