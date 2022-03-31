package HugeGraphicsExample.graphicsV4;

/**
 * The superclass for all Animations.
 * An Animation will always be attached to
 * a Thing (its "parent"). It will do something
 * to the properties of that Thing (size/position)
 * once per "clock tick", when tick() is called.
 */
public abstract class Animation {
  
  protected Thing parent; //subclasses need the parent
  
  public Animation(Thing t) { 
    parent = t;
  }
  
  //dummy method allowing polymorphism to occur
  public void tick(){ }
}
