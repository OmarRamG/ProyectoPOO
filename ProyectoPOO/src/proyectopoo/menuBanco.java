/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class menuBanco extends JFrame implements ActionListener{
    JButton agregarC,eliminarC,consultarC,salir;
    JLabel SistemaBanco;
    JLabel tituloB;
    
    public menuBanco(){
        configVen();
        comps();
    }
    
    public void configVen(){
        this.setSize(800, 600);
        this.setTitle("Banco: Menú principal");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ImageFondo image=new ImageFondo();
        //image.setImage("/resources/menu.jpg");
        //this.setContentPane(image);
        this.setVisible(true);
    }
    
    public void comps(){
       tituloB = new JLabel("Bienvenido");
       tituloB.setBounds(250, 25, 250, 50);
       //tituloB.setFont();
       this.add(tituloB);
       tituloB.setVisible(true);
        
       agregarC=new JButton("Agregar Cliente/Cuenta");
       agregarC.setBounds(50, 125, 250, 75);
       agregarC.addActionListener(this);
       this.add(agregarC);
       agregarC.setVisible(true);
    
        eliminarC=new JButton("Eliminar Cliente");
        eliminarC.setBounds(50, 225, 250, 75);
        eliminarC.addActionListener(this);
        this.add(eliminarC);
        eliminarC.setVisible(true);
    

        consultarC=new JButton("Consultar Cuentas");
        consultarC.setBounds(50, 325, 250, 75);
        consultarC.addActionListener(this);
        this.add(consultarC);
        consultarC.setVisible(true);    

    
        salir=new JButton("Salir");
        salir.setBounds(550, 450, 150, 50);
        salir.addActionListener(this);
        this.add(salir);
        salir.setVisible(true);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir){
            dispose();
        }
        
        if(e.getSource() == agregarC){
            dispose();
            EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                  agCliente teo=new agCliente();
            
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        }
        
        if(e.getSource() == eliminarC){
            boolean y = false;
            String n = JOptionPane.showInputDialog(this, "Ingresa el nombre del cliente");
            banco b = obtenerDatos();
            for(int i=0;i<b.obtenerTam();i++){
                if(b.obtenerCliente(i).obtenerNombre().equals(n))
                        y = true;
            }
            if(y){
                b.eliminarCliente(n);
                JOptionPane.showMessageDialog(this, "Cliente eliminado");
                guardarDatos(b);
            }
            else{
               JOptionPane.showMessageDialog(this, "No existe ese cliente"); 
            }
         
        }
         
          if(e.getSource() == consultarC){
            String n = JOptionPane.showInputDialog(this, "Ingresa el nombre del cliente");
            boolean y = false;
            banco b = obtenerDatos();
            for(int i=0;i<b.obtenerTam();i++){
                if(b.obtenerCliente(i).obtenerNombre().equals(n))
                        y = true;
            }
            if(y){
                dispose();
                EventQueue.invokeLater(new Runnable(){
                public void run(){
                    try{ 
                      consultas con=new consultas(n);

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                });
            }
            else{
                JOptionPane.showMessageDialog(this,"Ese cliente no existe");
            }
            
        }
    }
    
    public static banco obtenerDatos(){
        banco B = new banco();
        try{
            FileInputStream fis = new FileInputStream("Datos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            B = (banco) ois.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return B;
    }
    
    
    public static void guardarDatos(banco b){
        try{
            FileOutputStream fs = new FileOutputStream("Datos.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(b);
            os.close();

        }
       catch(Exception e){
             e.printStackTrace();
       }
    }
}
