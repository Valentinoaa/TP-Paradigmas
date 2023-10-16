package variables.depth.states;
import variables.depth.DepthState;

public class Surface extends DepthState {
    public Surface(){
        this.value = 0;
    }

    @Override
    public DepthState descend() {
        return new Shallow();
    }

    @Override
    public DepthState ascend(){
        return this;
    }

    @Override
    public void releaseCapsule() {
        capsule.release();
    }
}
