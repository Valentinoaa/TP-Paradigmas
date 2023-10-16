package variables.depth;

public class Depth {
    public int value = 0;
    public int getDepth(){
        return this.value;
    }
    public void descend(){
        this.value -= 1;
    }
    public void ascend(){
        this.value += 1;
    }



}
