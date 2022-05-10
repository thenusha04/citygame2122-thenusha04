package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AlienPickup implements CollisionListener {
// calls private spaceship class
    private Spaceship spaceship;
// spaceship picks up aliens
    public AlienPickup(Spaceship s) {
        spaceship = s;
    }



    @Override
    // when the spaceship collides with alien the points increase by 1 and destroys the alien
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof alien){

            spaceship.setAlien(spaceship.getAlien()+1);
            collisionEvent.getOtherBody().destroy();
        }
    }
}