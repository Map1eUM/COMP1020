package HugeGraphicsExample.graphicsV1;

/* Test the Point, Thing, and various Shape subclasses.
 * Note that the Shape type is never directly used.
 */
public class TestPattern {
  public static void main(String[] args) { 
    Point lowLeft = new Point(0.25,0.25);
    Point topRight = new Point(0.75,0.75);
    Thing test = new Thing();
    test.addShape(new Rectangle(lowLeft,topRight));
    test.addShape(new Line(lowLeft,topRight));
    test.addShape(new Circle(lowLeft,0.1));
    test.addShape(new Circle(topRight,0.1));
    test.draw();
  }//main
}//TestPattern
