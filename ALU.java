package Cpu;

public class ALU {

    boolean c; // "if the result is 0" register
    boolean p; //"if result is major tha 0 " register
    boolean n; //"if result is minor than 0" register
    int result;

    public ALU() {
        this.c=false;
    } 
    
    public void sum(Register reg1, Register reg2){
        result=reg1.getData()+reg2.getData();
        reg1.setData(result);
        compareResult(result);
    }
    public void rest(Register reg1, Register reg2){
        result=reg1.getData()-reg2.getData();
        reg1.setData(result);
        compareResult(result);

    }
    public void multi(Register reg1, Register reg2){
        result=reg1.getData()*reg2.getData();
        reg1.setData(result);
        compareResult(result);

    }
    public void div(Register reg1, Register reg2){
        if (reg2.getData()==0)result=0;
        else result=reg1.getData()/reg2.getData();
        reg1.setData(result);
        compareResult(result);
    }

    public void comparar(Register reg1,Register reg2){
        rest(reg1,reg1);
    }
    private void compareResult(int result){
        this.c = (result == 0);
        this.p = (result > 0);
        this.n = (result<0);
    }
    public boolean getC() {
        return c;
    }
    public boolean getP() {
        return p;
    }
    public boolean isN() {
        return n;
    }
}
