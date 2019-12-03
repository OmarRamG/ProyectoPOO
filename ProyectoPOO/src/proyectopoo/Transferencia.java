package proyectopoo;

import javax.swing.JOptionPane;

public class Transferencia implements Runnable{
	private String mensaje;
	public Transferencia(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void transferir(String mensaje) {
		
		JOptionPane.showMessageDialog(null,mensaje);
		System.out.println(".");
	}
	
	public void run() {
		JOptionPane.showMessageDialog(null,mensaje);
	}
}
