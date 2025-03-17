import greenfoot.*;
import java.util.List;

/**
 * LevelTwo class represents the second level of the game.
 * This class extends the base Levels class and adds specific behaviors and elements for Level Two.
 * 
 * @author Sana Pardiwala
 * @version January 1, 2024
 * Modified by: Harithan Raveendran, ...
 */
public class LevelTwo extends Levels {
    private ToxicFog toxicFog;
    private boolean isToxicFogActive = false;
    private WalnutPacket walnutPacket = new WalnutPacket();
    private SimpleTimer mysteryBoxTimer = new SimpleTimer();
    private SimpleTimer toxicFogTimer = new SimpleTimer();
    
    /**
     * Constructor for objects of class LevelTwo.
     * Initializes the level-specific properties such as initial zombies and spawner intervals.
     */
    public LevelTwo() {
        super();
        addObject(walnutPacket, 115, 300);
        currentZeds = 40;
        zedsLeft = 40;
        zPerTime = 1;
        spawner = 400;
        levelNum = 2;
        mysteryBoxTimer.mark();
        toxicFogTimer.mark();
    }

    /**
     * Act method is called on every frame update.
     * Handles the spawning of falling suns, zombie waves, toxic fog, mystery boxes, and transitions to the next level.
     */
    public void act(){
        bgm.playLoop();
        sunSpawnTimer--;
        if (sunSpawnTimer <= 0) {
            spawnFallingSun();
            sunSpawnTimer = sunSpawnInterval;
        }

        spawner--;
        if(spawner <= 0){
            if(currentZeds <= 25){
                zPerTime = 2;
            }
            for(int i = 0; i < zPerTime; i++){
                int random = Greenfoot.getRandomNumber(5);
                int randomZomb = Greenfoot.getRandomNumber(4);
                if(randomZomb < 3){
                    addObject(new RegularZombie(), 999, spawnPoint[random] - 30);
                    random = Greenfoot.getRandomNumber(5);
                }
                else if(randomZomb == 3 && currentZeds <= 25){
                    addObject(new PoleZombie(), 999, spawnPoint[random] - 30);
                    random = Greenfoot.getRandomNumber(5);
                }
            }
            if(currentZeds >= 30){
                spawner = 400;
            }
            else{
                spawner = 200;
            }
        }
        
        if (toxicFogTimer.millisElapsed() > getRandomToxicFogInterval()) {
            toggleToxicFog();
            toxicFogTimer.mark();
        }

        updateToxicFog();
        
        spawnMysteryBoxes();
        if(currentZeds <= 0){
            bgm.stop();
            Greenfoot.setWorld(new Opening3());
        }

        super.act();
    }
    
    /**
     * Get a random interval for toxic fog activation (in milliseconds).
     * 
     * @return A random interval for toxic fog activation.
     */
    private int getRandomToxicFogInterval() {
        return Greenfoot.getRandomNumber(15000) + 55000; // 15 to 30 seconds
    }

    /**
     * Toggle the toxic fog on and off.
     */
    private void toggleToxicFog() {
        if (isToxicFogActive) {
            removeObject(toxicFog);
        } else {
            toxicFog = new ToxicFog();
            addObject(toxicFog, getWidth() / 2, getHeight() / 2);
        }

        isToxicFogActive = !isToxicFogActive;
    }

    /**
     * Update the toxic fog state.
     */
    private void updateToxicFog() {
        if (toxicFog != null) {
            toxicFog.setActive(isToxicFogActive);
        }
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
     * Spawn a falling sun with a random type (normal, coin, or pot) at a random X-coordinate at the top of the screen.
     */
    private void spawnFallingSun() {
        int randomX = Greenfoot.getRandomNumber(getWidth());
        int randomSpawn = Greenfoot.getRandomNumber(20);
        
        if(randomSpawn < 17){
            addObject(new FallingSun(), randomX, 0);
        } else if(randomSpawn >= 17 && randomSpawn < 18){
            addObject(new FallingCoin(), randomX, 0);
        } else if(randomSpawn >= 18){
            addObject(new FallingPot(), randomX, 0);
        }
    }
    
    /**
     * Spawn mystery boxes at random intervals.
     */
    private void spawnMysteryBoxes() {
        int mysteryBoxSpawnInterval = 35000; // Set the interval for Mystery Box spawning (in milliseconds)
    
        if (mysteryBoxTimer.millisElapsed() > mysteryBoxSpawnInterval) {
            int randomCol = Greenfoot.getRandomNumber(COLS);
            int randomRow = Greenfoot.getRandomNumber(ROWS);
    
            Cell cell = cells[randomRow][randomCol];
            if (cell != null) {
                List<MysteryBox> boxes = getObjectsAt(cell.getX() + 10, cell.getY() + 20, MysteryBox.class);
                
                if (boxes.isEmpty()) {
                    addObject(new MysteryBox(), cell.getX(), cell.getY());
                }
            }
    
            mysteryBoxTimer.mark();
        }
    }   
}
