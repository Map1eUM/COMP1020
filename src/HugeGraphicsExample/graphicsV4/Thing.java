package HugeGraphicsExample.graphicsV4;

import java.awt.Color;

/* A collection class that will hold a list of
 * Shapes. Shapes can be added to a Thing, and
 * the whole list can be drawn.
 */
public class Thing extends Shape {
  
  //Global constant - the limit to the number of Shapes per Thing.
  private static final int MAX_PARTS = 25;
  
  //Instance variables - a simple partially-full array
  //This will not grow. Only MAX_PARTS Shapes can be handled.
  private Shape[] parts;
  private int numParts;

  //Give each Thing a size, and position
  private double size;
  private Point position;

  //Constructor
  public Thing(Point where, double howBig) {
    super(Color.BLACK, null); //Dummies
    parts = new Shape[MAX_PARTS];
    numParts = 0;
    size = howBig;
    position = where;
  }//Constructor
  
  //addShape will add a new Shape to the Thing, at the end.
  public void addShape(Shape s){
    parts[numParts++]=s;
  }//addShape

  //draw() will draw all of the Shapes in the Thing
  public void draw( ){
    for(int i=0; i<numParts; i++)
      parts[i].draw();
  }//draw method
  
  public Point scalePt(Point p){
    double x = position.x-size/2.0+p.x*size;
    double y = position.y-size/2.0+p.y*size;
    return new Point(x,y);
  }//scalePt
  
  public double scaleDist(double d){
    return d*size;
  }

  //A complete set of get/set methods for the size/position
  public Point getPosition() { return position; }
  public double getSize() { return size; }
  public void setPosition(Point p) { position = p;}
  public void setSize(double s) { size = s;}
}//class Thing