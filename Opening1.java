import greenfoot.*;
import java.util.ArrayList;

/**
 * Opening1 class represents the first opening scene of the game.
 * This class sets up the initial dialogue and transitions to the next level.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Opening1 extends World
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
     * Constructor for objects of class Opening1.
     */
    public Opening1()
    {    
        // Create a new world with 1000x530 cells with a cell size of 1x1 pixels.
        super(1000, 530, 1);
        addObject(clemontine, 500, 265);
        addObject(textbox, 500, 400);
        dialogue = new ArrayList<String>();
        //dialogues
        dialogue.add("I've just about had it!");
        dialogue.add("How long are these zombies going to terrorize my garden?!");
        dialogue.add("First it was re-animated ravens and now it is literal human corpses!");
        dialogue.add("What is wrong with you Mire?!");
        dialogue.add("Pestering me with the undead is something I can look past on");
        dialogue.add("but annoying my plants is just too much!");
        dialogue.add("That's it, I won't stand for this harassment any longer");
        dialogue.add("If you want to get to me, then I dare you to cross over my garden first!");
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
            LevelOne world = new LevelOne();
            Greenfoot.setWorld(world);
            bgMusic.stop();
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
        bgMusic.playLoop();
    }
    
    /**
     * Called when the world is stopped. Stops background music.
     */
    public void stopped()
    {
        StartingScreen.bgMusic2.stop();
        StartingScreen.bgMusic.stop();
        bgMusic.stop();
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
