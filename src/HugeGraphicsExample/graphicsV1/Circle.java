package HugeGraphicsExample.graphicsV1;

/* A particular type of Shape that draws
  * a circle with a given centre and radius.
  */
public class Circle extends Shape {
   //instance variables
   private Point centre;
   private double radius;
   
   //constructor
   public Circle(Point p, double r) {
     centre = p;
     radius = r;
   }//constructor
   
   //methods
   public void draw() {
     StdDraw.circle(centre.x, centre.y, radius);
   }//draw method
   
 }//Circle class
