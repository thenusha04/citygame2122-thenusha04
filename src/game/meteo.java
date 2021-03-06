
package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
//co ordinates of polygon class
public class meteo extends StaticBody {
    private static final Shape  meteoShape = new PolygonShape(
            -0.48f,0.408f, 0.468f,0.456f, 0.435f,-0.417f, -0.414f,-0.459f, -0.486f,0.387f
    );
//image of platform class
    private static final BodyImage image =
            new BodyImage("data/meteo.png", 2f);
// makes the class public

    public meteo(World w) {
        super(w,meteoShape);
        addImage(image);
        //setAlwaysOutline((true));
    }
}