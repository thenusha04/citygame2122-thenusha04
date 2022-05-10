package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 * this class is used to save and load my game
 * @author thenusha sugeetharan
 * @version 1.3
 */
public class GameSaverLoader {

    /**
     * this method saves my game
     * @param fileName : this file is used to save
     * @param level : the level where it is saved
     * @throws IOException when the string is not used
     */
    public static void save(String fileName, GameLevel level)
            throws IOException {

        boolean append = false;
        FileWriter writer = null;
        //this ensures that the final block gets run after the try block without looking at the control blocks state

        try {
            writer = new FileWriter(fileName, append);
       // it states the level the spaceship is at once it is saved
            writer.write(level.getName() + "\n");


            for (int i = 0; i < level.getDynamicBodies().size(); i++) {
                DynamicBody b = level.getDynamicBodies().get(i);

                if (b instanceof Spaceship) {
                    writer.write("Spaceship," + b.getPosition().x + "," + b.getPosition().y + "," + ((Spaceship) b).getLives() + "," + ((Spaceship) b).getAlien() + "\n");
                } else if (b instanceof Laserball) {
                    writer.write("Laserball," + b.getPosition().x + "," + b.getPosition().y + "\n");

                } /*else if (b instanceof alien) {
                    writer.write("alien," + b.getPosition().x + "'" + b.getPosition().y + "\n");

                } */else if(b instanceof Asteroid){
                    writer.write("Asteroid," + b.getPosition().x + "'" + b.getPosition().y + "\n");
                }
            }
            for (int i = 0; i < level.getStaticBodies().size(); i++) {
                StaticBody b = level.getStaticBodies().get(i);

                if (b instanceof coins) {
                    writer.write("coins," + b.getPosition().x + "'" + b.getPosition().y + "\n");
                }
                else if (b instanceof alien2 ){
                    writer.write("alien2," + b.getPosition().x + "'" + b.getPosition().y + "\n");

                }


            }

        } finally {
            if (writer != null) {
                writer.close();
            }

        }
    }

    /**
     *
     * @param fileName : this file is used to load
     * @param game : the game that is loaded
     * @return a game level that is used to  with bodies at the position they were saved at
     * @throws IOException when the string is not used
     */

    public static GameLevel load(String fileName, Game game) throws IOException{

        FileReader fr = null;
        BufferedReader reader = null;

        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            //sets the level to null
            GameLevel level = null;

            if (line.equals("Level1")) {// if a save was made in level 1 then it will open from level 1
                level = new Level1(game);
            } else if (line.equals("Level2")) {//if a save was made in level 2 then it will open from level 2
                level = new Level2(game);

            } else if (line.equals("Level3")) {// if a save was made in level 3 then it will open from level 3
                level = new Level3(game);
            } else if (line.equals("Level4")) {// if a save was made in level 4 then it will open from level 4
            level = new Level4(game);
        }

            line = reader.readLine();

            while (line != null) {
                //used to break up lines in save.txt
                String[] tokens = line.split("'");

                if (tokens[0].equals("alien")) {
                    alien alien = new alien(level);
                    alien.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));

                } else if (tokens[0].equals("Asteroid")) {
                    Asteroid asteroid = new Asteroid(level);
                    asteroid.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("Spaceship")) {
                    Spaceship Spaceship = new Spaceship(level);
                    Spaceship.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    Spaceship.setLives(Integer.parseInt(tokens[3]));
                    Spaceship.setAlien(Integer.parseInt(tokens[4]));

                }
                line = reader.readLine();
            }

            return game.getCurrentLevel();




        }finally {
            if (reader !=null){
                reader.close();
            }
            if (fr !=null){
                fr.close();
            }
        }
    }
}