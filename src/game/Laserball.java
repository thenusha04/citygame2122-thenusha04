package game;
import city.cs.engine.*;
import org.jbox2d.common.*;

//walker is a class which has been extended from dynamic body which has fixed orientation
  // this enables movements such as stop, jump and start
public class Laserball extends Walker implements StepListener {
    private static final Shape aShape = new PolygonShape(0.568f, -0.393f, 0.058f, -0.417f, -0.611f, 0.543f, 0.394f, 0.177f, 0.574f, -0.387f);
    //this is the co- ordinates of the laserball

    // this is the image used for the laserball
    private static final BodyImage image =
            new BodyImage("data/laserball.png", 1.5f);
    private GameLevel level;


    //this makes the laserball class public
    // it can be accessed in other classes
    public Laserball( World w) {
        super(w, aShape);
        this.level = (GameLevel)w;
        addImage(image);
        w.addStepListener(this);
        setClipped(true);
    }


//vectors of laserball
    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);

    }

    @Override
    //gets the x position of the spaceship and subtracts it from the laserball x position
    // this produces a new x position for the laserball
    public void preStep(StepEvent stepEvent) {
        float newx = level.getSpaceship().getxpos() - this.getPosition().x;
        newx = newx - 0.1f;
        this.setPosition(new Vec2(newx, this.getPosition().y));
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }}




