
package game;

        import city.cs.engine.*;
        import city.cs.engine.Shape;
        import org.jbox2d.common.Vec2;

        import javax.sound.sampled.LineUnavailableException;
        import javax.sound.sampled.UnsupportedAudioFileException;
        import javax.swing.*;
        import java.awt.*;
        import java.io.IOException;

public class Level2 extends GameLevel {
    Image background;
    private SoundClip gameMusic;
    public Level2(Game game) {
        super(game);
        background = new ImageIcon("data/level2bg.gif").getImage();
        // make the character
        getSpaceship().setPosition(new Vec2(-9.5f, -3.5f));
        //spaceship.setGravityScale(0);
        getSpaceship().addCollisionListener(new AlienPickup(getSpaceship()));

        try {
          gameMusic = new SoundClip("data/bgs2.wav");   // Open an audio input stream
           gameMusic.loop();                              // Set it to continous playback (looping)
       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
          System.out.println(e);
        }



        Shape platformShape = new PolygonShape(-1.172f,0.121f, -0.362f,0.595f, 0.469f,0.643f, 1.215f,0.175f, 1.199f,-0.236f, 0.559f,-0.63f, -0.373f,-0.619f, -1.012f,-0.305f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-9.5f, -5.5f));
        platform.addImage(new BodyImage("data/clouds.png", 2));

//location of platforms and image used
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-6f, -3.5f));
        platform1.addImage(new BodyImage("data/clouds.png", 2));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-3f, -1.5f));
        platform2.addImage(new BodyImage("data/clouds.png", 2));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(1f, -0.5f));
        platform3.addImage(new BodyImage("data/clouds.png", 2));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(5f, 1f));
        platform4.addImage(new BodyImage("data/clouds.png", 2));

        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(9f, 1.5f));
        platform5.addImage(new BodyImage("data/clouds.png", 2));


        //**move** here the rest of the code from Gave.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)
        // make the character
        //location of asteroids starting point and gravity used
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

        coins coins = new coins(this);
        coins.setPosition(new Vec2(11, 3));
        //alien.setGravityScale(0);

        alien alien2 = new alien(this);
        alien2.setPosition(new Vec2(-5, -1));


        alien alien3 = new alien(this);
        alien3.setPosition(new Vec2(-10, -1));


        alien alien4 = new alien(this);
        alien4.setPosition(new Vec2(6, 3));


        alien alien5 = new alien(this);
        alien5.setPosition(new Vec2(1, 3));

        alien alien = new alien(this);
        alien.setPosition(new Vec2(10, 3));

      //location of coins
        coins coins2 = new coins(this);
        coins2.setPosition(new Vec2(5, 3));
        //alien2.setGravityScale(0);

        coins coins3 = new coins(this);
        coins3.setPosition(new Vec2(-2, 3));
        //  alien3.setGravityScale(0);

        coins coins4 = new coins(this);
        coins4.setPosition(new Vec2(-7, 0));


        coins coins5 = new coins(this);
        coins5.setPosition(new Vec2(2, 4));


        alien2 alien21 = new alien2(this);
        alien21.setPosition(new Vec2(10, 5));
    }

    public void  stopMusic() { gameMusic.stop(); }
    @Override
    public boolean isComplete() {
        // for the level to be complete the spaceship must collect five aliens and coins
        if (getSpaceship().getAlien()>=5 && getSpaceship().getCoins()>=5)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackground() {
        return background;
    }




    @Override
    public SoundClip getGameMusic() {
        return gameMusic;
    }

    @Override
    public String getName(){
        return "Level 2";
    }

}
