import greenfoot.*;

/**
 * Represents the seed packet for Walnuts in the game.
 * Allows the player to purchase and plant Walnut plants.
 * 
 * @author Sana Pardiwala
 * @version January 9th 2024
 */
public class WalnutPacket extends SeedPackets {
    
    // Image for the Walnut seed packet
    GreenfootImage walnutPacket = new GreenfootImage("walnutpacket1.png");
    
    /**
     * Constructor for objects of class WalnutPacket.
     * Initializes the cost, image for the seed packet, and image alternatives.
     */
    public WalnutPacket() {
        super();
        cost = 50;
        setImage(walnutPacket);
        fileImageA = new GreenfootImage("walnutpacket1.png");
        fileImageB = new GreenfootImage("walnutpacket-unavailable.png");
    }

    /**
     * Act - do whatever the WalnutPacket wants to do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Call the act method of the superclass
        super.act();
    }
    
    /**
     * Plant a Walnut in the world when the packet is clicked.
     */
    public void plant() {
        // Create a new Walnut object
        Walnut walnut = new Walnut();
        
        // Get the SunCollector object in the world
        SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
        
        // Set the initial position of the Walnut object
        int initialX = getX() + 20; // Adjust as needed
        int initialY = getY() - 20; // Adjust as needed
        
        // Add the Walnut object to the world
        getWorld().addObject(walnut, initialX, initialY);

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
