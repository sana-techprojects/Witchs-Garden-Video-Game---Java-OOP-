import greenfoot.*;  

/**
 * The world that provides a tutorial for the game.
 * It explains various aspects of gameplay to the player.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tutorial extends World {
    private GreenfootImage text1, text2, text3, text4, text5, text6, text7;
    private boolean added;
    protected GreenfootImage background = new GreenfootImage("Background.png");

    /**
     * Constructor for objects of class Tutorial.
     */
    public Tutorial() {    
        super(1000, 530, 1); 
        setBackground(background);
        added = false;

        // Initialize tutorial text images
        text1 = new GreenfootImage("Click on packets like these to buy a plant; any plant you buy will follow your cursor.", 25, Color.WHITE, new Color(0, 0, 0, 0));
        text2 = new GreenfootImage("Place your plants on grids like these.", 25, Color.WHITE, new Color(0, 0, 0, 0));
        text3 = new GreenfootImage("Gather sun from sunflowers or the sky to buy plants; hover your mouse over them to collect them.", 25, Color.WHITE, new Color(0, 0, 0, 0));
        text4 = new GreenfootImage("Kill zombies with the help of plants like peashooters.", 25, Color.WHITE, new Color(0, 0, 0, 0));
        text5 = new GreenfootImage("Complete each level by killing all the zombies.", 25, Color.WHITE, new Color(0, 0, 0, 0));
        text6 = new GreenfootImage("Press shift again to go back to the main menu.", 40, Color.WHITE, new Color(0, 0, 0, 0));
        text7 = new GreenfootImage("Click on items like these to activate any powerups.", 25, Color.WHITE, new Color(0, 0, 0, 0));

        // Draw tutorial text on the background
        getBackground().drawImage(text1, 0, 20);
        getBackground().drawImage(text2, 0, 100);  
        getBackground().drawImage(text3, 0, 180);
        getBackground().drawImage(text4, 0, 260);  
        getBackground().drawImage(text5, 0, 340);
        getBackground().drawImage(text6, 0, 480);
        getBackground().drawImage(text7, 0, 420);

        // Add images to demonstrate game elements
        addObject(new Images("peashooterpacket1.png", 60, 60), 795, 30);
        addObject(new Images("wallnut.png", 80, 80), 385, 110);
        addObject(new Images("sun1.png", 55, 55), 920, 190);
        addObject(new Images("sunflower.gif", 55, 55), 980, 185);
        addObject(new Images("peashooter.gif", 90, 90), 525, 270);
        addObject(new Images("wz.gif", 90, 90), 455, 350);
        addObject(new Images("pt2.png", 60, 60), 505, 440);
    }
    
    /**
     * Called when the act button is pressed.
     * It handles key events to navigate to other screens.
     */
    public void act() {
        StartingScreen.bgMusic2.playLoop();
        handleKeyEvents();
    }
    
    /**
     * Called when the world is started.
     * It plays background music.
     */
    public void started() {
        StartingScreen.bgMusic2.playLoop();
    }
    
    /**
     * Called when the world is stopped.
     * It stops background music.
     */
    public void stopped() {
        StartingScreen.bgMusic2.stop();
        StartingScreen.bgMusic.stop();
    }

    /**
     * Handles key events to navigate to other screens.
     */
    private void handleKeyEvents() {
        if(Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Opening1());
            StartingScreen.bgMusic2.stop();
        }
        if(Greenfoot.isKeyDown("shift")) {
            Greenfoot.setWorld(new StartingScreen());
            StartingScreen.bgMusic2.stop();
            StartingScreen.bgMusic.stop();
        }
    }
}
