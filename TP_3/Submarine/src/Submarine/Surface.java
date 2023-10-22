package Submarine;

public class Surface extends DepthState {
    public Surface(){
        this.depth = 0;
        this.previous = this;
    }

    @Override
    public DepthState descend() {
        return new Shallow();
    }

    @Override
    public void releaseCapsule() {
    }
}
