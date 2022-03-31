package HugeGraphicsExample.graphicsV3;

/**
 * This is a red circle inside a blue "plus sign".
 */
public class PlusSign extends Thing {
  
  public PlusSign(Point where, double howBig) {
    super(where,howBig);
    double dotRadius = 0.2; //The dot in the centre of the "plus"
    //These spots make the rectangles meet exactly at the edge of the dot
    double low = 0.5*(1.0-dotRadius*Math.sqrt(2.0));
    double hi = 0.5*(1.0+dotRadius*Math.sqrt(2.0));
    //The four poins that define the two rectangles
    Point vertBottom = new Point(low,0);
    Point vertTop = new Point(hi,1);
    Point horizBottom = new Point(0,low);
    Point horizTop = new Point(1,hi);
    //It's all in the exact centr of the image.
    Point centre = new Point(0.5,0.5);
    addShape(new Rectangle(vertBottom,vertTop, StdDraw.BLUE,this));
    addShape(new Rectangle(horizBottom,horizTop, StdDraw.BLUE,this));
    addShape(new Circle(centre,dotRadius, StdDraw.MAGENTA,this));
  }
  
}
