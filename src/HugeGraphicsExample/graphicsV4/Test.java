package HugeGraphicsExample.graphicsV4;

/**
 * Test Things and their animations
 */
public class Test {
  
  public static void main(String[] args) { 
    Thing burger1 = new Hamburger(new Point(0.2,0.8),0.1);
    Animation a1 = new Wrapper(0.01,-0.0025,burger1);
    Thing burger2 = new Hamburger(new Point(0.8,0.8),0.1);
    Animation a2 = new Bouncer(-0.01,-0.0025,burger2);
    Animation a3 = new Pulser(20,5.0,burger2);
    while(true){ //Animation loop
      StdDraw.clear(); //Start with a clear screen
      a1.tick(); //Apply the animation
      burger1.draw(); //Draw the object
      a2.tick(); //Apply the animation
      a3.tick();
      burger2.draw(); //Draw the object
      StdDraw.show(30); //Show the result, delay 30 msec.
    }//while
  }//main
  
}//Test class
