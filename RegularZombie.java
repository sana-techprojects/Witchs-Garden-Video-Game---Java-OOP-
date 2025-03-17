import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The RegularZombie class represents a zombie with no special features.
 * It extends the Zombies class.
 * 
 * Made by: Harithan Raveendran
 * Last Modified: Dec 27, 2023
 */
public class RegularZombie extends Zombies
{
    private static final int ATTACK_COOLDOWN = 1000;
    private GreenfootImage image;
    private GifImage gif;
    private ArrayList<GreenfootImage> images;
    private int index, counter;

    /**
     * Constructor for the RegularZombie class.
     * Initializes the image, attributes, and timers.
     */
    public RegularZombie(){
        speedValue = 0.25;
        speed = speedValue;
        health = 18;
        attacking = false;
        attTimer = new SimpleTimer();
        gif = new GifImage ("wz.gif");
        image = gif.getCurrentImage();
        images = (ArrayList<GreenfootImage>)(gif.getImages());
        setImage(image);
        counter = 0;
        index = 0;
    }

    /**
     * The act() method is called on every act cycle.
     * It handles the zombie's behavior, including attacking and animation.
     */
    public void act()
    {
        attack();
        if(attacking){
            int ms = attTimer.millisElapsed();
            if(ms >= ATTACK_COOLDOWN){
                attacking = false;
            }
        }
        image = images.get(index);
        image.scale(100, 100);
        setImage(image);
        counter++;
        if (counter % 6 == 0){
            index++;
        }
        if (index == images.size()){
            index = 0;
        }
        
        super.act();
    }

    /**
     * Handles the zombie's attacking behavior.
     * If a plant is nearby, it attacks the plant.
     */
    public void attack(){
        p = (Plants)getOneObjectAtOffset(getImage().getWidth()/2 * -1, getImage().getHeight()/2, Plants.class);
        if(p != null){
            speed = 0;
            if(!attacking){
                attTimer.mark();
                p.decreaseH(5);
                attacking = true;
            }
        }
        else{
            speed = speedValue;
        }
    }
}
