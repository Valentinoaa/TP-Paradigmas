package variables.depth.states;

import variables.depth.DepthState;

public class Shallow extends DepthState {
    int value = -1;

    @Override
    public DepthState descend() {
        return null;
    }

    @Override
    public DepthState ascend() {
        return new Surface();
    }

    @Override
    public void releaseCapsule() {
        capsule.release();
    }


}
