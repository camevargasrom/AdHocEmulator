package Cpu;
public class IRegister {
    public String Instruction;
    public int leftData;
    public int rigtData;

    public IRegister() {
    }

    public IRegister(String Instruction, int leftData, int rigtData) {
        this.Instruction = Instruction;
        this.leftData = leftData;
        this.rigtData = rigtData;
    }

    public String getInstruction() {
        return Instruction;
    }

    public void setInstruction(String Instruction) {
        this.Instruction = Instruction;
    }

    public int getLeftData() {
        return leftData;
    }

    public void setLeftData(int leftData) {
        this.leftData = leftData;
    }

    public int getRigtData() {
        return rigtData;
    }

    public void setRigtData(int rigtData) {
        this.rigtData = rigtData;
    }

    
  
    
    
}
