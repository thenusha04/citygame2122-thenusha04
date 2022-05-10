package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Struct;

public class Level1 extends GameLevel {
    Image background;
    SoundClip gameMusic;

    public Level1(Game game) {
        super(game);
        background = new ImageIcon("data/background.gif").getImage();
        // make the character
        getSpaceship().setPosition(new Vec2(-9.5f, -3.5f));
        //spaceship.setGravityScale(0);
        getSpaceship().addCollisionListener(new AlienPickup(getSpaceship()));

        try {
            gameMusic = new SoundClip("data/space.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }


        Shape platformShape = new PolygonShape(1.7f, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-9.5f, -5.5f));
        platform.addImage(new BodyImage("data/planet.png", 3));


        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-6f, -3.5f));
        platform1.addImage(new BodyImage("data/planet.png", 3));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-2f, -1.5f));
        platform2.addImage(new BodyImage("data/planet.png", 3));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(2f, -1.5f));
        platform3.addImage(new BodyImage("data/planet.png", 3));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(6f, -3.5f));
        platform4.addImage(new BodyImage("data/planet.png", 3));

        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(9.5f, -5.5f));
        platform5.addImage(new BodyImage("data/planet.png", 3));


        //**move** here the rest of the code from Gave.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)
        // make the character
        Asteroid asteroid = new Asteroid(this);
        asteroid.setPosition(new Vec2(getSpaceship().getxpos(), 7));
        asteroid.setGravityScale(0.1f);

        Asteroid asteroid1 = new Asteroid(this);
        asteroid1.setPosition(new Vec2(getSpaceship().getxpos() + 3, 7));
        asteroid1.setGravityScale(0.1f);

        Asteroid asteroid2 = new Asteroid(this);
        asteroid2.setPosition(new Vec2(getSpaceship().getxpos() + 7, 8));
        asteroid2.setGravityScale(0.1f);

        Asteroid asteroid3 = new Asteroid(this);
        asteroid3.setPosition(new Vec2(15, 7));
        asteroid3.setGravityScale(0.1f);


        Asteroid asteroid4 = new Asteroid(this);
        asteroid4.setPosition(new Vec2(2, 6));
        asteroid4.setGravityScale(0.1f);

        alien alien5 = new alien(this);
        alien5.setPosition(new Vec2(10, -2));
        //alien.setGravityScale(0);

        alien alien1 = new alien(this);
        alien1.setPosition(new Vec2(-10, -1));
        //alien2.setGravityScale(0);

        alien alien2 = new alien(this);
        alien2.setPosition(new Vec2(-5, 1));
        //  alien3.setGravityScale(0);

        alien alien4 = new alien(this);
        alien4.setPosition(new Vec2(6, 1));
        // alien4.setGravityScale(0);

        alien alien3 = new alien(this);
        alien3.setPosition(new Vec2(1, 2));

        alien2 alien21 = new alien2(this);
        alien21.setPosition(new Vec2(10, 1));
    }

    public void stopMusic() {
        gameMusic.stop();
    }

    @Override
    public SoundClip getGameMusic() {
        return gameMusic;
    }

    @Override
    public boolean isComplete() {
        System.out.println(getSpaceship().getAlien());
        if (getSpaceship().getAlien() >= 5)
            return true;
        else
            return false;


    }

    @Override
    public Image getBackground() {
        return background;}

   @Override
    public String getName(){
        return "Level1";
      }



}
