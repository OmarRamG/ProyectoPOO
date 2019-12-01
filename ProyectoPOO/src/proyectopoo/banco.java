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
    
    public void agrgarCliente(cliente c){
        listaCliente.add(c);
    }
    
    public void eliminarCliente(String n){
        for(int i = 0; i<listaCliente.size(); i++){
            if(listaCliente.get(i).obtenerNombre().equals(n)){
                listaCliente.remove(i);
            }
        }
    }
}
