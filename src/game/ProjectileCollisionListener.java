package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProjectileCollisionListener implements CollisionListener {

    @Override
    public void collide(CollisionEvent e){

        if (e.getOtherBody() instanceof Asteroid){
            e.getOtherBody().destroy();
        }
        e.getReportingBody ().destroy();
        System.out.println("Great job!");
        if (e.getOtherBody() instanceof Laserball){
            e.getOtherBody().destroy();
        }
        e.getReportingBody ().destroy();
        //System.out.println("Great job!");
    }




}
