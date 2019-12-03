package proyectopoo;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TransferenciaHilo implements Runnable{
	private Thread hilo;
	private Transferencia destino;
	
	public TransferenciaHilo(Transferencia destino) {
		this.destino = destino;
		hilo = new Thread(this);
	}

	public void start() {
		hilo.start();
	}
	
	public void join() {
		try {
			hilo.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		synchronized(destino) {
			
			try {
				System.out.println("Corriendo");
				//destino.transferir(mensaje);
				/*SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JOptionPane.showMessageDialog(null,mensaje);
					}
				});*/
				SwingUtilities.invokeLater(destino);
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	}
	
}
