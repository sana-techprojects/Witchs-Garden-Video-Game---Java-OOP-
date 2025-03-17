import greenfoot.*;
import java.util.ArrayList;

/**
 * This class creates a new Sunflower object when needed and sets it properly on a given cell.
 * Extends the Plants class and provides additional functionality for Sunflower.
 * 
 * @author Sana Pardiwala, Harithan Raveendran
 * @version January 19, 2024
 */
public class Sunflower extends Plants {
    // Counter to track the remaining time for generating suns
    private int sunCounter;

    // Points gained when a sun is generated
    private int points;

    // StandingSun object representing the generated sun
    private StandingSun standingSun;

    // Images and animation variables
    private GreenfootImage image;
    private GifImage gif;
    private ArrayList<GreenfootImage> images;
    private int index, counter;

    /**
     * Constructor for objects of class Sunflower.
     * Initializes default values, images, and animation parameters.
     * 
     * @return void
     */
    public Sunflower() {
        super();
        standingSun = new StandingSun();
        gif = new GifImage("sunflower.gif");
        image = gif.getCurrentImage();
        image.scale(60, 60);
        images = (ArrayList<GreenfootImage>)(gif.getImages());
        setImage(image);
        counter = 0;
        index = 0;
        image = new GreenfootImage("sunflower.png");
        health = 20;
        sunCounter = 300;
        points = 25;
        cost = 50;
    }

    /**
     * The act() method is called on every act cycle.
     * Handles animation, sun generation, and superclass act.
     * 
     * @return void
     */
    public void act() {
        // Animation handling
        image = images.get(index);
        setImage(image);
        counter++;
        if (counter % 4 == 0) {
            index++;
        }
        if (index == images.size()) {
            index = 0;
        }
        image.scale(60, 60);

        // Decrease sun counter
        sunCounter--;

        // Check if it's time to generate a sun
        if (sunCounter <= 0) {
            // Generate a sun and reset the counter
            getWorld().addObject(standingSun, getX(), getY());
            sunCounter = 300;
        }

        // Call superclass act method
        super.act();
    }
}
