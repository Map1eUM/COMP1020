package HugeGraphicsExample.graphicsV3;

import java.awt.Color;

/* An abstract class that will allow generic
 * shapes to be stored in a Shape variable or array.
 * You cannot create an actual Shape object.
 */
public abstract class Shape {
  
  private Color c; //A shape will have a colour
  protected Thing parent; //And will be part of a specific Thing

  //A constructor that sets the colour
  public Shape(Color initC, Thing t) {
    c = initC;
    parent = t;
  }//constructor

  //We know we want to draw shapes
  public void draw(){
    StdDraw.setPenColor(c);
  }//draw
  
}//class Shape
