package variables.depth.states;
import variables.depth.DepthState;

public class Surface extends DepthState {
    @Override
    public DepthState descend() {
        return new Shallow();
    }

    @Override
    public void ascend(){

    }
}
