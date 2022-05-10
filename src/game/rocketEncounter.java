package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class rocketEncounter implements CollisionListener {

    private GameLevel currentLevel;
    private Game game;

    public rocketEncounter(GameLevel level, Game game) {
        currentLevel = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        //if Spaceship collides with star,conditions for completing the level are fulfilled
        if (e.getOtherBody() instanceof rocket) {
            if (currentLevel.isComplete())
                game.goToNextLevel();
        }
    }
}

