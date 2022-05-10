package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class CoinsPickup implements CollisionListener {
    // calls private spaceship class
    private Spaceship spaceship;
    // spaceship picks up coins
    public CoinsPickup(Spaceship s) {
        spaceship = s;
    }



    @Override
    // when the spaceship collides with coins the points increase by 1 and destroys the coins
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof coins){

            spaceship.setCoins(spaceship.getCoins()+1);
            collisionEvent.getOtherBody().destroy();
        }
    }
}
