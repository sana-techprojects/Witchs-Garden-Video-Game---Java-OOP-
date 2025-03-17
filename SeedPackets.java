import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the abstract class for seed packets in the game.
 * Seed packets are used to purchase and plant different types of plants.
 * 
 * @author Sana Pardiwala, Vincent Wu
 * @version January 9th 2024
 */
public abstract class SeedPackets extends Actor {
    // Class variables
    protected static boolean selected;  // Flag to indicate if a seed packet is selected
    protected int cost;  // Cost to buy a seed packet
    protected String plant;  // Type of plant associated with the seed packet
    protected GreenfootImage fileImageA, fileImageB;  // Images for displaying the seed packet
    
    // Sound for clicking on the seed packet
    GreenfootSound packetClick = new GreenfootSound("click-21156.mp3");
    
    /**
     * Constructor for objects of class SeedPackets.
     * Initializes the selected flag to false.
     */
    public SeedPackets() {
        selected = false;
    }
    
    /**
     * Act - do whatever the SeedPackets wants to do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Check if the seed packet is clicked and not already selected
        if (Greenfoot.mouseClicked(this) && selected == false) {
            // Play the click sound
            packetClick.play();
            
            // Set the selected flag to true
            selected = true;
            
            // Get the SunCollector object in the world
            SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);

            // Check if the user has enough money to buy the associated plant
            if (sunCollector.getMoney() >= cost) {
                // Call the plant() method to create a new plant
                plant();
            }
            
            // Deselect the seed packet if clicked again
            if (Greenfoot.mouseClicked(this)) {
                selected = false;
            }
        }
    }
    
    /**
     * Set the image for the seed packet to the first image.
     */
    public void setA() {
        setImage(fileImageA);
    }
    
    /**
     * Set the image for the seed packet to the second image.
     */
    public void setB() {
        setImage(fileImageB);
    }
    
    /**
     * Get the cost of the seed packet.
     * 
     * @return The cost of the seed packet.
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Abstract method to be implemented by subclasses.
     * It represents the action to plant a specific type of plant.
     */
    public abstract void plant();
}
