package HugeGraphicsExample.graphicsV3;

import java.awt.Color;

/* Test the Point, Thing, and various Shape subclasses.
 * Note that the Shape type is never directly used.
 */
public class TestPattern {
  public static void main(String[] args) { 
    Thing[] things = new Thing[8];
    int numThings = 0;
    
    things[numThings++] = new Hamburger(new Point(0.3,0.7),0.2);
    things[numThings++] = new Sunburst(new Point(0.2,0.3),0.1);
    things[numThings++] = new Face(new Point(0.5,0.9),0.1);
    things[numThings++] = new Hamburger(new Point(0.6,0.2),0.1);
    things[numThings++] = new Face(new Point(0.5,0.5),0.35);
    things[numThings++] = new PlusSign(new Point(0.7,0.3),0.15);
    things[numThings++] = new Sunburst(new Point(0.8,0.1),0.15);
    things[numThings++] = new PlusSign(new Point(0.9,0.7),0.05);
    
    for(int i=0; i<numThings; i++)
      things[i].draw();
  }//main
}//TestPattern
