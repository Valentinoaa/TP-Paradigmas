package variables.depth;

import variables.depth.states.Shallow;

public abstract class DepthState {
    public int value;
    public int getDepth(){
        return this.value;
    }
    public abstract DepthState descend();
    public abstract void ascend();



}
