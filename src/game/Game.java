package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 * @author Thenusha Sugeetharan
 * @version Milestone 3
 */
public class Game {
    GameLevel currentLevel;
    GameView view;
    SpaceshipController controller;
    public ControlPanel controlPanel;
    public SettingsPanel settingsPanel;
    private JFrame frame;
    private boolean gameOver;
    private boolean menuVisible;


    public Game() { //Names the text file Game.java

        //1. make an empty game world
        //intialises and declares variables

        gameOver = false;
        menuVisible = false;
        currentLevel = new Level1(this);
    // sets the current level to 1 so the game starts from level 1

        //2. populate it with bodies (ex: platforms, collectibles, characters)


        //3. make a view to look into the game world
        // UserView view = new UserView(world, 500, 500);
        view = new GameView(this,currentLevel, 500, 500);
        view.addMouseListener(new Spaceshipshooting(currentLevel.getSpaceship(), view));
        view.addMouseListener(new GiveFocus(view));
        controller = new SpaceshipController(currentLevel.getSpaceship(),this);
        view.addKeyListener(controller);
        //other fields omitted

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        frame = new JFrame("City Game");
        frame.add(view);

        controlPanel = new ControlPanel(this);
        settingsPanel = new SettingsPanel(this, currentLevel);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(currentLevel, 445, 250);

        // view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));
        // start our game world simulation!
        currentLevel.start();
    }
    /**
    *the level is set to the level the load was saved on in the save.txt file
     * @param level: the level to load
     */

    // sets my game to the current level and renews it to the level 1
    //stops the music  from the current level and sets world for next level and calls controller so controllers will work
 public void setLevel(GameLevel level){
        currentLevel.stopMusic();
        currentLevel.stop();
        currentLevel =level;
        view.setWorld(currentLevel);
        controller.setSpaceship(currentLevel.getSpaceship());
        currentLevel.start();
 }

    /**
     * moves the spaceship from level to level when the level is complete
     */
    //public static void main (String[]args){
    public void goToNextLevel() {
        if (currentLevel instanceof Level1) {
            currentLevel.stopMusic();
            currentLevel.stop();

            Spaceship prevSpaceship = currentLevel.getSpaceship();
            currentLevel = new Level2(this);
            Spaceship newSpaceship = currentLevel.getSpaceship();

      //resets the coins and aliens collected by the spaceship
            newSpaceship.setAlien(prevSpaceship.getAlien());
            newSpaceship.setCoins(prevSpaceship.getCoins());
            view.setWorld(currentLevel);
            controller.setSpaceship(currentLevel.getSpaceship());
            currentLevel.start();
            view.addMouseListener(new Spaceshipshooting(currentLevel.getSpaceship(), view));
        } else if (currentLevel instanceof Level2) {
            currentLevel.stop();
            currentLevel.stopMusic();
       //resets the number of lives for level 3
            Spaceship prevSpaceship = currentLevel.getSpaceship();
            currentLevel = new Level3(this);
            Spaceship newSpaceship = currentLevel.getSpaceship();
            newSpaceship.setAlien(prevSpaceship.getLives());

        //makes the controller and mouse shooting available for spaceship
            view.setWorld(currentLevel);
            controller.setSpaceship(currentLevel.getSpaceship());
            currentLevel.start();
            view.addMouseListener(new Spaceshipshooting(currentLevel.getSpaceship(), view));

       // stops level3 and the music for level 3
        } else if (currentLevel instanceof Level3) {
            currentLevel.stop();
            currentLevel.stopMusic();

            Spaceship prevSpaceship = currentLevel.getSpaceship();
            currentLevel = new Level4(this);
            Spaceship newSpaceship = currentLevel.getSpaceship();
            newSpaceship.setAlien(prevSpaceship.getLives());


            view.setWorld(currentLevel);
            controller.setSpaceship(currentLevel.getSpaceship());
            currentLevel.start();
            view.addMouseListener(new Spaceshipshooting(currentLevel.getSpaceship(), view));

        } else if (currentLevel instanceof Level4) {
            System.out.println("Game complete");
            System.exit(0);
        }


    }


    public static void main(String[] args) {
        new Game();
    }

    public boolean isGameOver() {
        return gameOver;

    }

    /**
     * this method sets the game over screen when the levels are complete
     * @param over
     */
    public void setGameOver(boolean over){
        this.gameOver = over;
        currentLevel.stop();
        view.repaint();
        frame.pack();
}

    /**
     * hides the  menu
     */

    public void toggleMenu () {
        //hide menu
        if (menuVisible) {
            frame.remove(controlPanel.mainPanel);
            menuVisible = false;
            frame.pack();
            currentLevel.start();
        } else {
            System.out.println("showing menu");
            frame.add(controlPanel.mainPanel, BorderLayout.SOUTH);
            menuVisible = true;
            frame.pack();
            currentLevel.stop();
            frame.repaint();
        }
    }

    /**
     * this displays the settings panel once the main menu disappears
     */
    public void transitionToMain () {
        frame.remove(settingsPanel.mainPanel);
        frame.pack();
        frame.add(controlPanel.mainPanel, BorderLayout.SOUTH);
        frame.pack();


     }

    public void transitionToSettings() {
        frame.remove(controlPanel.mainPanel);
        frame.pack();
        frame.add(settingsPanel.mainPanel, BorderLayout.SOUTH);
        frame.pack();


    }

    /**
     * this method allows you to increase the sound of your game
     */
    //enables sound to be increased for levels 1 to 4
        public void increaseVolume(){
        if(currentLevel instanceof Level1)currentLevel.getGameMusic().setVolume(1);
        else if (currentLevel instanceof Level2)currentLevel.getGameMusic().setVolume(1);
         else if (currentLevel instanceof Level3)currentLevel.getGameMusic().setVolume(1);
          else if (currentLevel instanceof Level4)currentLevel.getGameMusic().setVolume(1);

    }
    /**
     * this method allows you to decrease the sound of your game
     */
    //enables sound to be decreased for levels 1 to 4
    public void decreaseVolume(){
    if(currentLevel instanceof Level1)currentLevel.getGameMusic().setVolume(0.2);
        else if (currentLevel instanceof Level2)currentLevel.getGameMusic().setVolume(0.2);
         else if (currentLevel instanceof Level3)currentLevel.getGameMusic().setVolume(0.2);
          else if (currentLevel instanceof Level4)currentLevel.getGameMusic().setVolume(0.2);
    }
//presents the current level of the game
 public GameLevel getCurrentLevel() {
    return currentLevel;
}
}