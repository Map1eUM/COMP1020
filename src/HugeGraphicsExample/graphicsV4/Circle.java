package HugeGraphicsExample.graphicsV4;

import java.awt.Color;

/* A particular type of Shape that draws
  * a circle with a given centre and radius.
  */
public class Circle extends Shape {
   //instance variables
   private Point centre;
   private double radius;
   
   //constructor
   public Circle(Point p, double r, Color c, Thing t) {
     super(c,t);
     centre = p;
     radius = r;
   }//constructor
   
   //methods
   public void draw() {
     super.draw();
     Point newCentre = parent.scalePt(centre);
     double newRadius = parent.scaleDist(radius);
     StdDraw.filledCircle(newCentre.x, newCentre.y, newRadius);
   }//draw method
   
 }//Circle class
