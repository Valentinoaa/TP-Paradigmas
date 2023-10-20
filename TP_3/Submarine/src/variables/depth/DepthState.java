package variables.depth;

public abstract class DepthState {
    public int depth;

    public DepthState previous;

    public int getDepth(){
        return this.depth;
    }

    public abstract DepthState descend();

    public abstract DepthState ascend();

    public abstract void releaseCapsule();

}
