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
public class cuenta implements Serializable{
        protected double saldo;
	
	public cuenta(double saldoInicial){
		saldo = saldoInicial; 
	}
	
	public double consultar(){
	  return saldo; 
	}
	
	public void depositar(double monto){
		saldo = saldo + monto;  
	}
	
	public void retirar(double monto){
		if(monto > saldo){
			System.out.println("Saldo insuficiente");  
		}
		else{
			saldo = saldo - monto;  
		}  
	}   
}
