import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class that represents the game over screen.
 * It displays a game over message and prompts the player to restart the level.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameOver extends WandL
{
    private GreenfootImage gameOver, enter;
    private Levels level;

    /**
     * Constructor for objects of class GameOver.
     * 
     * @param level The instance of the level where the game over occurred.
     */
    public GameOver(Levels level)
    {    
        super();
        this.level = level;
        gameOver = new GreenfootImage("Game Over", 100, Color.WHITE, new Color(0, 0, 0, 0));
        enter = new GreenfootImage("Press enter to restart the level.", 45, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(gameOver, (getWidth() - gameOver.getWidth()) / 2, (getHeight() - gameOver.getHeight()) / 2);
        getBackground().drawImage(enter, (getWidth() - enter.getWidth()) / 2, (getHeight() - enter.getHeight()) / 2 + 100);
    }

    /**
     * Handles the user input. If the 'enter' key is pressed, restart the current level.
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            restartLevel();
        }
    }

    /**
     * Restarts the level based on the current game state.
     */
    private void restartLevel() {
        int levelNum = level.getLNum();
        
        if (levelNum == 1) {
            Greenfoot.setWorld(new LevelOne());
        } else if (levelNum == 2) {
            Greenfoot.setWorld(new LevelTwo());
        } else if (levelNum == 3) {
            Greenfoot.setWorld(new LevelThree());
        }
    }
}
