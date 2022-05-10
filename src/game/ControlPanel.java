package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    public JPanel mainPanel;
    private JButton settingsButton;
    private JButton nextLevelButton;
    private JButton quitButton;
    private JButton loadButton;
    private JButton saveButton;

    public ControlPanel(Game game){

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entered Game Control");
                game.transitionToSettings();
            }
        });
        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game saved");
               try {
              GameSaverLoader.save("data/save.txt", game.currentLevel);
            }catch (IOException ee){
                ee.printStackTrace();

            }}
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    GameLevel loadedLevel = GameSaverLoader.load("data/save.txt", game);
                    game.setLevel(loadedLevel);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                System.out.println("Game loaded");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {System.exit(0);

            }
        });
    }
}
