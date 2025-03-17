import greenfoot.*;
import java.util.ArrayList;

/**
 * Opening3 class represents the third opening scene of the game.
 * This class sets up the initial dialogue and transitions to the next level.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Opening3 extends World
{
    Clemontine clemontine = new Clemontine();
    int idx = 0;
    boolean paused = false;
    Textbox textbox = new Textbox();
    ArrayList<String> dialogue;
    String[] temp;
    SimpleTimer pauseTimer = new SimpleTimer();

    private SuperTextBox testBox;
    private Font boringFont;
    
    public static GreenfootSound bgMusic = new GreenfootSound("04. Grasswalk.mp3");
    
    /**
     * Constructor for objects of class Opening3.
     */
    public Opening3()
    {    
        // Create a new world with 1000x530 cells with a cell size of 1x1 pixels.
        super(1000, 530, 1);
        addObject(clemontine, 500, 265);
        addObject(textbox, 500, 400);
        dialogue = new ArrayList<String>();
        //dialogues
        dialogue.add("Alright, I've made my preparations to pay Mire a visit");
        dialogue.add("Just need to get rid of the zombies in front of my garden first");
        dialogue.add("*Sigh*");
        dialogue.add("I really wish that girl had other hobbies other than this");
        dialogue.add("Maybe she should just get out of her tower more often...");
        dialogue.add("It'll improve her social skills");
        dialogue.add("That's it");
        dialogue.add("I'm gonna teach her how to garden after all of this!");
        dialogue.add("That's it");
        dialogue.add("I'm gonna teach her how to garden after all of this!");
        boringFont= new Font ("Times New Roman", false, false, 22);
        temp = new String[2];
        for (int i = 0; i < 2; i++){
            temp[i] = dialogue.get(i);
        }

        testBox = new SuperTextBox(temp, new Color(214,204,189), Color.BLACK, boringFont, true, 620, 3, new Color(214,204,189));
        testBox.forceHeight(400);
        addObject(testBox, 500, 400);
    }
    
    /**
     * Act method is called on every frame update.
     * Handles the progression of dialogue and transitions to the next level.
     */
    public void act()
    {
        bgMusic.playLoop();
        if(Greenfoot.isKeyDown("space") && !paused)
        {
            testBox.update(new String[]{dialogue.get(idx + 2), dialogue.get(idx + 3)});
            paused = true;
            pauseTimer.mark();
            idx += 2;
        } 

        if(idx == 6)
        {
            clemontine.animatePouty();
        }
        
        if(idx == 8)
        {
            LevelThree world = new LevelThree();
            Greenfoot.setWorld(world);
            Opening1.bgMusic.stop();
        }
        
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
        Opening1.bgMusic.playLoop();
    }
    
    /**
     * Called when the world is stopped. Stops background music.
     */
    public void stopped()
    {
        StartingScreen.bgMusic2.stop();
        StartingScreen.bgMusic.stop();
        Levels.bgm.stop();
        Opening1.bgMusic.stop();
    }

    /**
     * Get the next dialogue sentence.
     * 
     * @return String - The next dialogue sentence.
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
