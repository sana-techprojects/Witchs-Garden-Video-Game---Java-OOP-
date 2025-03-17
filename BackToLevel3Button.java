import greenfoot.*;

/**
 * A button that, when clicked, returns the player to Level Three with a specified outcome amount.
 * This button is typically used in the context of a mini-game.
 * 
 * 
 * 
 * @Sana
 */
public class BackToLevel3Button extends Actor
{
    // The image representing the button
    GreenfootImage button = new GreenfootImage("rewind-next-wooden-button-in-cartoon-style-an-asset-for-a-gui-in-a-mobile-app-or-casual-video-game-vector-removebg-preview.png");

    /**
     * Constructor for objects of class BackToLevel3Button.
     * Initializes the button image and scales it to a standard size.
     */
    public BackToLevel3Button()
    {
        button.scale(120, 120);
        setImage(button);
    }

    /**
     * Act method for the button.
     * Listens for mouse clicks and, when clicked, returns the player to Level Three with a specified outcome amount.
     * 
     * @return void
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            // Get a reference to the SpinWheelMiniGame world
            // SpinWheelMiniGame spinWheelWorld = (SpinWheelMiniGame) getWorld();
            
            // Get the outcome amount from the SpinWheelMiniGame world
            int outcomeAmount = SpinWheelMiniGame.getOutcomeAmount();
            
            // For testing purposes, use this print statement
            // System.out.println("outcomeAmount: " + outcomeAmount);

            // Switch back to the LevelThree world and pass the outcome amount
            Greenfoot.setWorld(new LevelThree(outcomeAmount));
        }
    }
}
