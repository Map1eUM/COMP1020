package HugeGraphicsExample.graphicsV2;

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
   public Line(Point one, Point two, Color c, double r) {
     super(c);
     start = one;
     end = two;
     radius = r;
   }//constructor
   
   //methods
   public void draw() {
     super.draw();
     StdDraw.setPenRadius(radius);
     StdDraw.line(start.x,start.y,
                  end.x,end.y);
   }//draw method
   
 }//Line class