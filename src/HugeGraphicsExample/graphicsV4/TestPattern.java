package HugeGraphicsExample.graphicsV4;

import java.awt.Color;

/* Make a lot of random objects with random
 * animations, and do them all at once.
 */
public class TestPattern {
  
  public static void main(String[] args) {
    final int NUM_THINGS = 8;
    Thing[] things = new Thing[NUM_THINGS];
    Animation[] actions = new Animation[2*NUM_THINGS]; //Allow 2 each
    int numActions = 0;
    
    for(int i=0; i<NUM_THINGS; i++){
      things[i] = randomThing();
      actions[numActions++] = randomMotion(things[i]);
      if(Math.random()<0.5) //Make about half of them pulse
        actions[numActions++] = randomPulse(things[i]);
    }
    
    while(true){ //Animation loop
      StdDraw.clear(); //Start with a clear screen
      
      for(int i=0; i<numActions; i++)
        actions[i].tick(); 
      
      for(int i=0; i<NUM_THINGS; i++)
        things[i].draw(); 
      
      StdDraw.show(30); //Show the result, delay 30 msec.
    }//while
  }//main
  
  private static Thing randomThing(){
    int i = (int)(Math.random()*4);
    switch(i){
      case 0: return new Face(randomPoint(),randomSize());
      case 1: return new Hamburger(randomPoint(),randomSize());
      case 2: return new Sunburst(randomPoint(),randomSize());
      case 3: return new PlusSign(randomPoint(),randomSize());
    }
    return null; //For a neurotic compiler
  }//randomThing
  
  private static Animation randomMotion(Thing t){
    int i = (int)(Math.random()*3);
    switch(i){
      case 0: return new Bouncer(randomVelocity(),randomVelocity(),t);
      case 1: return new Reflecter(randomVelocity(),randomVelocity(),t);
      case 2: return new Wrapper(randomVelocity(),randomVelocity(),t);
    }
    return null; //For a neurotic compiler
  }//randomMotion

  private static Animation randomPulse(Thing t){
    return new Pulser(10+(int)(Math.random()*50),
                      1.0+1.75*Math.random(),t);
  }//randomPulse

  private static Point randomPoint(){
    return new Point(Math.random(), Math.random());
  }//randomPoint
  
  private static double randomSize(){
    final double MIN_SIZE = 0.05;
    final double MAX_SIZE = 0.18;
    return MIN_SIZE+Math.random()*(MAX_SIZE-MIN_SIZE);
  }//randomSize
  
  private static double randomVelocity(){
    final double MIN_V = -0.020;
    final double MAX_V = 0.020;
    return MIN_V+Math.random()*(MAX_V-MIN_V);
  }//randomVelocity
  
}//TestPattern
