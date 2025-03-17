import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The BombGIF class represents an actor that displays an animated bomb explosion.
 * It extends the Actor class.
 * 
 * The BombGIF actor uses a GifImage to handle the animation frames of the explosion.
 * It contains an ArrayList of GreenfootImages for the animation frames.
 * The animationDelayTotal determines the delay between animation frames.
 * The animationDelayLeft keeps track of the remaining delay for the current frame.
 * The animationIndex indicates the current frame being displayed.
 * 
 * @Sana
 * @version (a version number or a date)
 */
public class GlowingTreasureBox extends Actor
{
    GifImage bombExplosion = new GifImage("circle-glowing.gif");
    private ArrayList<GreenfootImage> images;
    private int animationDelayTotal, animationDelayLeft, animationIndex;
    
    /**
     * Constructor for the BombGIF class.
     * Initializes the animation frames, animation delay, and sets the initial image.
     */
    public GlowingTreasureBox()
    {
        images = (ArrayList<GreenfootImage>) bombExplosion.getImages();
        animationDelayTotal = 3;
        animationDelayLeft = animationDelayTotal;
        animationIndex = 0;
        setImage(images.get(animationIndex));
    }
    
    /**
     * The act() method is called on every act cycle.
     * It handles the animation frames and removal of the actor when the animation ends.
     */
    public void act()
    {
        animationDelayLeft--;
        if (animationDelayLeft == 0) {
            animationIndex++;
            if (animationIndex == images.size()) {
                getWorld().removeObject(this);
                return;
            }
            setImage(images.get(animationIndex));
            animationDelayLeft = animationDelayTotal;
        }
        setImage(bombExplosion.getCurrentImage());
    }
    
    /**
     * Overrides the setImage() method of the Actor class.
     * Scales the image to a desired width and height.
     * 
     * @param image - The image to set for the actor.
     */
    public void setImage(GreenfootImage image)
    {
        int scaledWidth = 200; 
        int scaledHeight = 110; 
        GreenfootImage scaledImage = new GreenfootImage(image);
        scaledImage.scale(scaledWidth, scaledHeight);
        super.setImage(scaledImage);
    }
}
