import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends Actor
{
    //Label mainLabel = new Label("", 35);
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Textbox()
    {
        //setImage("images/Text Box.png");
        //setText("I've just about had it!!");
    }
    
    public void act()
    {
        // Add your action code here.
        //setImage("images/Text Box.png");
    }
    
    public void addedToWorld(World world)
    {
        //world.addObject(mainLabel, 500, 400);
    }
    
    public void setText(String text)
    {
        //mainLabel.setValue(text);
    }
}
