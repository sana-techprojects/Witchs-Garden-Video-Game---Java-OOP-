import greenfoot.*;
import java.util.Random;

/**
 * The SpinnerWheel class represents an actor displaying a spinning wheel with potential outcomes.
 * 
 * @author Sana
 */
public class SpinnerWheel extends Actor {
    private boolean isSpinning = false;
    private int spinSpeed;
    private int rotation = 0;
    GreenfootImage spinner = new GreenfootImage("pngtree-spin-wheel-vector-illustration-png-image_9008007-removebg-preview.png");

    /**
     * Constructor for the SpinnerWheel class.
     * Initializes the SpinnerWheel with an image and scales it.
     */
    public SpinnerWheel() {
        spinner.scale(450, 450);
        setImage(spinner);
    }

    /**
     * The act() method is called on every act cycle.
     * If spinning, it calls the spinWheel() method.
     */
    public void act() {
        if (isSpinning) {
            spinWheel();
        }
    }

    /**
     * Initiates the spinning of the wheel.
     * Sets isSpinning to true and randomly determines the spin speed.
     */
    public void startSpinning() {
        isSpinning = true;
        spinSpeed = new Random().nextInt(20) + 5; // Adjust the speed as needed
    }

    /**
     * Rotates the wheel based on the spin speed until it completes one full rotation.
     * Stops spinning and displays the outcome once a full rotation is completed.
     */
    private void spinWheel() {
        if (rotation < 360) {
            setRotation(getRotation() + spinSpeed);
            rotation += spinSpeed;
        } else {
            stopSpinning();
            displayOutcome();
        }
    }

    /**
     * Stops the spinning by setting isSpinning to false and resetting the rotation.
     */
    private void stopSpinning() {
        isSpinning = false;
        rotation = 0;
    }

    /**
     * Displays the outcome of the spin and sets the corresponding reward.
     */
    private void displayOutcome() {
        int outcome = new Random().nextInt(4); // 0, 1, 2, or 3
        int reward = 0;
        switch (outcome) {
            case 0:
                getWorld().showText("Won Nothing...", 792, 192);
                break;
            case 1:
                getWorld().showText("Won $50!", 792, 192);
                reward = 50;
                break;
            case 2:
                getWorld().showText("Won $100!", 792, 192);
                reward = 100;
                break;
            case 3:
                getWorld().showText("Won $150!", 792, 192);
                reward = 150;
                break;
        }
        SpinWheelMiniGame sw = (SpinWheelMiniGame) getWorld();
        sw.setOutcomeAmount(reward);
    }
}
