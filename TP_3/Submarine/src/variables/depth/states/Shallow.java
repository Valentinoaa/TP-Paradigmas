package variables.depth.states;

import variables.depth.DepthState;

public class Shallow extends DepthState {

    public Shallow(){
        this.depth = -1;
        this.previous = new Surface();
    }

    @Override
    public DepthState descend() {
        return new Deep(this.depth - 1, this);
    }


    @Override
    public void releaseCapsule() {
    }


}
