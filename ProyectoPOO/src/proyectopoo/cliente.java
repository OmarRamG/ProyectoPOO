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
public class cliente implements Serializable{
        private String nombre;
        private String contra;
	private ArrayList <cuenta> cuentas = new ArrayList <>();
	
	public cliente(String nom, String cont){
		nombre = nom; 
		contra = cont;
	}
	

	
	public String obtenerNombre(){	
            return nombre;
	}
	
	public String obtenerContraseña(){	
        return contra;
}
	
	public cuenta obtenerCuenta(int index){
		return cuentas.get(index);
	}
        
        public int obtenerTam(){
            return cuentas.size();
        }
	
	public void agregarCuenta(cuenta cta){
            cuentas.add(cta);
	}
}
