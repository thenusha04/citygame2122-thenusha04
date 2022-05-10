
package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class rocket extends StaticBody {

    private static final Shape  rocketShape = new PolygonShape(
            -0.48f,0.408f, 0.468f,0.456f, 0.435f,-0.417f, -0.414f,-0.459f, -0.486f,0.387f
    );

    private static final BodyImage image =
            new BodyImage("data/rocket.png", 2f);


    public rocket(World w) {
        super(w,rocketShape);
        addImage(image);
        //setAlwaysOutline((true));
    }
}