package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel {
    public JPanel mainPanel;
    private JButton backButton;
    private JButton volumeUpButton;
    private JButton volumeDownButton;
    private JButton newGameButton;
    private Game game;
    private GameLevel currentLevel;

    public SettingsPanel(Game game,GameLevel level){
        this.game =game;
        currentLevel= level;

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entered Game Settings");
                game.transitionToMain();
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                new Game();
            }
        });
        volumeDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Voulme Down");
                game.decreaseVolume();


            }
        });
        volumeUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Voulme Up");
                game.increaseVolume();
            }
        });
    }
}
