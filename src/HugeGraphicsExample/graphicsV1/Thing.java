package HugeGraphicsExample.graphicsV1;

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
  
  //Constructor
  public Thing() {
    parts = new Shape[MAX_PARTS];
    numParts = 0;
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
  
}//class Thing