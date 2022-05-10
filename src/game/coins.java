
package game;
import city.cs.engine.*;
import org.jbox2d.common.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
// co- ordinates of coins
// static body it does not move
public class coins extends StaticBody {
    private static final Shape aShape = new PolygonShape( -0.776f,0.404f, -0.404f,0.74f, 0.769f,0.458f, 0.468f,-0.695f, -0.785f,-0.401f);

    // image used for coin
    private static final BodyImage image =
            new BodyImage("data/coin.png", 1f);

    // sound added for coin collison
    private static SoundClip alienSound;
    static {
        try {
            alienSound = new SoundClip("data/alien.wav");
            // System.out.println("L");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }


    // allows coin to be accessible in other classes
    public coins(World world) {
        super(world, aShape);
        addImage(image);
    }

    // when the spaceship collides with the coin the coin is destroyed and alien sound is played
    @Override
    public void destroy (){
        super.destroy();
        alienSound.play();
    }

}