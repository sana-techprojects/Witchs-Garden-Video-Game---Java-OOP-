import greenfoot.*;

/**
 * The class keeps track of the money gained through clicking the falling suns in the game.
 * 
 * Author: Sana Pardiwala
 * Version: January 1, 2024
 */
public class SunCollector extends Actor {
    private int money = 150; // Initial money

    GreenfootImage sunCounter = new GreenfootImage("suncounter.png");

    /**
     * Constructor for the SunCollector class.
     * Sets the initial image.
     */
    public SunCollector() {
        setImage(sunCounter);
    }

    /**
     * Get the current money amount.
     * 
     * @return int - The current money amount.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Add money to the current amount and update the image.
     * 
     * @param amount The amount of money to add.
     */
    public void addMoney(int amount) {
        money += amount;
        updateImage();
    }

    /**
     * Spend money if there is enough, and update the image.
     * 
     * @param amount The amount of money to spend.
     */
    public void spendMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            updateImage();
        }
    }

    /**
     * Update the image to display the current money amount with a larger font size.
     */
    private void updateImage() {
        GreenfootImage updatedImage = new GreenfootImage(sunCounter);
        updatedImage.setFont(new Font("Arial", true, false, 15)); // Adjust the font size as needed
        updatedImage.drawString("Money: $" + money, 10, 60);
        setImage(updatedImage);
    }
}
