package HugeGraphicsExample.graphicsV4;

/**
 * A type of motion that reflects off all four walls.
 */
public class Reflecter extends Mover {
  
  public Reflecter(double h, double v, Thing t) { 
    super(h,v,t);
  }
  
  public void tick(){
    super.tick();
    Point p = parent.getPosition();
    //Make it bounce off the four sides of the window
    if(p.x<0.0) { p.x = -p.x; xVelocity = -xVelocity; }
    if(p.x>1.0) { p.x = 2.0-p.x; xVelocity = -xVelocity; }
    if(p.y<0.0) { p.y = -p.y; yVelocity = -yVelocity; }
    if(p.y>1.0) { p.y = 2.0-p.y; yVelocity = -yVelocity; }
  }//tick
  
}//Reflecter
