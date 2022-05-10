package game;
import city.cs.engine.*;
import org.jbox2d.common.*;
public class Laserball extends Walker implements StepListener {
    private static final Shape aShape = new PolygonShape(0.568f, -0.393f, 0.058f, -0.417f, -0.611f, 0.543f, 0.394f, 0.177f, 0.574f, -0.387f);

    private static final BodyImage image =
            new BodyImage("data/laserball.png", 1.5f);
    private GameLevel level;

    public Laserball( World w) {
        super(w, aShape);
        this.level = (GameLevel)w;
        addImage(image);
        w.addStepListener(this);
        setClipped(true);
    }



    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        float newx = level.getSpaceship().getxpos() - this.getPosition().x;
        newx = newx - 0.1f;
        this.setPosition(new Vec2(newx, this.getPosition().y));
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }}




