
package Cpu;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import memory.Cell;
import memory.RAM;

public class Cpu {
    //En esta parte va el UC
    RAM RamMemory = new RAM();
    int cp;
    IRegister RI = new IRegister();
    Register R1 = new Register();
    Register R2 = new Register();
    ALU objAlu = new ALU();
    private void llenarRam(){//funcion provisional para llenar a mano una celda de la memoria ram
        
       RamMemory.getCell(0).setInstruction("Dato"); 
       RamMemory.getCell(0).setLefData(4);
       RamMemory.getCell(0).setRightData(0);
    }
    public void setCp(int cop){//Devuelve la posicion de memoria en donde encuentre la primer instruccion de ordenes de programa
        cp=cop;
    }    
    public void Registros (int directionRam, int registro){//El Uc  desde el secuenciador y por el bus de control debe enviarle datos cada registro por el bus de datos
        //el int registro define en que registro escribir (0=RI, 1=R1, 2=R2)
       String Instruccion= RamMemory.getCell(directionRam).getInstruction();
       int LeftData= RamMemory.getCell(directionRam).getLefData();
       int RightData= RamMemory.getCell(directionRam).getRightData();
       if(registro==0){
        RI.setInstruction(Instruccion);
        RI.setLeftData(LeftData);
        RI.setRigtData(RightData);
       }else{if(registro==1){
                R1.setData(LeftData);
            }else{
                R2.setData(LeftData);
            }           
       }              
    }    
    public void ALU(String instruction){
        if(instruction.equals("SUMA")){
            objAlu.sum(R1.getData(), R2.getData());
        }else{
            if(instruction.equals("RESTA")){
                objAlu.rest(R1.getData(), R2.getData());
            }else{
                 if(instruction.equals("MULT")){
                      objAlu.multi(R1.getData(), R2.getData());
                 }else{
                      if(instruction.equals("DIV")){
                          objAlu.div(R1.getData(), R2.getData());
                      }else{
                
                      } 
                 } 
            } 
        }
    }
    
    
    
}
