/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Omar Ramirez
 */
public class banco implements Serializable{
    private ArrayList <cliente> listaCliente = new ArrayList <>();
    
    public void agregarCliente(cliente c){
        listaCliente.add(c);
    }
    
    public void eliminarCliente(String n){
        for(int i = 0; i<listaCliente.size(); i++){
            if(listaCliente.get(i).obtenerNombre().equals(n)){
                listaCliente.remove(i);
            }
        }
    }
    
    public int obtenerTam(){
        return listaCliente.size();
    }
    
    public cliente obtenerCliente(int i){
        return listaCliente.get(i);
    }
    
    public cliente obtenerCliente(String  n){
        int x=0;
        for(int i =0; i<listaCliente.size(); i++){
            if(listaCliente.get(i).obtenerNombre().equals(n))
                x = i;
        }
        return listaCliente.get(x);
    }
    
    public static banco obtenerDatos(){
        banco B = new banco();
        try{
            FileInputStream fis = new FileInputStream("Datos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            B = (banco) ois.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return B;
    }
    
    
    public static void guardarDatos(banco b){
        try{
            FileOutputStream fs = new FileOutputStream("Datos.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(b);
            os.close();

        }
       catch(Exception e){
             e.printStackTrace();
       }
    }
}
