package variables.depth.states;

import variables.depth.DepthState;

public class Deep extends DepthState {

    public static final String cannotReleaseCapsuleFromDeepState = "Cannot release capsule from deep state";

    public Deep(int value, DepthState previous){
        this.depth = value;
        this.previous = previous;
    }

    @Override
    public DepthState descend() {
        return new Deep(this.depth - 1, this);
    }

    @Override
    public void releaseCapsule() {
        throw new RuntimeException(cannotReleaseCapsuleFromDeepState);
    }


}
