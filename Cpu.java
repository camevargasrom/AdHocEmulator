package Cpu;
import memory.RAM;

public class Cpu {
 
    //crear un constructor de CPU para que inicie el reloj 
    RAM RamMemory = new RAM();
    int cp;
    IRegister RI = new IRegister();
    Register R1 = new Register();
    Register R2 = new Register();
    ALU objAlu = new ALU();

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------UC-----------------------------------------------------------------------------------------------------------------------------    
    private void reloj(){
        //construir el reloj en Hrz
        //Contador 555 jajajajajaja
    }
    public void decodificator(){
        //interpreta cada vez que llega una instruccion, determina que hacer, necesita leer los datos de la memoria directamente
        //Tiene un bus de 64 bits
        //Lee la memoria y encuentra el primer registro se conecta con el secueniador
        for(int i=0; i<=64000;i++){
            if(RamMemory.getCell(i).getInstruction().equals("DATO")){
               //si es dato
            }else{
                //si no es dato 
                if(RamMemory.getCell(i).getInstruction().equals("COPIAR")){
                    
                }
            }
        }
    }
    public void secuenciador(){
        //se encarga de dar las ordenes a los otros elementos, para que las ordenes se ejecuten 
        //Tiene un bus de 3 bits
        //Retorna una direccion para la memoria 
        //recordar el 0 y el 1 para enviarlos al UP como registro en el que se va a trabajar el dato
        
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------UP--------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void setCp(int cop){//Devuelve la posicion de memoria en donde encuentre la primer instruccion de ordenes de programa
        //debe tener 10 bits, indica en que celda de la memoria se encuentra la siguiente instruccion 
        //esta direccion se envia y de ahi salen los datos para el IR
        //se debe decodificar el contenido de la IR para dar ordenes a la memoria o a la ALU 
        //esto es en la unidad de control
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
            objAlu.sum(R1, R2);
        }else{
            if(instruction.equals("RESTA")){
                objAlu.rest(R1, R2);
            }else{
                 if(instruction.equals("MULT")){
                      objAlu.multi(R1, R2);
                 }else{
                      if(instruction.equals("DIV")){
                          objAlu.div(R1, R2);
                      }
                      }
                }
            }        
    }
    private void Copiar(Register r){
//Copiar: copia el contenido de R en R'. Si R = R' esta instruccion no hace nada   
    }    
    private void Saltar(Register r){ 
//Saltar a M : Salta incondicionalmente a la direccion M de la memoria  
    } 
    private void SaltarSiCero(Register r){
//saltarSiCero M : Si el indicador C=1, salta a la direccion M, si no, sigue en la secuencia 
    } 
    private void SaltarSiNeg(Register r){
//SaltarSiNeg M : Si el indicador N=1, salta a la direccion M, si no, sigue en la secenciaa  
    } 
    private void SaltarSiPos(Register r){
//saltarSiPos M : Si el indicador P=1, salta a la direccion M, si no, sigue en la secuencia
    } 
    private void Cargar(Register r){
//Cargar  R,M: Cargar en el registro R el contenido de la celda M de la memoria  
    }
    
}
