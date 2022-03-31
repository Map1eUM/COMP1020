package HugeGraphicsExample.graphicsV1;

/* A particular type of Shape that draws
  * a line connecting two endpoints.
  */
 public class Line extends Shape {
   
   //instance variables
   private Point start;
   private Point end;
   
   //constructor
   public Line(Point one, Point two) {
     start = one;
     end = two;
   }//constructor
   
   //methods
   public void draw() {
     StdDraw.line(start.x,start.y,
                  end.x,end.y);
   }//draw method
   
 }//Line class