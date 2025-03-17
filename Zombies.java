import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The class that contains the code shared by all the zombies in the game.
 * 
 * @author Harithan Raveendran, Vincent Wu
 * @version Dec 30 2023
 */
public abstract class Zombies extends SmoothMover
{
    protected static final int DEAD_DURATION = 3000;
    protected double speed, speedValue;
    protected int health, decayActs;
    protected int damage;
    protected boolean attacking, dead, currDecreased, dTimeSet, slowed, faster;
    protected SimpleTimer attTimer;
    protected Plants p;
    protected SimpleTimer decayTimer;
    protected ArrayList<Shooter> s;
    private boolean isPushedByToxicFog = false;

    public Zombies(){
        dead = false;
        currDecreased = false;
        dTimeSet = false;
        slowed = false;
        faster = false;
        decayTimer = new SimpleTimer();
        decayActs = 180;
    }

    public void act()
    {
        if (getWorld() != null) {
            move(speed * -1);
            checkToxicFogCollision();
            handleToxicFogEffect();
            getsDamaged();
        }
        if(health <= 0) {
            dead = true;
        }
        if(dead){
            dies();
            shooterStop();
            int ms = decayTimer.millisElapsed();
            if(ms >= DEAD_DURATION){
                getWorld().removeObject(this);
            }
        }
    }

    private void checkToxicFogCollision() {
        if (isTouching(ToxicFog.class)) {
            isPushedByToxicFog = true;
        }
    }

    private void handleToxicFogEffect() {
        if (isPushedByToxicFog) {
            setLocation(getX() + 2, getY()); // Adjust the value as needed
        }
    }

    public abstract void attack();

    public void getsDamaged() {
        Projectile projectile = (Projectile) getOneIntersectingObject(Projectile.class);
        if(!dead){
            if(projectile != null) {
                health -= Greenfoot.getRandomNumber(3) + 1;
                World world = getWorld();
                world.removeObject(projectile);
                if(projectile.getType() == 2){
                    moveSlower();
                }
            }
        }
    }
    
    public void shooterStop(){
        s = (ArrayList<Shooter>)getWorld().getObjects(Shooter.class);
        for(Shooter sh : s){
            if(sh.getY() == getY()){
                sh.setShooting(false);
            }
            else if(sh.getY() >= getY() - 30 && sh.getY() <= getY() + 30){
                sh.setShooting(false);
            }
        }
    }

    public void decreaseH(){
        health--;
    }

    public void dies() {
        setRotation(90);
        speedValue = 0;
        if(!dTimeSet){
            decayTimer.mark();
            dTimeSet = true;
        }
    }

    public boolean getDead(){
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public boolean getCurrDecreased(){
        return currDecreased;
    }

    public void setCurrDecreased(boolean currDecreased){
        this.currDecreased = currDecreased;
    }

    public void moveFaster(){
        if(!faster){
            speedValue += 0.25;
            faster = true;
        }
    }

    public void moveSlower(){
        if(!slowed){
            speedValue = speedValue/2;
            slowed = true;
        }
    }
    
    public int getHealth(){
        return health;
    }
}
