import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class that contains the win and lose screens.
 * 
 * @author Harithan Raveendran
 * @version December 17 2024
 */
public abstract class WandL extends World
{
    protected int level;
    public WandL()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 530, 1, false);
        level = 1;
    }
    
    /**
     * Increases the level by one.
     */
    public void addLevel(){
        level++;
    }
    
    /**
     * Retrieves the current game level.
     * 
     * @return int - The current level.
     */
    public int getLevel(){
        return level;
    }
}
