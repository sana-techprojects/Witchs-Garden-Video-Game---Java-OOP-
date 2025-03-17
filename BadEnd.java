import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * BadEnd class represents the world for the 'Bad Ending' scenario.
 * This class handles the display of dialogue and progression of the story.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadEnd extends World
{
    //Clemontine clemontine = new Clemontine();
    int idx = 0; // Index to keep track of the current dialogue position
    boolean paused = false; // Flag to control the pause between dialogues
    Textbox textbox = new Textbox(); // Textbox to display dialogues
    ArrayList<String> dialogue; // List to store the dialogues
    String[] temp; // Temporary array to store a subset of dialogues
    SimpleTimer pauseTimer = new SimpleTimer(); // Timer to control the pause duration

    private SuperTextBox testBox; // Custom textbox for displaying multiple lines of text
    private Font boringFont; // Font for the text

    public static GreenfootSound bgMusic = new GreenfootSound("04. Grasswalk.mp3");

    /**
     * Constructor for objects of class BadEnd.
     * Initializes the world with a specified size and adds necessary objects.
     */
    public BadEnd()
    {    
        super(1000, 530, 1); // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        addObject(textbox, 500, 400);
        dialogue = new ArrayList<String>();
        
        // Initialize dialogues
        dialogue.add("Darn it!");
        dialogue.add("They manage to get into my house!");
        dialogue.add("NOOOOOOOOOOOOO!!");
        dialogue.add("STAY AWAY!!");
        dialogue.add("Oops, you reached the 'Bad Ending'");
        dialogue.add("Don't give up and try again!");
        dialogue.add("Oops, you reached the 'Bad Ending'");
        dialogue.add("Don't give up and try again!");
        
        // Initialize font and textbox
        boringFont = new Font("Times New Roman", false, false, 22);
        temp = new String[2];
        for (int i = 0; i < 2; i++){
            temp[i] = dialogue.get(i);
        }
        testBox = new SuperTextBox(temp, new Color(214, 204, 189), Color.BLACK, boringFont, true, 620, 3, new Color(214, 204, 189));
        testBox.forceHeight(400);
        addObject(testBox, 500, 400);
    }

    /**
     * Act method is called on every frame update.
     * Handles user input for progressing through dialogues.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && !paused)
        {
            // Update the textbox with the next set of dialogues
            testBox.update(new String[]{dialogue.get(idx + 2), dialogue.get(idx + 3)});
            paused = true;
            pauseTimer.mark();
            idx += 2;
        } 
        
        if(idx == 6)
        {
            // Switch to the StartingScreen when the last dialogue is reached
            StartingScreen world = new StartingScreen();
            Greenfoot.setWorld(world);
            StartingScreen.bgMusic.stop();
        }
        
        // Reset the pause flag after a certain duration
        if(pauseTimer.millisElapsed() > 80)
        {
            paused = false;
        }
    }

    /**
     * Called when the world is started. Plays background music.
     */
    public void started()
    {
        StartingScreen.bgMusic.playLoop();
    }

    /**
     * Called when the world is stopped. Stops background music.
     */
    public void stopped()
    {
        StartingScreen.bgMusic.stop();
    }

    /**
     * Get the next sentence in the dialogue sequence.
     * @return String - The next sentence in the dialogue sequence.
     */
    private String nextSentence()
    {
        int c = idx;
        if(dialogue.size() > idx)
        {
            c++;
        }
        return dialogue.get(c);
    }
}
