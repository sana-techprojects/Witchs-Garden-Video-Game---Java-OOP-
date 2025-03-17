import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Represents an actor displaying an animated bomb explosion using GifImage.
 * The class extends the Actor class and handles animation frames and removal when the animation ends.
 * 
 * @Sana
 * @version (A version number or a date)
 */
public class MysteryExplosion extends Actor
{
    // GifImage for bomb explosion animation
    GifImage bombExplosion = new GifImage("2462808_f5a1a.gif");

    // ArrayList to store animation frames
    private ArrayList<GreenfootImage> images;

    // Total delay between animation frames
    private int animationDelayTotal;

    // Remaining delay for the current frame
    private int animationDelayLeft;

    // Index of the current frame being displayed
    private int animationIndex;

    /**
     * Constructor for the MysteryExplosion class.
     * Initializes animation frames, animation delay, and sets the initial image.
     * 
     * @return void
     */
    public MysteryExplosion()
    {
        images = (ArrayList<GreenfootImage>) bombExplosion.getImages();
        animationDelayTotal = 3;
        animationDelayLeft = animationDelayTotal;
        animationIndex = 0;
        setImage(images.get(animationIndex));
    }

    /**
     * The act() method is called on every act cycle.
     * Handles the animation frames and removal of the actor when the animation ends.
     * 
     * @return void
     */
    public void act()
    {
        animationDelayLeft--;
        if (animationDelayLeft == 0) {
            animationIndex++;
            if (animationIndex == images.size()) {
                // Remove the actor when the animation ends
                getWorld().removeObject(this);
                return;
            }
            setImage(images.get(animationIndex));
            animationDelayLeft = animationDelayTotal;
        }
        // Set the current image from the GifImage
        setImage(bombExplosion.getCurrentImage());
    }

    /**
     * Overrides the setImage() method of the Actor class.
     * Scales the image to a desired width and height.
     * 
     * @param image - The image to set for the actor.
     * @return void
     */
    public void setImage(GreenfootImage image)
    {
        int scaledWidth = 280; 
        int scaledHeight = 180; 
        GreenfootImage scaledImage = new GreenfootImage(image);
        scaledImage.scale(scaledWidth, scaledHeight);
        super.setImage(scaledImage);
    }
}
