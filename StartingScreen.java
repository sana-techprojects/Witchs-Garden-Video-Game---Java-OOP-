import greenfoot.*;  

/**
 * The world that appears when a player starts the game.
 * It serves as the starting screen with a start button.
 * 
 * @author Harithan Raveendran
 * @version January 19, 2024
 */
public class StartingScreen extends World {
    private GreenfootImage background = new GreenfootImage("Startscreen.png");
    private StartButton startButton = new StartButton();
    public static GreenfootSound bgMusic = new GreenfootSound("spellcraft-142264.mp3");
    public static GreenfootSound bgMusic2 = new GreenfootSound("03. Choose Your Seeds.mp3");

    /**
     * Constructor for objects of class StartingScreen.
     */
    public StartingScreen() {
        super(1000, 530, 1, false);
        setBackground(background);
        addObject(startButton, 500, 409);
    }
    
    /**
     * Called when the act button is pressed.
     * It plays background music.
     */
    public void act() {
        bgMusic.playLoop();
    }
    
    /**
     * Called when the world is started.
     * It plays background music.
     */
    public void started() {
        bgMusic.playLoop();
    }
    
    /**
     * Called when the world is stopped.
     * It stops background music.
     */
    public void stopped() {
        bgMusic.stop();
    }
}
