import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Represents a coin that has a 50% chance of improving a trait of the peashooters or a trait of the zombies.
 * The coin falls down the screen, and when clicked, it randomly enhances the speed of peashooters or zombies.
 * 
 * Note: Assumes the existence of an image file named "Coin.png" for visualization. Adjust the file path and content as needed.
 * 
 * @author Harithan Raveendran
 * @version Jan 12, 2024
 */
public class FallingCoin extends FallingItems
{
    // The chance of improving a trait (0 or 1)
    private int chance;
    
    // The image representing the falling coin
    private GreenfootImage image;

    /**
     * Constructor for objects of class FallingCoin.
     * Initializes the falling speed, image, and repetition flag.
     * Adjust the image file path and content as needed.
     */
    public FallingCoin(){
        fallSpeed = 2;
        image = new GreenfootImage("Coin.png");
        image.scale(45, 45);
        setImage(image);
        repeating = false;
    }

    /**
     * Act method for the falling coin.
     * Delegates to the superclass act method.
     * 
     * @return void
     */
    public void act()
    {
        super.act();   
    }

    /**
     * Handles the behavior when the falling coin is clicked.
     * Randomly enhances the speed of peashooters or zombies based on a 50% chance.
     * 
     * @return void
     */
    public void click(){      
        if (Greenfoot.mouseClicked(this)) {
            chance = Greenfoot.getRandomNumber(2);
            if(chance == 0){
                // Enhance speed of peashooters
                ArrayList<Shooter> s = (ArrayList<Shooter>)getWorld().getObjects(Shooter.class);
                if(s.size() > 0){
                    for(Shooter sh : s){
                        sh.speedUp();
                    }
                }
            }
            else{
                // Enhance speed of zombies
                ArrayList<Zombies> z = (ArrayList<Zombies>)getWorld().getObjects(Zombies.class);
                if(z.size() > 0){
                    for(Zombies zo : z){
                        zo.moveFaster();
                    }
                }
            }
            // Remove the falling coin from the world after the action
            getWorld().removeObject(this);
        }
    }
}
