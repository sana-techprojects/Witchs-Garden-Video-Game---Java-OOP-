import greenfoot.*;

/**
 * ToxicSymbol class represents a toxic symbol that falls when spawned by the ToxicFog.
 * 
 * @author Sana
 * @version January 16, 2024
 */
public class ToxicSymbol extends ToxicFog {
    private GreenfootImage toxicSymbol = new GreenfootImage("toxic.png");
    private int fallSpeed = 2;
    
    /**
     * Constructor for ToxicSymbol. Sets up the initial image for the toxic symbol.
     */
    public ToxicSymbol() {
        toxicSymbol.scale(50, 50);
        setImage(toxicSymbol);
    }
    
    /**
     * Act method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * Moves the toxic symbol downwards and resets its position when it reaches the bottom.
     */
    public void act() {
        if (isActive) {
            setLocation(getX(), getY() + fallSpeed);

            // Check if the symbol reaches the bottom of the world
            if (getY() >= getWorld().getHeight() - 1) {
                // If it reaches the bottom, reset its position to the top
                setLocation(getX(), 0);
            }
        } else {
            getWorld().removeObject(this); // Remove the toxic symbol if toxic fog is not active
        }
    }
}
