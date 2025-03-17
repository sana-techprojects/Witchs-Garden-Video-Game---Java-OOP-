import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the seed packet for Repeater plants in the game.
 * Allows the player to purchase and plant Repeater plants.
 * A variant of the regular Peashooter that shoots two peas instead of one.
 * 
 * @author Harithan Raveendran
 * @version January 19, 2023
 */
public class RepeaterPacket extends SeedPackets {
    
    /**
     * Constructor for objects of class RepeaterPacket.
     * Initializes the cost and images for the seed packet.
     */
    public RepeaterPacket() {
        super();
        cost = 200;
        fileImageA = new GreenfootImage("peashooterpacket1.png");
        fileImageB = new GreenfootImage("peashooterpacket-unavailable.png");
    }
    
    /**
     * Act - do whatever the RepeaterPacket wants to do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Call the act method of the superclass
        super.act();
    }
    
    /**
     * Plant a Repeater in the world when the packet is clicked.
     */
    public void plant() {
        // Create a new Repeater object
        RepShoot r = new RepShoot();
        
        // Get the SunCollector object in the world
        SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
        
        // Set the initial position of the Repeater object
        int initialX = getX() + 20; // Adjust as needed
        int initialY = getY() - 20; // Adjust as needed
        
        // Add the Repeater object to the world
        getWorld().addObject(r, initialX, initialY);

        // Subtract the cost from the user's money
        sunCollector.spendMoney(cost);
    }
    
    /**
     * Set the image for the seed packet to the first image.
     */
    public void setA() {
        super.setA();
    }
    
    /**
     * Set the image for the seed packet to the second image.
     */
    public void setB() {
        super.setB();
    }
    
    /**
     * Get the cost of the seed packet.
     * 
     * @return int - The cost of the seed packet.
     */
    public int getCost() {
        return cost;
    }
}
