package HugeGraphicsExample.graphicsV4;

import java.awt.Color;

/**
 * A "sunburst" with N concentric circles with
 * red in the middle, orange on the outside, and
 * gradually changeing in the middle.
 */
public class Sunburst extends Thing {
  
  private static final int NUM_CIRCLES = 12;
  
  public Sunburst(Point where, double howBig) {
    super(where,howBig);
    Point centre = new Point(0.5,0.5); //Put it in the exact centre
    for(int n=NUM_CIRCLES; n>=1; n--){
      double fraction=(double)n/NUM_CIRCLES;
      addShape(new Circle(centre,fraction*0.5,
                          new Color(255,(int)(192*fraction),0),this));
    }//for
  }
  
}
