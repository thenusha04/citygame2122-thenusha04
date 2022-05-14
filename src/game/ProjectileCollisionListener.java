package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProjectileCollisionListener implements CollisionListener {

    @Override

    public void collide(CollisionEvent e){
        //when the projectile collides with the asteroid it is destroyed
        if (e.getOtherBody() instanceof Asteroid){
            e.getOtherBody().destroy();
        }
        //when the projectile collides with the laserball it is destroyed
        e.getReportingBody ().destroy();
        System.out.println("Great job!");
        if (e.getOtherBody() instanceof Laserball){
            e.getOtherBody().destroy();
        }
        e.getReportingBody ().destroy();

    }




}
