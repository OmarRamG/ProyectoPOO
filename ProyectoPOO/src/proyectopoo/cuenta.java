/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.Serializable;

import javax.swing.JOptionPane;

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
	
	public void depositar(double monto,int e){
		saldo = saldo + monto;
                    if(e == 0)
                        JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
                    else
                        JOptionPane.showMessageDialog(null, "Realizando transferencia");
	}
	
	public void retirar(double monto){
		if(monto > saldo){
			JOptionPane.showMessageDialog(null, "Saldo insuficiente"); 
		}
		else{
			saldo = saldo - monto;  
                            JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
			
		}  
	}  
	
	public boolean retirar(double monto, int n){
        boolean x = false;
		if(monto > saldo){
			JOptionPane.showMessageDialog(null, "Saldo insuficiente"); 
		}
		else{
			saldo = saldo - monto;  
			x = true;
		} 
		return x;
	}
}
