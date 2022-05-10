package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public  class Spaceshipshooting implements MouseListener {
    private Spaceship spaceship;
    private GameView view;

    private static SoundClip shootingSound;

    public Spaceshipshooting(Spaceship s, GameView g) {
        spaceship = s;
        view = g;






    }

    static {
        try {
            shootingSound = new SoundClip("data/lasergun.wav");
            // System.out.println("L");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent Event){
        Vec2 worldPoint = view.viewToWorld(Event.getPoint());
        spaceship.shoot(worldPoint);
        System.out.println("shoot");
        shootingSound.play();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
