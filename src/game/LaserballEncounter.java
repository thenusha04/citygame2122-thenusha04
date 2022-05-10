package game;


import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LaserballEncounter implements CollisionListener {
    private Spaceship spaceship;

    public LaserballEncounter ( Spaceship s) {spaceship= s;}

    /*private static SoundClip asteroidSound;

    static {
        try {
            asteroidSound = new SoundClip("data/lasergun.wav");
            //System.out.println("asteroid attacked ");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        }*/
    @Override
    public  void collide (CollisionEvent collisionEvent){
        if(collisionEvent.getOtherBody()instanceof Laserball)
            spaceship.setLives(spaceship.getLives()-1);
        //asteroidSound.play();
        if (spaceship.getLives()<1){
            collisionEvent.getReportingBody().destroy();
        }
    }




}

