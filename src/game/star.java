

package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class star extends StaticBody {
// static can not move
// co ordinates of star class
    private static final Shape  starShape = new PolygonShape(
            -1.249f,-0.14f, -0.675f,0.728f, 1.005f,-0.076f, 0.474f,-0.664f, -0.589f,-0.384f

    );
    //image of star class

    private static final BodyImage image =
            new BodyImage("data/star.png", 4f);

// makes the class public
    public star(World w) {
        super(w,starShape);
        addImage(image);

    }

    @Override
    public void destroy(){
        super.destroy();
    }

}
