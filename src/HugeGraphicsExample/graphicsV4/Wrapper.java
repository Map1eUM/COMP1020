package HugeGraphicsExample.graphicsV4;

/**
 * A Mover that "wraps around" when it reaches edges
 */
public class Wrapper extends Mover {
  
  public Wrapper(double h, double v, Thing t) { 
    super(h,v,t);
  }
  
  public void tick(){
    super.tick();
    Point p = parent.getPosition();
    //Make it wrap around from one side of the window to the other
    if(p.x<=0.0) p.x += 1.0;
    if(p.x>=1.0) p.x -= 1.0;
    if(p.y<=0.0) p.y += 1.0;
    if(p.y>=1.0) p.y -= 1.0;   
  }//tick
  
}
