package proyectopoo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class inicio extends JFrame implements ActionListener{
    JButton admin,usuario;
    JLabel inicio;
    private String contra = "1234";

    public inicio(){
        configVen();
        comps();
    }
    
    public void configVen(){
        this.setSize(500, 550);
        this.setTitle("Menu del Cliente");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ImageFondo image=new ImageFondo();
        //image.setImage("/resources/menu.jpg");
        //this.setContentPane(image);
        this.setVisible(true);
    }
    
    public void comps(){
       inicio = new JLabel("Inicio");
       inicio.setBounds(210, 25, 250, 50);
       inicio.setFont(new Font("Arial",0,30));
       this.add(inicio);
       inicio.setVisible(true);


       admin=new JButton("Administrador");
       admin.setBounds(125, 300, 240, 70);
       admin.setFont(new Font("Arial",0,20));
       admin.addActionListener(this);
        this.add(admin);
        admin.setVisible(true);
        
        
        usuario=new JButton("Usuario");
        usuario.setBounds(125, 180, 240, 70);
        usuario.setFont(new Font("Arial",0,20));
        usuario.addActionListener(this);
        this.add(usuario);
        usuario.setVisible(true);
        
     
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == usuario) {
			String m = JOptionPane.showInputDialog(this,"Nombre");
			String c = JOptionPane.showInputDialog(this,"Contraseña");
			if(!validarNombre(m)){
                        boolean y = false;
                        int l=0;
                        banco b = banco.obtenerDatos();
                        for(int i=0;i<b.obtenerTam();i++){
                            if(b.obtenerCliente(i).obtenerNombre().equals(m)){
                                    y = true;
                                    l=i;
                            }
                        }

                if(y && b.obtenerCliente(l).obtenerContraseña().equals(c)){
                    dispose();
                    EventQueue.invokeLater(new Runnable(){
                    public void run(){
                        try{ 
                        	menuCliente a = new menuCliente(m);

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    });
                }
                else{
                    JOptionPane.showMessageDialog(this,"Alguno de los datos proporcionados es incorrecto");
                }
			
			}
		}
		if(e.getSource() == admin) {
			String n = JOptionPane.showInputDialog(this,"Ingrese su contraseña");
			if (n.equals(contra)) {
                            dispose();
                            menuBanco b = new menuBanco();
			}
			else {
				JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
			}
		}
		
	}

	private boolean validarNombre(String m) {
		return false;
	}
}
