import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class representing plants in the game.
 * Provides common functionalities and attributes for all plant types.
 * 
 * 
 * 
 * @Vincent
 * @version (A version number or a date)
 */
public abstract class Plants extends Actor
{
    // Size of each grid cell
    protected static final int CELL_SIZE = 80;

    // Health of the plant
    protected int health;

    // Coordinates of the mouse
    protected int mouseX, mouseY;

    // Cost of the plant
    protected int cost;

    // Flag indicating whether the plant is placed on the grid
    protected boolean placed;

    /**
     * Constructor for objects of class Plants.
     * Initializes the placed flag to false.
     * 
     * @return void
     */
    public Plants() {
        placed = false;
    }

    /**
     * Act method for the Plants class.
     * Handles plant movement, removal if health is zero or out of bounds.
     * 
     * @return void
     */
    public void act()
    {
        move();
        if (health <= 0 || outOfBounds()) {
            getWorld().removeObject(this);
        }
    }

    /**
     * Handles the movement of the plant.
     * If the plant is not placed, it follows the mouse position.
     * If placed, it checks for out-of-bounds and proper placement on the grid.
     * 
     * @return void
     */
    public void move() {
        if (/*Greenfoot.mouseDragged(this) &&*/ !placed) {
            if (Greenfoot.getMouseInfo() != null) {
                mouseX = Greenfoot.getMouseInfo().getX();
                mouseY = Greenfoot.getMouseInfo().getY();
            }

            // Calculate the nearest grid cell
            setLocation(mouseX, mouseY);
            //
        }
        Plants plant = (Plants) getOneIntersectingObject(Plants.class);
        if (Greenfoot.mousePressed(this) && getX() > 210 && getX() < 900 && getY() < 430 && getY() > 100) {
            int mouseX = Greenfoot.getMouseInfo().getX();
            int mouseY = Greenfoot.getMouseInfo().getY();

            int nearestX = (mouseX + CELL_SIZE - CELL_SIZE / 5) / CELL_SIZE * CELL_SIZE;
            int nearestY = (mouseY + CELL_SIZE / 2) / CELL_SIZE * CELL_SIZE;

            // Set the location to the center of the nearest grid cell
            if (plant == null) {
                placed = true;
                // Set the location to the center of the nearest grid cell
                setLocation(((nearestX + CELL_SIZE / 2) - 60), (nearestY + CELL_SIZE / 2) - 20);
            }
        }
    }

    /**
     * Checks if the plant is out of bounds and refunds the player if it is.
     * 
     * @return boolean Returns true if the plant is out of bounds, false otherwise.
     */
    public boolean outOfBounds() {
        if (Greenfoot.mousePressed(this) && (getX() < 210 || getX() > 900 || getY() > 430 || getY() < 100)) {
            SunCollector sunCollector = (SunCollector) getWorld().getObjects(SunCollector.class).get(0);
            sunCollector.spendMoney(cost * -1);
            return true;
        }
        return false;
    }

    /**
     * Decreases the health of the plant by the specified amount.
     * 
     * @param dAmount Amount of health the plant will lose.
     * @return void
     */
    public void decreaseH(int dAmount) {
        health -= dAmount;
    }

    /**
     * Gets the placed status of the plant.
     * 
     * @return boolean Returns true if the plant is placed, false otherwise.
     */
    public boolean isPlaced() {
        return placed;
    }
}
