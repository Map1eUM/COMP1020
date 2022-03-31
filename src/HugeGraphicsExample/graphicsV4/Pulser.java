package HugeGraphicsExample.graphicsV4;

/**
 * This will alter the size of a Thing,
 * making it "pulse".
 */
public class Pulser extends Animation {
    
  int period; //For how many ticks does it expand (and contract)
  boolean expanding; //Is it expanding right now?
  int count; //This will change 0-->period-->0 repeatedly
  double maxExpansion; //The maximum size expansion.
                       //If 2.0 it will double in size, then shrink back.
  double factorPerTick; //The amount the size will be multiplied or divided
                        //by each tick, to get the above maximum over the
                        //requested period.
  
  public Pulser(int nTicks, double maxGrowth, Thing t) {
    super(t);
    period = nTicks;
    maxExpansion = maxGrowth;
    factorPerTick = Math.pow(maxExpansion,1.0/period);
    expanding = true;
    count = 0;
  }//Constructor
  
  public void tick(){
    double s = parent.getSize();
    if(expanding){
      s *= factorPerTick;
      expanding = ++count != period;
    }//expanding
    else {
      s /= factorPerTick;
      expanding = --count == 0;
    }//contracting 
    parent.setSize(s); 
  }
  
}
