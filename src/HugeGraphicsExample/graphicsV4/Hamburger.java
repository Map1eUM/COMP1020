package HugeGraphicsExample.graphicsV4;

import java.awt.Color;

/**
 * This is a "Hamburger"-shaped Thing
 */
public class Hamburger extends Thing {
  
  public Hamburger(Point where, double howBig) {
    super(where,howBig);
    Point topBunCtr = new Point(0.5,0.6);    //Centre of the circle for the top
    Point bottomBunCtr = new Point(0.5,0.4); //Centre of the circle for the bottom
    Point left = new Point(0.1,0.5);         //Left end of the "meat patty"
    Point right = new Point(0.9,0.5);        //Right end
    addShape(new Circle(topBunCtr,0.4, StdDraw.ORANGE,this));
    addShape(new Circle(bottomBunCtr,0.4, StdDraw.ORANGE,this));
    addShape(new Line(left,right,new Color(60,40,20),0.2,this));
  }

  
}
