package memory;

public class Cell {
    private static final int WORD_SIZE = 32;
    String instruction;
    int rightData;
    int leftData;


    public Cell(){
        this.instruction="DATA";
        this.rightData=0;
        this.leftData=0;
    }

    public int getLefData() {
        return leftData;
    }

    public int getRightData() {
        return rightData;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setLefData(int lefData) {
        this.leftData = lefData;
    }

    public void setRightData(int rightData) {
        this.rightData = rightData;
    }

    public void free() {
        this.instruction="DATA";
        this.rightData=0;
        this.leftData=0;
    }
}
