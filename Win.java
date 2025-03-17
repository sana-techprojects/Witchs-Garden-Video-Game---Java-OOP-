import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The screen that tells the player they finished a level
 * 
 * @author Harithan Raveendran
 * @version January 19 2024
 */
public class Win extends WandL
{
    private GreenfootImage win, enter, enter2, congrats;
    private Levels l;
    private boolean added;
    
    /**
     * Constructor for objects of class Win.
     * 
     * @param le - The instance of the level where the win occurred.
     */
    public Win(Levels le)
    {     
        added = false;
        l = le;
        win = new GreenfootImage("You Win!", 100, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(win, (getWidth()-win.getWidth())/2, (getHeight()-win.getHeight())/2);
        enter = new GreenfootImage("Press enter to move onto the next level.", 45, Color.WHITE, new Color(0, 0, 0, 0));
        enter2 = new GreenfootImage("Press enter to go back to the intro.", 45, Color.WHITE, new Color(0, 0, 0, 0));
        congrats = new GreenfootImage("Thanks for Playing!", 45, Color.WHITE, new Color(0, 0, 0, 0));
    }
    
    /**
     * Handles the transition to the next level or the intro screen based on user input.
     */
    public void act(){
        transition();
    }

    public void transition(){
        if(l.getLNum() == 1){
            if(!added){
                getBackground().drawImage(enter, (getWidth()-enter.getWidth())/2, (getHeight()-enter.getHeight())/2 + 100);
                added = true;
            }
            if(Greenfoot.isKeyDown("enter")){
                Greenfoot.setWorld(new LevelTwo());
            }
        }
        else if(l.getLNum() == 2){
            if(!added){
                getBackground().drawImage(enter, (getWidth()-enter.getWidth())/2, (getHeight()-enter.getHeight())/2 + 100);
                added = true;
            }
            if(Greenfoot.isKeyDown("enter")){
                Greenfoot.setWorld(new LevelThree());
            }
        }
        else if(l.getLNum() == 3){
            if(!added){
                getBackground().drawImage(congrats, (getWidth()-congrats.getWidth())/2, (getHeight()-congrats.getHeight())/2 + 100);
                getBackground().drawImage(enter2, (getWidth()-enter2.getWidth())/2, (getHeight()-enter2.getHeight())/2 + 200);
                added = true;
            }
            if(Greenfoot.isKeyDown("enter")){
                Greenfoot.setWorld(new StartingScreen());
            }
        }
    }
}
