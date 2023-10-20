package variables.depth;

public abstract class DepthState {
    public int depth;

    public DepthState previous;

    public int getDepth(){
        return this.depth;
    }

    public DepthState ascend(){
        return previous;
    }

    public abstract DepthState descend();

    public abstract void releaseCapsule();

}
