package memory;

public class RAM {
    private static final int  MEMORY_SIZE = 64000;
    private  Cell[] memory;
    public  RAM(){
        memory =new Cell[MEMORY_SIZE];
    }

    public RAM(int memorySize){
        memory = new  Cell[memorySize];
    }
    public Cell getCell(int adress){
        return memory[adress];
    }
    public void setCell(int adress,Cell cell){
        memory[adress]=cell;
    }
    public void isFree(int adress){
        memory[adress].free();
    }
    public boolean freeMemory(){
        for (int i =0; i<MEMORY_SIZE;i++){
            memory[i].free();
        }
        return true;
    }

}
