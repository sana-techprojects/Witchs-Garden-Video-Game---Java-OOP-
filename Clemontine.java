import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Represents the character Clemontine with different emotions.
 * The class provides methods to animate Clemontine with different emotions.
 * 
 * Note: Assumes the existence of image files for each emotion.
 * Adjust the file paths and content as needed.
 * 
 * @author (Your Name)
 * @version (A version number or a date)
 */
public class Clemontine extends Actor
{
    // Default angry image for initialization
    GreenfootImage angry = new GreenfootImage("images/Angry0.png");

    // Lists of images for different emotions
    private ArrayList<GreenfootImage> emotion1;  // Angry
    private ArrayList<GreenfootImage> emotion2;  // Pouty
    private ArrayList<GreenfootImage> emotion3;  // Happy
    
    // Timer for controlling animation speed
    SimpleTimer animationTimer = new SimpleTimer();
    
    // Frame counter for animation
    int frame = 0;

    /**
     * Constructor for objects of class Clemontine.
     * Initializes Clemontine with different emotion images.
     */
    public Clemontine()
    {
        emotion1 = new ArrayList<GreenfootImage>();
        emotion2 = new ArrayList<GreenfootImage>();
        emotion3 = new ArrayList<GreenfootImage>();
        
        // Default angry image for initialization
        setImage(angry);
        
        // Populate emotion image lists
        emotion1.add(new GreenfootImage("images/Angry0.png"));
        emotion1.add(new GreenfootImage("images/Angry1.png"));
        
        emotion2.add(new GreenfootImage("images/Pouty0.png"));
        emotion2.add(new GreenfootImage("images/Pouty1.png"));
        emotion2.add(new GreenfootImage("images/Pouty2.png"));
        emotion2.add(new GreenfootImage("images/Pouty1.png"));
        
        emotion3.add(new GreenfootImage("images/Happy0.png"));
        emotion3.add(new GreenfootImage("images/Happy1.png"));
        emotion3.add(new GreenfootImage("images/Happy2.png"));
        emotion3.add(new GreenfootImage("images/Happy1.png"));
    }

    /**
     * Act - Perform the action specified for Clemontine.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        animateAngry();  // Example: Animating with the angry emotion
    }

    /**
     * Animates Clemontine with the specified emotion.
     * 
     * @param a The ArrayList of GreenfootImage representing the emotion frames.
     * @return void
     */
    public void animate(ArrayList<GreenfootImage> a)
    {
        if (animationTimer.millisElapsed() < 250)
        {
            return;
        }
        animationTimer.mark();

        setImage(a.get(frame));
        frame = (frame + 1) % a.size();
    }

    /**
     * Animates Clemontine with the angry emotion.
     * 
     * @return void
     */
    public void animateAngry()
    {
        animate(emotion1);
    }

    /**
     * Animates Clemontine with the pouty emotion.
     * 
     * @return void
     */
    public void animatePouty()
    {
        animate(emotion2);
    }

    /**
     * Animates Clemontine with the happy emotion.
     * 
     * @return void
     */
    public void animateHappy()
    {
        animate(emotion3);
    }
}
