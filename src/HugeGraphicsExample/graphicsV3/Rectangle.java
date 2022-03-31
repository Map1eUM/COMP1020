package HugeGraphicsExample.graphicsV3;

import java.awt.Color;

/* A particular type of Shape that draws
  * a rectangle given two anchor points
  * at the lower left and upper right corners.
  */
 public class Rectangle extends Shape {
   
   //instance variables
   private Point lowerLeft;
   private Point upperRight;
   
   //constructor
   public Rectangle(Point ll, Point ur, Color c, Thing t) {
     super(c,t);
     lowerLeft= ll;
     upperRight= ur;
   }//constructor
   
   //methods
   public void draw() {
     super.draw();
     Point newLL = parent.scalePt(lowerLeft);
     Point newUR = parent.scalePt(upperRight);
     //StdDraw uses a centre point, and a half-width
     //and half-height, so conversion is needed.
     StdDraw.filledRectangle((newLL.x+newUR.x)/2,
                       (newLL.y+newUR.y)/2,
                       (newUR.x-newLL.x)/2,
                       (newUR.y-newLL.y)/2);
   }//draw method
   
 }//Rectangle class
