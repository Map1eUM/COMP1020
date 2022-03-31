package HugeGraphicsExample.graphicsV3;

/**
 * This is a "Happy Face" Thing.
 */
public class Face extends Thing {
  
  public Face(Point where, double howBig) {
    super(where,howBig);
    Point centre = new Point(0.5,0.5);   //Centre of the face
    Point leftEye = new Point(0.3,0.7);  //Centre of the left eye
    Point rightEye = new Point(0.7,0.7); //And the right eye
    Point mouth1 = new Point(0.28,0.45); //The four points that are
    Point mouth2 = new Point(0.38,0.30); //  joined to make
    Point mouth3 = new Point(0.62,0.30); //  a mouth shape
    Point mouth4 = new Point(0.72,0.45);
    addShape(new Circle(centre,0.5, StdDraw.YELLOW,this));
    addShape(new Circle(leftEye,0.05, StdDraw.BLACK,this));
    addShape(new Circle(rightEye,0.05, StdDraw.BLACK,this));
    addShape(new Line(mouth1,mouth2, StdDraw.BLACK,0.05,this));
    addShape(new Line(mouth2,mouth3, StdDraw.BLACK,0.05,this));
    addShape(new Line(mouth3,mouth4, StdDraw.BLACK,0.05,this));
  }//constructor
  
}
