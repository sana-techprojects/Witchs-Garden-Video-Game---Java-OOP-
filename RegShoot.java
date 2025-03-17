import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The most basic peashooter; shoots one pea at a time at any zombies.
 * Extends the Shooter class and provides additional functionality for regular shooting.
 * 
 * @author Harithan Raveendran
 * @version January 19, 2024
 */
public class RegShoot extends Shooter
{
    // Image for regular peashooter
    private GreenfootImage image;

    // Image for ice peashooter
    private GreenfootImage iceImage;

    // GifImage for animated regular peashooter
    private GifImage gif;

    // List of images for the animated regular peashooter
    private ArrayList<GreenfootImage> images;

    // Index of the current image in the animation sequence
    private int index;

    // Counter for animation frame control
    private int counter;

    // Flag indicating if the shooter has changed to ice mode
    private boolean changed;

    /**
     * Constructor for objects of class RegShoot.
     * Initializes default values, images, and animation parameters.
     * 
     * @return void
     */
    public RegShoot(){
        super();
        iceImage = new GreenfootImage("Ice peashooter.png");
        iceImage.scale(65, 65);
        gif = new GifImage ("peashooter.gif");
        image = gif.getCurrentImage();
        image.scale(65,65);
        images = (ArrayList<GreenfootImage>)(gif.getImages());
        setImage(image);
        counter = 0;
        index = 0;
        cost = 100;
        changed = false;
    }

    /**
     * The act() method is called on every act cycle.
     * Handles animation, shooting, and superclass act.
     * 
     * @return void
     */
    public void act(){
        animate();
        super.act();
        //shoot();
    }

    /**
     * Animates the regular peashooter.
     * Handles image changes for the animated regular peashooter and ice peashooter.
     * 
     * @return void
     */
    private void animate(){
        if(!slower){
            image = images.get(index);
            setImage(image);
            counter++;
            if (counter % 2 == 0){
                index++;
            }
            if (index == images.size()){
                index = 0;
            }
            image.scale(65, 65);
        }
        else{
            if(!changed){
                setImage(iceImage);
                changed = true;
            }
        }
    }

    /**
     * Shoots projectiles based on shooting rate and mode.
     * Overrides the shoot() method of the Shooter class.
     * 
     * @return void
     */
    public void shoot(){
        if(time <= 0 && placed) {
            time = timeAmount;
            if(!slower){
                getWorld().addObject(new NormalProjectile("shooter_projectile.png"), getX(), getY() - 20);
            }
            else{
                getWorld().addObject(new SlowProjectile("ice.png"), getX(), getY() - 20);
            }
        } else {
            time--;
        }
    }

    /**
     * Gets the slower status of the shooter.
     * 
     * @return boolean Returns true if the shooter is in ice mode, false otherwise.
     */
    public boolean getSlower(){
        return slower;
    }

    /**
     * Sets the slower status of the shooter.
     * 
     * @param slower The slower status to set.
     * @return void
     */
    public void setSlower(boolean slower){
        this.slower = slower;
    }
}
