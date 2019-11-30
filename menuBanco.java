/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        
       agregarC=new JButton("Agregar Cliente");
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
            
        }
        
         if(e.getSource() == eliminarC){
            
        }
         
          if(e.getSource() == consultarC){
            
        }
    }
}
