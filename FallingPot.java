import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Represents a falling pot that, when clicked, slows down a randomly selected regular shooter's peas.
 * The pot falls down the screen, and when clicked, it targets a random regular shooter and slows down its peas.
 * 
 * Note: Assumes the existence of an image file named "pt2.png" for visualization. Adjust the file path and content as needed.
 * 
 * @author (Your Name)
 * @version (A version number or a date)
 */
public class FallingPot extends FallingItems
{
    // The image representing the falling pot
    private GreenfootImage image;

    /**
     * Constructor for objects of class FallingPot.
     * Initializes the falling speed, image, and repetition flag.
     * Adjust the image file path and content as needed.
     */
    public FallingPot(){
        fallSpeed = 2;
        image = new GreenfootImage("pt2.png");
        image.scale(55, 55);
        setImage(image);
        repeating = false;
    }

    /**
     * Act method for the falling pot.
     * Delegates to the superclass act method.
     * 
     * @return void
     */
    public void act()
    {
        super.act();
    }

    /**
     * Handles the behavior when the falling pot is clicked.
     * Slows down the peas of a randomly selected regular shooter.
     * 
     * @return void
     */
    public void click(){
        if(Greenfoot.mouseClicked(this)){
            ArrayList<RegShoot> s = (ArrayList<RegShoot>)getWorld().getObjects(RegShoot.class);         
            if(s.size() > 0){
                int random = Greenfoot.getRandomNumber(s.size());
                for(RegShoot sh : s){
                    sh = s.get(random);
                    // Check if the shooter's peas are not already slowed down
                    if(sh.getSlower() == false){
                        sh.slowPeas();
                    }   
                }
                // Remove the falling pot from the world after the action
                getWorld().removeObject(this); 
            }
        }
    }
}
