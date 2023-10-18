package variables.depth;

public abstract class DepthState {
    public int value;

    public DepthState previous;

    public int getDepth(){
        return this.value;
    }

    public abstract DepthState descend();

    public abstract DepthState ascend();

    public abstract void releaseCapsule();

}
