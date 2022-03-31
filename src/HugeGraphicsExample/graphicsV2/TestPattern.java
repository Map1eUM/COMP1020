package HugeGraphicsExample.graphicsV2;

import java.awt.Color;

/* Test the Point, Thing, and various Shape subclasses.
 * Note that the Shape type is never directly used.
 */
public class TestPattern {
  public static void main(String[] args) { 
    Point lowLeft = new Point(0.25,0.25);
    Point topRight = new Point(0.75,0.75);
    Thing test = new Thing();
    test.addShape(new Rectangle(lowLeft,topRight,Color.GREEN));
    test.addShape(new Line(lowLeft,topRight,Color.RED,0.05));
    test.addShape(new Circle(lowLeft,0.1,Color.BLUE));
    test.addShape(new Circle(topRight,0.1,Color.MAGENTA));
    test.draw();
  }//main
}//TestPattern
