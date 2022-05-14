package game;


import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.List;
import org.jbox2d.common.*;

/**
 * the class which generates spaceships
 * @author Thenusha Sugeetharan
 * @version 1.2
 */

//walker is a class which has been extended from dynamic body which has fixed orientation
    // this enables movements such as stop, jump and start

public class Spaceship extends Walker {
    private static final Shape SpaceshipShape = new PolygonShape(
            -1.588f, -0.102f, -0.68f, 0.758f, 0.763f, 0.751f, 1.532f, -0.178f, 1.512f, -0.553f, -1.498f, -0.518f, -1.616f, -0.178f);
    static int xpos;
    private int alien;
    private int coins;
    private String directions;
    private int lives= 3;



    private static final BodyImage image =
            new BodyImage("data/spaceship.png", 2.5f);

    //this method allows the spaceship to be called by any classes

    public Spaceship(World world) {
        super(world, SpaceshipShape);
        addImage(image);
        setAlwaysOutline(false);
        xpos = 0;
        alien = 0;
    }

    //the getter and setter class allows the alien class to be acessible to any class as it is private

    /**
     * this getter method enables aliens to be accessed outside of spaceship
     * @return the amount of aliens collected
     */
    public int getAlien() {
        return alien;
    }

    /**
     * this setter method enables other classes such as game view to present the aliens
     * @param alien: the aliens that need to be loaded
     */

    public void setAlien(int alien) {
        this.alien = alien;
        System.out.println("Points:" + alien);
    }


    //getter and setter for the x position of the spaceship


    /**
     * this getter method enables coins to be accessed outside of spaceship
     * @return the amount of coins collected
     */

     public int getCoins() {
     return alien;
     }
     /**
     * this setter method enables other classes such as game view to present the coins
     * @param alien: the coins that need to be loaded
     */
    public void setCoins(int alien) {
        this.alien = alien;
        System.out.println("Points:" + alien);
    }


    //getter and setter for the x position of the spaceship
    /**
     * this getter method enables the x positions of the spaceship to be accessed
     * @return the x position of the spaceship
     */

    public int getxpos() {
        return xpos;
    }

    /**
     * this setter method initialises the x position of the spaceship to 0
     * @param xpos: the x position of the spaceship which is 0
     */
    public void setxpos(int xpos) {
        this.xpos = xpos;
    };


    /**
     * this method gets the amount of lives the spaceship has
     * @return spaceship lives
     */

    public int getLives () {
        return lives;
    }

    /**
     * sets the number of lives the spaceship has at the beginning of each level
     * @param lives: the lives to load
     */
    public  void  setLives (int lives) {
        this.lives =lives;
        System.out.println("lives:" +lives);
    }


    /**
     * this method allows the spaceship to shoot projectiles
     * @param target
     */
//this allows the user to point with their mouse in any direction and when they release the projectile shoots in that direction.
    public void shoot(Vec2 target) {
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        projectile.addCollisionListener(new ProjectileCollisionListener());
        Vec2 dir = target.sub(this.getPosition());
        dir.normalize();
     projectile.setPosition(this.getPosition().add(dir.mul(2f)));
     projectile.setLinearVelocity(dir.mul(30));
        }
    }



