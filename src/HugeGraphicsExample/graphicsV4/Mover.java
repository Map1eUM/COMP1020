package HugeGraphicsExample.graphicsV4;

/**
 * An animation causing motion to occur
 */
public class Mover extends Animation {
  
  protected double xVelocity; //x change per tick. + is right
  protected double yVelocity; //y change per tick. + is up
  
  public Mover(double h, double v, Thing t) { 
    super(t);
    xVelocity = h;
    yVelocity = v;
  }
  
  public void tick(){
    Point p = parent.getPosition();
    p.x += xVelocity;
    p.y += yVelocity;    
  }
  
}
