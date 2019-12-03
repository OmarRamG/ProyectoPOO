/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

/**
 *
 * @author Omar Ramirez
 */
public class excepciones extends Exception{
    private int codigoError;
    
    public excepciones(int codigoError){
        super();
        this.codigoError=codigoError;
    }
    
    @Override
    public String getMessage(){
        String msg = "";
        switch(codigoError){
            case 0:
                msg = "El nombre no puede tener caracteres especiales ni numeros";
                break;
            case 1:
                msg = "Debe ingresar un valor numerico para el saldo";
                break;
            case 2:
                msg = "Debe ingresar un dato en el nombre";
                break;
            case 3:
                msg = "Debe ingresar un dato en el saldo";
                break;
            case 4:
                msg = "EL interes debe ser un valor numerico";
                break;
            case 5:
                msg = "Debe ingresar un dato en el interes";
                break;
            case 6:
                msg = "EL sobregiro debe ser un valor numerico";
                break;
            case 7:
                msg = "Debe ingresar un dato en el sobregiro";
                break;
            
        }
        return msg;
    }
}
