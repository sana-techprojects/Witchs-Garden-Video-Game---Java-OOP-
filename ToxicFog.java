import greenfoot.*;

/**
 * ToxicFog class represents a toxic fog that may spawn toxic symbols when active.
 * 
 * @author Sana January 16, 2024
 */
public class ToxicFog extends Actor {
    protected boolean isActive = false;
    
    /**
     * Constructor for ToxicFog. Sets up the initial image for the toxic fog.
     */
    public ToxicFog() {
        GreenfootImage image = new GreenfootImage(1000, 530);
        image.setColor(new Color(0, 255, 0, 100)); // Almost transparent green
        image.fillRect(0, 0, 1000, 530);
        setImage(image);
    }
    
    /**
     * Act method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * Spawns toxic symbols if the toxic fog is active.
     */
    public void act() {
        if (isActive) {
            spawnToxicSymbol();
        }
    }

    /**
     * Sets the activity status of the toxic fog.
     * 
     * @param active The status to set (true if active, false otherwise).
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Spawns toxic symbols with a 5% probability.
     */
    private void spawnToxicSymbol() {
        if (Greenfoot.getRandomNumber(100) < 5) {
            ToxicSymbol toxicSymbol = new ToxicSymbol();
            getWorld().addObject(toxicSymbol, Greenfoot.getRandomNumber(getWorld().getWidth()), 300);
        }
    }
}
