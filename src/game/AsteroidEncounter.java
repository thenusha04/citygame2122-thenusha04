package game;


import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class AsteroidEncounter implements CollisionListener {
    private Spaceship spaceship;

    public AsteroidEncounter ( Spaceship s) {spaceship= s;}

  // when the spaceship has been collided by the asteroid the lives decrease by one
    //and the spaceship is destroyed
    @Override
    public  void collide (CollisionEvent collisionEvent){
        if(collisionEvent.getOtherBody()instanceof Asteroid)
            spaceship.setLives(spaceship.getLives()-1);
        if (spaceship.getLives()<1){
            collisionEvent.getReportingBody().destroy();
        }
    }




}

