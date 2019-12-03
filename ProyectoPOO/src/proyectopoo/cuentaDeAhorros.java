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
public class cuentaDeAhorros extends cuenta implements Serializable{
        private  double tasaDeInteres;
	
	public cuentaDeAhorros(double saldoIni, double tasaInteres){
		super(saldoIni);
		tasaDeInteres = tasaInteres;  
	}
        
        public double conTasa(){
            return tasaDeInteres;
        }
        
        @Override
	public double consultar(){
            return (super.consultar() + (super.consultar() * (tasaDeInteres/100)));
	}
        
    public void retirar(double monto) {
    	if((super.consultar() + (super.consultar() * (tasaDeInteres/100))>=monto)){
    		super.retirar(monto-(super.consultar() * (tasaDeInteres/100)));
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Saldo insuficiente");
    	}
    }
}
