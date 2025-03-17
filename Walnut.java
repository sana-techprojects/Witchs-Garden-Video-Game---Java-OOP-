import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a Wallnut object in the game.
 * Extends the Plants class and provides specific functionality for Wallnut.
 * 
 * @Sana Pardiwala 
 * @version (a version number or a date)
 */
public class Walnut extends Plants {
    
    /**
     * Constructor for objects of class Wallnut.
     * Initializes default values and sets the image.
     * 
     * @return void
     */
    public Walnut() {
        super();
        // Set the image for the Wallnut
        GreenfootImage image = new GreenfootImage("wallnut.png");
        image.scale(60, 60);  // Scale the image to the desired size
        setImage(image);
        
        // Set initial health and cost values
        health = 200;
        cost = 50;
    }

    /**
     * The act() method is called on every act cycle.
     * Handles any specific behavior for the Wallnut and calls the superclass act.
     * 
     * @return void
     */
    public void act() {
        // You can add specific behavior for Wallnut here, if needed
        
        // Call superclass act method
        super.act();
    }
}
