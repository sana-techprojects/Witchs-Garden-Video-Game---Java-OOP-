import greenfoot.*;

/**
 * Represents the seed packet for Sunflower plants in the game.
 * Allows the player to purchase and plant Sunflower plants.
 * 
 * @author Sana Pardiwala, Vincent
 * @version January 1, 2024
 */
public class SunflowerPacket extends SeedPackets {
    
    // Image for the Sunflower seed packet
    GreenfootImage sunflowerPacket1 = new GreenfootImage("sunflowerpacket1.png");
    
    /**
     * Constructor for objects of class SunflowerPacket.
     * Initializes the cost, image for the seed packet, and image alternatives.
     */
    public SunflowerPacket() {
        super();
        cost = 50;
        setImage(sunflowerPacket1);
        fileImageA = new GreenfootImage("sunflowerpacket1.png");
        fileImageB = new GreenfootImage("sunflowerpacket-unavailable.png");
    }

    /**
     * Act - do whatever the SunflowerPacket wants to do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Call the act method of the superclass
        super.act();
    }
    
    /**
     * Plant a Sunflower in the world when the packet is clicked.
     */
    public void plant() {
        // Create a new Sunflower object
        Sunflower sunflower = new Sunflower();
        
        // Get the SunCollector object in the world
        SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
        
        // Set the initial position of the Sunflower object
        int initialX = getX() + 20; // Adjust as needed
        int initialY = getY() - 20; // Adjust as needed
        
        // Add the Sunflower object to the world
        getWorld().addObject(sunflower, initialX, initialY);

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
