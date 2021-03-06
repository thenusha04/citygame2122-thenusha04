package game;

import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {
    private Spaceship spaceship;
    GameLevel currentLevel;
    Game game;

    public GameView(Game game,GameLevel w, int width, int height) {

        super(w, width, height);
        currentLevel = w;
        spaceship = w.getSpaceship();
        this.game = game;



    }


    @Override
    //gets the spaceship to the current level being played
    public void setWorld(World world) {
        super.setWorld(world);
        currentLevel = (GameLevel) world;
        this.spaceship = currentLevel.getSpaceship();

    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(currentLevel.getBackground(), 0, 0, 500, 570, this);
    }

    @Override
    //shows the points collected
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.white);
        g.drawString("Points:" + spaceship.getAlien(), 50, 35);
        g.setFont(new Font("Castellar", Font.BOLD, 15));
        //shows the lives bar
        for (int i = 0; i < spaceship.getLives(); i++) {
            try {
                g.drawImage(new ImageIcon("data/hrt.png").getImage(), (i + 1) * 30, 35,30, 35, this);
            } catch (Exception e) {
            }

        }
    }
}



