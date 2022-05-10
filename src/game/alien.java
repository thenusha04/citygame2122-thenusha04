
package game;
        import city.cs.engine.*;
        import org.jbox2d.common.*;

        import javax.sound.sampled.LineUnavailableException;
        import javax.sound.sampled.UnsupportedAudioFileException;
        import java.io.IOException;
// co- ordinates of alien
// static body it does not move
public class alien extends StaticBody {
    private static final Shape aShape = new PolygonShape(-0.373f,0.724f, 0.537f,0.655f, 0.676f,-0.247f, 0.243f,-0.715f, -0.269f,-0.689f, -0.676f,-0.056f, -0.468f,0.637f);

    // image used for alien
    private static final BodyImage image =
            new BodyImage("data/alien.png", 1f);

// sound added for alien collison
    private static SoundClip alienSound;
    static {
        try {
            alienSound = new SoundClip("data/alien.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }


 // allows alien to be accessible in other classes
    public alien(World world) {
        super(world, aShape);
        addImage(image);
    }
@Override
// when the spaceship collides with alien the alien is destroyed and alien sound is played
     public void destroy (){
        super.destroy();
        alienSound.play();
}

}




