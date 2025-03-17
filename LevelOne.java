import greenfoot.*;
import java.util.ArrayList;

/**
 * LevelOne class represents the first level in the game.
 * This class extends the base Levels class and adds specific behaviors and elements for Level One.
 * 
 * @author Sana Pardiwala
 * @version January 1, 2024
 * Modified by: Harithan Raveendran, ...
 */
public class LevelOne extends Levels {
    
    /**
     * Constructor for objects of class LevelOne.
     * Initializes the level-specific properties such as initial zombies and spawner intervals.
     */
    public LevelOne() {
        super();
        currentZeds = 25;
        zedsLeft = 25;
        spawner = 500;
        levelNum = 1;
    }

    /**
     * Called when the world is stopped. Stops background music.
     */
    public void stopped() {
        Opening1.bgMusic.stop();
        StartingScreen.bgMusic2.stop();
        StartingScreen.bgMusic.stop();
        bgm.stop();
    }
    
    /**
     * Called when the world is started. Plays background music.
     */
    public void started() {
        bgm.playLoop();
    }

    /**
     * Act method is called on every frame update.
     * Handles the spawning of falling suns, zombie waves, and transitions to the next level.
     */
    public void act() {
        bgm.playLoop();
        sunSpawnTimer--;
        if (sunSpawnTimer <= 0) {
            spawnFallingSun();
            sunSpawnTimer = sunSpawnInterval;
        }

        spawner--;
        if(spawner <= 0 && zedsLeft != 0){
            int totalZombies = 0;
            int random = Greenfoot.getRandomNumber(5);
            if(totalZombies < currentZeds){
                addObject(new RegularZombie(), 999, spawnPoint[random] + 15);
                zedsLeft--;
                totalZombies++;
            }
            if(currentZeds >= 13){ 
                spawner = 500;
            }
            else{
                spawner = 300;
            }
        }     
        if(currentZeds <= 0){
            bgm.stop();
            Greenfoot.setWorld(new Opening2());
        }
        
        super.act();
    }

    /**
     * Get the cell at the specified row and column.
     * 
     * @param row - The row index.
     * @param col - The column index.
     * @return Cell - The Cell object at the specified row and column.
     */
    public Cell getCellAt(int row, int col) {
        return cells[row][col];
    }

    /**
     * Spawn a falling sun at a random X-coordinate at the top of the screen.
     */
    private void spawnFallingSun() {
        int randomX = Greenfoot.getRandomNumber(getWidth());
        addObject(new FallingSun(), randomX, 0);
    }
}
