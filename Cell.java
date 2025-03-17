import greenfoot.*;

/**
 * Represents a cell in a 2D array grid, providing visualization of the grid.
 * Each cell can be occupied or unoccupied.
 * 
 * Note: Assumes the existence of an image file named "gridsquare.png" for visualization.
 * Adjust the image file and size as needed.
 * 
 * @author Sana Pardiwala
 * @version December 30, 2023
 */
public class Cell extends Actor {
    // Flag indicating whether the cell is occupied or unoccupied
    private boolean isOccupied;
    
    // Image representing the grid square
    GreenfootImage gridImage = new GreenfootImage("gridsquare.png");

    /**
     * Constructor for objects of class Cell.
     * Initializes the cell with the default grid image.
     */
    public Cell() {
        setImage(gridImage);
    }
}
