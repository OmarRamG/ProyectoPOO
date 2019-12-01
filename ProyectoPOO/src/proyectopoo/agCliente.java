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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Omar Ramirez
 */
public class agCliente extends JFrame implements ActionListener{
    JButton cuentaA,cuentaC,agregaC,listo;
    JLabel nombreC,tipoC,saldo,interes,montoS;
    JTextField nom,sal,inte,sob;
    
    public agCliente(){
        configVen();
        comps();
    }
    
     public void configVen(){
        this.setSize(450, 450);
        this.setTitle("Agregar Cliente");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ImageFondo image=new ImageFondo();
        //image.setImage("/resources/menu.jpg");
        //this.setContentPane(image);
        this.setVisible(true);
    }
    
    public void comps(){
       
        
       cuentaC=new JButton("Cuenta de Cheques");
       cuentaC.setBounds(50, 150, 150, 50);
       cuentaC.addActionListener(this);
       this.add(cuentaC);
       cuentaC.setVisible(true);
    
        cuentaA=new JButton("Cuenta de Ahorros");
        cuentaA.setBounds(250, 150, 150, 50);
        cuentaA.addActionListener(this);
        this.add(cuentaA);
        cuentaA.setVisible(true);
    
        agregaC=new JButton("Agregar Cuenta");
        agregaC.setBounds(150, 250, 150, 40);
        agregaC.addActionListener(this);
        this.add(agregaC);
        agregaC.setVisible(true);
        
        listo=new JButton("Listo");
        listo.setBounds(150, 325, 150, 40);
        listo.addActionListener(this);
        this.add(listo);
        listo.setVisible(false);
       
        nombreC = new JLabel("Nombre Completo");
        nombreC.setBounds(50,30,150,25);
        this.add(nombreC);
        nombreC.setVisible(true);
        
        saldo = new JLabel("Saldo inicial");
        saldo.setBounds(50,65,100,25);
        this.add(saldo);
        saldo.setVisible(true);
        
        tipoC = new JLabel("Elige el tipo de cuenta");
        tipoC.setBounds(50,120,200,25);
        this.add(tipoC);
        tipoC.setVisible(true);
        
        nom = new JTextField();
        nom.setBounds(200,30,200,25);
        this.add(nom);
        nom.setVisible(true);
        
        sal = new JTextField();
        sal.setBounds(200,65,100,25);
        this.add(sal);
        sal.setVisible(true);
        
        interes = new JLabel("Interés");
        interes.setBounds(50,150,100,25);
        this.add(interes);
        interes.setVisible(false);
        
        montoS = new JLabel("Monto de sobregiro");
        montoS.setBounds(50,150,150,25);
        this.add(montoS);
        montoS.setVisible(false);
        
        inte = new JTextField();
        inte.setBounds(200,150,100,25);
        this.add(inte);
        inte.setVisible(false);
        
        sob = new JTextField();
        sob.setBounds(200,150,100,25);
        this.add(sob);
        sob.setVisible(false);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = 0;
        if(e.getSource()== cuentaC){
            cuentaC.setVisible(false);
            cuentaA.setVisible(false);
            montoS.setVisible(true);
            sob.setVisible(true);
        }
        if(e.getSource()== cuentaA){
            cuentaC.setVisible(false);
            cuentaA.setVisible(false);
            interes.setVisible(true);
            inte.setVisible(true);
        }
        if(e.getSource()== agregaC){
            boolean y = true;
            banco b = menuBanco.obtenerDatos();
            for(int i=0;i<b.obtenerTam();i++){
                if(b.obtenerCliente(i).obtenerNombre().equals(nom.getText()))
                        y = false;
            }
            
            if(y){
                cliente c = new cliente(nom.getText());
                if(interes.isVisible()){
                    cuentaDeAhorros cta = new cuentaDeAhorros(Double.parseDouble(sal.getText()),Double.parseDouble(inte.getText()));
                    c.agregarCuenta(cta);
                }
                else{
                    cuentaDeCheques  cta2 = new cuentaDeCheques(Double.parseDouble(sal.getText()),Double.parseDouble(sob.getText()));
                    c.agregarCuenta(cta2);
                }
                b.agrgarCliente(c);
                JOptionPane.showMessageDialog(this, "Cliente agregado(a)");
            }
            else{
               if(interes.isVisible()){
                    cuentaDeAhorros cta = new cuentaDeAhorros(Double.parseDouble(sal.getText()),Double.parseDouble(inte.getText()));
                    b.obtenerCliente(nom.getText()).agregarCuenta(cta);
                }
                else{
                    cuentaDeCheques  cta2 = new cuentaDeCheques(Double.parseDouble(sal.getText()),Double.parseDouble(sob.getText()));
                    b.obtenerCliente(nom.getText()).agregarCuenta(cta2);
                } 
                JOptionPane.showMessageDialog(this, "Cuenta agregada");
            }
            
            menuBanco.guardarDatos(b);
            
            
            listo.setVisible(true);
            montoS.setVisible(false);
            sob.setVisible(false);
            interes.setVisible(false);
            inte.setVisible(false);
            cuentaC.setVisible(true);
            cuentaA.setVisible(true);
            
            
            
            
        }
        if(e.getSource() == listo){
            dispose();
            menuBanco w = new menuBanco();
        }
    }
}
