import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the seed packet for Peashooter plants in the game.
 * Allows the player to purchase and plant Peashooter plants.
 * 
 * @author Sana Pardiwala, Vincent Wu
 * @version January 9th 2024
 */
public class PeashooterPacket extends SeedPackets {
    
    /**
     * Constructor for objects of class PeashooterPacket.
     * Initializes the cost and images for the seed packet.
     */
    public PeashooterPacket() {
        super();
        cost = 100;
        fileImageA = new GreenfootImage("peashooterpacket1.png");
        fileImageB = new GreenfootImage("peashooterpacket-unavailable.png");
    }
    
    /**
     * Act - do whatever the PeashooterPacket wants to do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Call the act method of the superclass
        super.act();
    }
    
    /**
     * Plant a Peashooter in the world when the packet is clicked.
     */
    public void plant() {
        // Create a new Peashooter object
        Shooter shooter = new RegShoot();
        
        // Get the SunCollector object in the world
        SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
        
        // Set the initial position of the Peashooter object
        int initialX = getX() + 20; // Adjust as needed
        int initialY = getY() - 20; // Adjust as needed
        
        // Add the Peashooter object to the world
        getWorld().addObject(shooter, initialX, initialY);

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
     * @return The cost of the seed packet.
     */
    public int getCost() {
        return cost;
    }
}
