/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

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
}
