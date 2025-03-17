import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Levels class represents the base class for game levels.
 * This class provides the foundation for grid-based gameplay, zombie tracking, and level-specific elements.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{
    protected int currentZeds, levelNum, zedsLeft;
    protected boolean updated;
    protected static final int CELL_SIZE = 80; // Adjust the cell size as needed

    protected static final int ROWS = 5;
    protected static final int COLS = 9;

    protected Cell[][] cells;
    protected int[] spawnPoint = {105, 185, 265, 345, 425};
    protected int spawner, zPerTime;

    protected GreenfootImage background = new GreenfootImage("Background.png");
    protected SimpleTimer spawnTimer = new SimpleTimer();
    protected RegularZombie r;
    protected Sunflower sunflower;
    protected PeashooterPacket peashooterPacket = new PeashooterPacket();
    protected WalnutPacket walnutPacket = new WalnutPacket();
    protected SunflowerPacket sunflowerPacket = new SunflowerPacket();
    protected RepeaterPacket repeaterPacket = new RepeaterPacket();
    protected SunCollector sunCollector = new SunCollector();

    protected int sunSpawnInterval = 600; // Adjust the interval as needed
    protected int sunSpawnTimer = sunSpawnInterval;

    public static GreenfootSound bgm = new GreenfootSound("Plants vs Zombies - Main Menu.mp3");
    protected GreenfootImage zeds;

    /**
     * Constructor for objects of class Levels.
     * Initializes the world with a specified size and adds necessary objects.
     */
    public Levels()
    {    
        super(1000, 530, 1, false); // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        background.scale(1000,530);
        setBackground(background);
        cells = new Cell[ROWS][COLS];
        r = new RegularZombie();
        initializeGrid();
        addObject(sunflowerPacket, 115, 178);
        addObject(peashooterPacket, 115, 241);
        addObject(sunCollector, 115, 111);
        updated = false;
    }

    /**
     * Act method is called on every frame update.
     * Monitors the state of zombies and triggers GameOver if needed.
     */
    public void act(){
        ArrayList<Zombies> zeds = (ArrayList<Zombies>)getObjects(Zombies.class);
        for(Zombies zo : zeds){
            if(zo.getX() <= 0){
                Greenfoot.setWorld(new GameOver(this));
            }
            if(zo.getDead() == true){
                if(zo.getCurrDecreased() == false){
                    currentZeds--;
                    updated = false;
                    zo.setCurrDecreased(true);
                }
            }
        }
    }

    /**
     * Initializes the grid layout for the level.
     */
    protected void initializeGrid() {
        int gridWidth = COLS * CELL_SIZE;
        int gridHeight = ROWS * CELL_SIZE;

        int startX = ((getWidth() - gridWidth) /2)+40;
        int startY = ((getHeight() - gridHeight) /2);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col] = new Cell();
                int x = startX + col * CELL_SIZE + CELL_SIZE / 2;
                int y = startY + row * CELL_SIZE + CELL_SIZE / 2;
                addObject(cells[row][col], x, y);
            }
        }
    }

    /**
     * Get the current level number.
     * 
     * @return int - The current level number.
     */
    public int getLNum(){
        return levelNum;
    }
}
