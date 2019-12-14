package Cpu;
import memory.RAM;

public class Cpu {
 
    //crear un constructor de CPU para que inicie el reloj 
    RAM RamMemory = new RAM();
    int cp;
    IRegister RI = new IRegister();
    Register R1 = new Register();
    Register R2 = new Register();    
    Register R3 = new Register();
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
    public void Cp(int cop){//tiene la direccion de memoria que le envie el secuenciador      
        cp=cop;
        RI(cp);
    }    
    public void RI (int directionRam){//ingresa los datos de la direccion de memoria al registro RI
       String Instruccion= RamMemory.getCell(directionRam).getInstruction();
       int LeftData= RamMemory.getCell(directionRam).getLefData();
       int RightData= RamMemory.getCell(directionRam).getRightData();
       //-------
       RI.setInstruction(Instruccion);
       RI.setLeftData(LeftData);
       RI.setRigtData(RightData);  
    }    
    
    public void Registros(int data, int registro){//para tulizar esta funcion se debe indicar cual resgistro llenar y el dato entero a ingresarle
        switch (registro)
        {
            case 1:
              System.out.print("Registro 1");
              R1.setData(data);
              break; 
            case 2:
              System.out.print("Registro 2");
              R2.setData(data);
              break;
            case 3://No es necesario pero es para demostrar que se pueden utilizar mas de 2
              System.out.print("Registro 3");
              R3.setData(data);
            break;
        }
    }    
    public void ALU(IRegister IR){
        switch (IR.getInstruction())
        {
            case "suma":
                System.out.print("suma");
                objAlu.sum(R1, R2);
                break;
            case "resta":
                System.out.print("resta"); 
                objAlu.rest(R1, R2);
                break;
            case "mult":
                System.out.print("multiplicacion"); 
                objAlu.multi(R1, R2);
                break;
            case "div":
                System.out.print("divicion");  
                objAlu.div(R1, R2);
                break;                
        }
    }
    private void Copiar(IRegister r){
        //Copiar: copia el contenido de R en R'. Si R = R' esta instruccion no hace nada   
        int primero = r.getLeftData();
        int segundo = r.getRigtData();
        if(primero==1){//copia el dato de R1 en R2
           int data = R1.getData();
           Registros(data, 2);
        }else{
           int data = R2.getData();
           Registros(data, 1);
        }    
    }    
    private void Saltar(Register r){ 
        //Saltar a M : Salta incondicionalmente a la direccion M de la memoria  
        int salto =  r.getData();
        Cp(salto);      
    } 
    private void SaltarSiCero(Register r){
        //saltarSiCero M : Si el indicador C=1, salta a la direccion M, si no, sigue en la secuencia 
        int salto =  r.getData();
        Cp(salto); 
    } 
    private void SaltarSiNeg(Register r){
        //SaltarSiNeg M : Si el indicador N=1, salta a la direccion M, si no, sigue en la secenciaa 
        int salto =  r.getData();
        Cp(salto); 
    } 
    private void SaltarSiPos(Register r){
        //saltarSiPos M : Si el indicador P=1, salta a la direccion M, si no, sigue en la secuencia
        int salto =  r.getData();
        Cp(salto); 
    } 
    private void Cargar(Register r){
        //Cargar  R,M: Cargar en el registro R el contenido de la celda M de la memoria
        int salto =  r.getData();
        Cp(salto); 
    }
    private void Comparar(){
        //Cargar  R,M: Cargar en el registro R el contenido de la celda M de la memoria
        if(R1.getData()==R2.getData()){
           System.out.print("iguales");  
        }
        if(R1.getData()!=R2.getData()){
           System.out.print("diferentes");  
        }
        if(R1.getData()>R2.getData()){
           System.out.print("R1 mayor que R2");  
        }
        if(R1.getData()<R2.getData()){
          System.out.print("multiplicacion");   
        }
        
    }
    
}
