/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
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
    JLabel SistemaBanco,imagen;
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
       tituloB.setBounds(275, 25, 250, 50);
       tituloB.setFont(new Font("Arial",0,30));
       this.add(tituloB);
       tituloB.setVisible(true);
       
       imagen = new JLabel();
       imagen.setBounds(400,125,300,300);
       ImageIcon icono=new ImageIcon(getClass().getResource("/resources/bancoF.jpg"));
       imagen.setIcon(icono);
       imagen.setBorder(null);
       this.add(imagen);
       imagen.setVisible(true);

        
       agregarC=new JButton("Agregar Cliente/Cuenta");
       agregarC.setBounds(50, 125, 250, 75);
       agregarC.setFont(new Font("Arial",0,18));
       agregarC.addActionListener(this);
       this.add(agregarC);
       agregarC.setVisible(true);
    
        eliminarC=new JButton("Eliminar Cliente");
        eliminarC.setBounds(50, 225, 250, 75);
        eliminarC.setFont(new Font("Arial",0,18));
        eliminarC.addActionListener(this);
        this.add(eliminarC);
        eliminarC.setVisible(true);
    

        consultarC=new JButton("Consultar Cuentas");
        consultarC.setBounds(50, 325, 250, 75);
        consultarC.setFont(new Font("Arial",0,18));
        consultarC.addActionListener(this);
        this.add(consultarC);
        consultarC.setVisible(true);    

    
        salir=new JButton("Salir");
        salir.setBounds(550, 450, 150, 50);
        salir.setFont(new Font("Arial",0,14));
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
            String n = JOptionPane.showInputDialog(this, "Ingresa el nombre del cliente");
            if(validarNombre(n)){
                banco b = banco.obtenerDatos();
                boolean y = false;
                for(int i=0;i<b.obtenerTam();i++){
                    if(b.obtenerCliente(i).obtenerNombre().equals(n))
                            y = true;
                }
                if(y){
                    b.eliminarCliente(n);
                    JOptionPane.showMessageDialog(this, "Cliente eliminado");
                    banco.guardarDatos(b);
                }
                else{
                   JOptionPane.showMessageDialog(this, "No existe ese cliente"); 
                }
            }
         
        }
         
          if(e.getSource() == consultarC){
            String n = JOptionPane.showInputDialog(this, "Ingresa el nombre del cliente");
            if(validarNombre(n)){
                boolean y = false;
                banco b = banco.obtenerDatos();
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
    }
    
    
    
    public boolean validarNombre(String n){
        boolean x = true;
        Pattern p = Pattern.compile("[^a-z ]",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(n);
        boolean b = m.find();
        try{
            if(n.isEmpty()){
                throw new excepciones(2);
            } else if(b){
                throw new excepciones(0);
            }
        }
        catch(excepciones e){
            x = false;
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        return x;
    }
}
