/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.Serializable;

/**
 *
 * @author Omar Ramirez
 */
public class cuentaDeAhorros extends cuenta implements Serializable{
        private  double tasaDeInteres;
	
	public cuentaDeAhorros(double saldoIni, double tasaInteres){
		super(saldoIni);
		tasaDeInteres = tasaInteres;  
	}
        
        @Override
	public double consultar(){
            return (super.consultar() + (super.consultar() * tasaDeInteres));
	}    
}
