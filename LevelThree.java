import greenfoot.*;

/**
 * LevelThree class represents the third level of the game.
 * This class extends the base Levels class and adds specific behaviors and elements for Level Three.
 * 
 * @author Harithan Raveendran
 * @version January 19, 2024
 */
public class LevelThree extends Levels {
    private ToxicFog toxicFog;
    private boolean isToxicFogActive = false;
    
    TreasureBox box = new TreasureBox();
    GlowingTreasureBox glow = new GlowingTreasureBox();
    
    /**
     * Constructor for objects of class LevelThree.
     * Initializes the level-specific properties such as initial zombies and spawner intervals.
     */
    public LevelThree() {
        super();
        addObject(walnutPacket, 115, 300);
        addObject(repeaterPacket, 115, 363);
        currentZeds = 60;
        zedsLeft = 60;
        zPerTime = 1;
        spawner = 400;
        levelNum = 3;
        
        addObject(glow, 115, 420);
        addObject(box, 115, 420);
    }
    
    /**
     * Constructor for objects of class LevelThree with outcomeAmount parameter.
     * Calls the default constructor and updates the money in the SunCollector class.
     * 
     * @param outcomeAmount - The amount of money gained.
     */
    public LevelThree(int outcomeAmount) {
        this(); // Call the default constructor
        SunCollector sunCollector = getObjects(SunCollector.class).isEmpty() ? null : getObjects(SunCollector.class).get(0);
        if (sunCollector != null) {
            sunCollector.addMoney(outcomeAmount);
        }
    }
    
    /**
     * Act method is called on every frame update.
     * Handles the spawning of falling suns, zombie waves, toxic fog, and transitions to the next level.
     */
    public void act() {
        bgm.playLoop();
        sunSpawnTimer--;
        if (sunSpawnTimer <= 0) {
            spawnFallingSun();
            sunSpawnTimer = sunSpawnInterval;
        }

        spawner--;
        if(spawner <= 0){
            if(currentZeds <= 55){
                zPerTime = 2;
            }
            else if(currentZeds <= 40){
                zPerTime = 3;
            }
            for(int i = 0; i < zPerTime; i++){
                int random = Greenfoot.getRandomNumber(5);
                int randomZomb = Greenfoot.getRandomNumber(10);
                if(randomZomb < 6){
                    addObject(new RegularZombie(), 999, spawnPoint[random] - 30);
                    random = Greenfoot.getRandomNumber(5);
                }
                else if(randomZomb >= 6 && randomZomb <= 8 && currentZeds <= 50){
                    addObject(new PoleZombie(), 999, spawnPoint[random] - 30);
                    random = Greenfoot.getRandomNumber(5);
                }
                else if(randomZomb > 8 && currentZeds <= 50){
                    addObject(new NewsZombie(), 999, spawnPoint[random] - 10);
                    random = Greenfoot.getRandomNumber(5);
                }
            }
            if(currentZeds >= 40){
                spawner = 400;
            }
            else{
                spawner = 200;
            }
        }
        
        if (Greenfoot.isKeyDown("space")) {
            toggleToxicFog();
        }
        
        updateToxicFog();
        
        if(currentZeds <= 0){
            bgm.stop();
            Greenfoot.setWorld(new Opening4());
        }

        super.act();
    }
    
    /**
     * Update the money in the SunCollector class or any other relevant class.
     * 
     * @param amount - The amount of money gained.
     */
    public void updateMoney(int amount) {
        SunCollector sunCollector = (SunCollector) getObjects(SunCollector.class).get(0);
        sunCollector.addMoney(amount);
    }

    /**
     * Initializes the grid layout for the level.
     */
    public void initializeGrid() {
        super.initializeGrid();
    }

    /**
     * Get the current level number.
     * 
     * @return int - The current level number.
     */
    public int getLNum() {
        return levelNum;
    }

    private void toggleToxicFog() {
        if (isToxicFogActive) {
            removeObject(toxicFog);
        } else {
            toxicFog = new ToxicFog();
            addObject(toxicFog, getWidth() / 2, getHeight() / 2);
        }

        isToxicFogActive = !isToxicFogActive;
    }

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
     * @param row The row index.
     * @param col The column index.
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
}
