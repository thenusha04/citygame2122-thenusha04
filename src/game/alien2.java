

package game;

        import city.cs.engine.*;

        import javax.sound.sampled.LineUnavailableException;
        import javax.sound.sampled.UnsupportedAudioFileException;
        import java.io.IOException;
// this class does not move as it is a static body
public class alien2 extends StaticBody {
//co- ordinates of alien2 portal class
    private static final Shape  alien2Shape = new PolygonShape(
            -0.48f,0.408f, 0.468f,0.456f, 0.435f,-0.417f, -0.414f,-0.459f, -0.486f,0.387f
    );
// image used for alien2
    private static final BodyImage image =
            new BodyImage("data/alien2.png", 4f);

// allows other classes to access alien2
    public alien2(World w) {
        super(w,alien2Shape);
        addImage(image);

    }
//destroys alien2 class
    @Override
    public void destroy(){
        super.destroy();
    }

}