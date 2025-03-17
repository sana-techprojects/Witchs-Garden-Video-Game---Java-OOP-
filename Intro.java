import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootImage;

/**
 * Intro class represents the introductory world in the game.
 * This class handles the display of opening frames and introductory dialogues.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    int idx = 0; // Index to keep track of the current dialogue position
    boolean paused = false; // Flag to control the pause between dialogues
    Textbox textbox = new Textbox(); // Textbox to display dialogues
    ArrayList<String> dialogue; // List to store the dialogues
    String[] temp; // Temporary array to store a subset of dialogues
    SimpleTimer pauseTimer = new SimpleTimer(); // Timer to control the pause duration

    private SuperTextBox testBox; // Custom textbox for displaying multiple lines of text
    private Font boringFont; // Font for the text
    
    // Opening frames
    GreenfootImage frame1 = new GreenfootImage("images/Opening0.png");
    GreenfootImage frame2 = new GreenfootImage("images/Opening1.png");
    GreenfootImage frame3 = new GreenfootImage("images/Opening2.png");
    GreenfootImage frame4 = new GreenfootImage("images/Opening3.png");

    /**
     * Constructor for objects of class Intro.
     * Initializes the world with a specified size and adds necessary objects.
     */
    public Intro()
    {    
        super(1000, 530, 1); // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        setBackground(frame1);
        addObject(textbox, 500, 400);
        dialogue = new ArrayList<String>();
        
        // Initialize dialogues
        dialogue.add("There was once two witches living in the forest");
        dialogue.add("Both were on good terms with each other");
        dialogue.add("The witch Clemontine loved to grow and breed magical plants");
        dialogue.add("The witch Mire loved to perform necromancy on the recently deceased");
        dialogue.add("However, one day, Mire shut herself from others,");
        dialogue.add("refusing to even show her face");
        dialogue.add("Soon after, the other noticed something unusual...");
        dialogue.add("Because anyone who died near the witch's tower are reanimated back to life...");
        dialogue.add("Soon after, the other noticed something unusual...");
        dialogue.add("Because anyone who died near the witch's tower are reanimated back to life...");
        
        // Initialize font and textbox
        boringFont= new Font ("Times New Roman", false, false, 22);
        temp = new String[2];
        for (int i = 0; i < 2; i++){
            temp[i] = dialogue.get(i);
        }

        testBox = new SuperTextBox(temp, new Color(214,204,189), Color.BLACK, boringFont, true, 700, 3, new Color(214,204,189));
        testBox.forceHeight(400);
        addObject(testBox, 500, 400);
    }

    /**
     * Act method is called on every frame update.
     * Handles user input for progressing through dialogues and changing frames.
     */
    public void act()
    {
        StartingScreen.bgMusic2.playLoop();
        
        if(Greenfoot.isKeyDown("space") && !paused)
        {
            // Update the textbox with the next set of dialogues
            testBox.update(new String[]{dialogue.get(idx + 2), dialogue.get(idx + 3)});
            paused = true;
            pauseTimer.mark();
            idx += 2;
        } 
        
        // Reset the pause flag after a certain duration
        if(pauseTimer.millisElapsed() > 80)
        {
            paused = false;
        }
        
        // Change background frames based on dialogue progress
        if(idx == 2)
        {
            setBackground(frame2);
        }
        
        if(idx == 4)
        {
            setBackground(frame3);
        }
        
        if(idx == 6)
        {
            setBackground(frame4);
        }
        
        // Switch to the Tutorial world when the last dialogue is reached
        if(idx == 8)
        {
            Tutorial world = new Tutorial();
            Greenfoot.setWorld(world);
        }
    }

    /**
     * Called when the world is started. Plays background music.
     */
    public void started()
    {
        StartingScreen.bgMusic2.playLoop();
    }

    /**
     * Called when the world is stopped. Stops background music.
     */
    public void stopped()
    {
        StartingScreen.bgMusic2.stop();
        StartingScreen.bgMusic.stop();
    }
}
