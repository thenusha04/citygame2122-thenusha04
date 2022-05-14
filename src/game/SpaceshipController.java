package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.List;
import org.jbox2d.common.*;

import java.awt.event.*;

public class SpaceshipController implements KeyListener {
    private static final float WALKING_SPEED = 4;
    private Spaceship spaceship;
    private Game game;



    public SpaceshipController(Spaceship spaceship,Game game) {
        this.spaceship = spaceship;
        this.game=game;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            spaceship.startWalking(-WALKING_SPEED);
            //when left arrow is clicked spaceship moves one space to the left
            spaceship.setxpos(spaceship.getxpos() - 1);
        } else if (code == KeyEvent.VK_RIGHT) {
            //when right arrow is clicked spaceship moves one space to the right
            spaceship.startWalking(WALKING_SPEED);
            spaceship.setxpos(spaceship.getxpos() + 1);

        } else if (code == KeyEvent.VK_UP) {
            spaceship.jump(8);
            //when esc is pressed produces the menu
        } else if (code == KeyEvent.VK_ESCAPE) {
            game.toggleMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            //when left arrow is not being pressed spaceship stops walking
            spaceship.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            //when right arrow is not being pressed spaceship stops walking
            spaceship.stopWalking();
        }

    }

    @Override
    public void keyTyped(KeyEvent e){
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }
}