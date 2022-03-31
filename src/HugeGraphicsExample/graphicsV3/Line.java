package HugeGraphicsExample.graphicsV3;

import java.awt.Color;

/* A particular type of Shape that draws
  * a line connecting two endpoints.
  */
 public class Line extends Shape {
   
   //instance variables
   private Point start;
   private Point end;
   private double radius;
   
   //constructor
   public Line(Point one, Point two, Color c, double r, Thing t) {
     super(c,t);
     start = one;
     end = two;
     radius = r;
   }//constructor
   
   //methods
   public void draw() {
     super.draw();
     Point newStart = parent.scalePt(start);
     Point newEnd = parent.scalePt(end);
     double newRadius = parent.scaleDist(radius);
     StdDraw.setPenRadius(newRadius);
     StdDraw.line(newStart.x,newStart.y,
                  newEnd.x,newEnd.y);
   }//draw method
   
 }//Line class