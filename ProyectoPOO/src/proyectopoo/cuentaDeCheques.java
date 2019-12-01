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
public class cuentaDeCheques extends cuenta implements Serializable{
        private double montoSobregiro;
    
        public cuentaDeCheques(double saldoIni,double sobregiro){
		super(saldoIni);
		montoSobregiro = sobregiro;   
	}
	
	public cuentaDeCheques(double saldoIni){
		super(saldoIni);   
	}
	
	public void retirar(double monto){
            if((super.consultar() + montoSobregiro) < monto){
                
            }
            else{
                if(super.consultar() >= monto){
                    super.retirar(monto);
                }
                else{
                    double x = monto - super.consultar();
                    super.retirar(super.consultar());
                    montoSobregiro = montoSobregiro - x;
                }
            }
	}    
}
