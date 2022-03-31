package HugeGraphicsExample.graphicsV4;

/**
 * A form of Reflecter that adds some gravity to make
 * it "bounce" off the bottom of the window.
 */
public class Bouncer extends Reflecter {
    
  //The "force of gravity". The yVelocity will change by this amount per tick.
  private static final double GRAVITY = -0.001;
    
  public Bouncer(double h, double v, Thing t) { super(h,v,t); }
  
  public void tick(){    
    yVelocity += GRAVITY;
    super.tick();
  }
  
}
