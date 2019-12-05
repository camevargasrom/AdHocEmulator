
package Cpu;
public class MicroInstructionRegistrer {
    private String label;
    private String instruction;
    private int leftData;
    private int rightData;

    public MicroInstructionRegistrer() {
    }

    public MicroInstructionRegistrer(String label, String instruction, int leftData, int rightData) {
        this.label = label;
        this.instruction = instruction;
        this.leftData = leftData;
        this.rightData = rightData;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getLeftData() {
        return leftData;
    }

    public void setLeftData(int leftData) {
        this.leftData = leftData;
    }

    public int getRightData() {
        return rightData;
    }

    public void setRightData(int rightData) {
        this.rightData = rightData;
    }
    
}
