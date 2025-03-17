import greenfoot.*;

/**
 * SpinWheelMiniGame represents the mini-game where the player can spin a wheel
 * to get an outcome amount.
 * 
 * @author Sana
 * @version January 23rd
 */
public class SpinWheelMiniGame extends World {
    private GreenfootImage bg;
    private SpinnerWheel spinner;
    private SpinButton spinButton;
    private BackToLevel3Button button;
    
    private static int outcomeAmount;
    private SpinnerOutside spinnerOutside = new SpinnerOutside();
    
    /**
     * Constructor for objects of class SpinWheelMiniGame.
     */
    public SpinWheelMiniGame() {
        super(1000, 530, 1);
        
        // Set background image
        bg = new GreenfootImage("christian-afonso-ferreira-forest.jpg");
        bg.scale(1000, 530);
        setBackground(bg);
        
        // Add spinner and related objects
        addObject(spinnerOutside, 792, 192);
        spinner = new SpinnerWheel();
        addObject(spinner, 792, 192);
        spinButton = new SpinButton(spinner);
        addObject(spinButton, 794, 457);
        
        // Add button to go back to Level 3
        button = new BackToLevel3Button();
        addObject(button, 55, 474);
    }
    
    /**
     * Get the outcome amount.
     * 
     * @return int - The outcome amount.
     */
    public static int getOutcomeAmount() {
        return outcomeAmount;
    }

    /**
     * Set the outcome amount.
     * 
     * @param amount - The outcome amount to be set.
     */
    public static void setOutcomeAmount(int amount) {
        outcomeAmount = amount;
    }
}
