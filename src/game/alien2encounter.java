


package game;

        import city.cs.engine.CollisionEvent;
        import city.cs.engine.CollisionListener;

public class alien2encounter implements CollisionListener {
// initialises game level to the current level
     GameLevel currentLevel;
     Game game;

// adds alien2 the current level of the game
    public alien2encounter(GameLevel level, Game game) {
        currentLevel = level;
        this.game = game;
    }

    @Override

    public void collide(CollisionEvent e) {
        //if spaceship collides with portal,conditions for completing the level are fulfilled it goes to the next level
        if (e.getOtherBody() instanceof alien2) {
            if (currentLevel.isComplete())
                game.goToNextLevel();
           e.getOtherBody().destroy();
        }
    }
}