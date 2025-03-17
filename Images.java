import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents visual variants of existing objects for a tutorial world.
 * The class provides a convenient way to display images with specified dimensions.
 * 
 * Note: Assumes the existence of image files for visualization. Adjust the file paths and content as needed.
 * 
 * @author Harithan Raveendran
 * @version January 20, 2024
 */
public class Images extends Actor
{
    // The image for visualization
    private GreenfootImage image;

    /**
     * Constructor for objects of class Images.
     * Initializes the image with the specified file name, width, and height.
     * 
     * @param fName The file name of the image.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public Images(String fName, int width, int height){
        image = new GreenfootImage(fName);
        image.scale(width, height);
        setImage(image);
    }

    /**
     * Act method for the Images class.
     * Placeholder for potential future actions.
     * 
     * 
     */
    public void act()
    {
        // Add your action code here.
    }
}
