package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.logging.Level;

public abstract class GameLevel extends World {
    private Spaceship spaceship;


    public GameLevel(Game game) {
        super();

        // make the character
        spaceship = new Spaceship(this);

// generates a new alien pickup when collides
        AlienPickup pickup = new AlienPickup(getSpaceship());
        getSpaceship().addCollisionListener(pickup);

// generates a new coin pickup when collides
        CoinsPickup pickup1 = new CoinsPickup(getSpaceship());
        getSpaceship().addCollisionListener(pickup1);
//
        AsteroidEncounter asteroidEncounter = new AsteroidEncounter(spaceship);
        spaceship.addCollisionListener(asteroidEncounter);

        LaserballEncounter laserballEncounter = new LaserballEncounter(spaceship);
        spaceship.addCollisionListener(laserballEncounter);
        alien2encounter a2e = new alien2encounter(this, game);
        spaceship.addCollisionListener(a2e);
    }

    //new accessor for the spaceship field
    public Spaceship getSpaceship() {
        return spaceship;
    }
    //getter

    public abstract void stopMusic();

    public abstract boolean isComplete();

    public abstract Image getBackground();

    public abstract SoundClip getGameMusic();

    public abstract String getName();
    public void populate(){}
}