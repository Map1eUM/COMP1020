package HugeGraphicsExample.graphicsV2;

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
   public Rectangle(Point ll, Point ur, Color c) {
     super(c);
     lowerLeft= ll;
     upperRight= ur;
   }//constructor
   
   //methods
   public void draw() {
     super.draw();
     //StdDraw uses a centre point, and a half-width
     //and half-height, so conversion is needed.
     StdDraw.filledRectangle((lowerLeft.x+upperRight.x)/2,
                       (lowerLeft.y+upperRight.y)/2,
                       (upperRight.x-lowerLeft.x)/2,
                       (upperRight.y-lowerLeft.y)/2);
   }//draw method
   
 }//Rectangle class
