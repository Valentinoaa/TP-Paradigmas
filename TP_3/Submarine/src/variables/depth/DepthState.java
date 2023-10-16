package variables.depth;

import variables.capsule.Capsule;
import variables.depth.states.Shallow;

public abstract class DepthState {
    public int value;
    public Capsule capsule = new Capsule();

    public DepthState previous;

    public int getDepth(){
        return this.value;
    }

    public abstract DepthState descend();

    public abstract DepthState ascend();

    public abstract void releaseCapsule();

}
