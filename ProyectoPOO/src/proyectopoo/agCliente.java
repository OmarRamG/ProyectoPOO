/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            if(validar()){
                boolean y = true, p = true;
                banco b = banco.obtenerDatos();
                for(int i=0;i<b.obtenerTam();i++){
                    if(b.obtenerCliente(i).obtenerNombre().equals(nom.getText()))
                            y = false;
                }

                if(y){
                        cliente c = new cliente(nom.getText());
                        if(interes.isVisible()){
                            if(validarTipos(1)){
                                cuentaDeAhorros cta = new cuentaDeAhorros(Double.parseDouble(sal.getText()),Double.parseDouble(inte.getText()));
                                c.agregarCuenta(cta);
                                b.agregarCliente(c);
                                JOptionPane.showMessageDialog(this, "Cliente agregado(a)");
                            }
                            else
                                p = false;
                        }
                        else{
                            if(validarTipos(0)){
                                cuentaDeCheques  cta2 = new cuentaDeCheques(Double.parseDouble(sal.getText()),Double.parseDouble(sob.getText()));
                                c.agregarCuenta(cta2);
                                b.agregarCliente(c);
                                JOptionPane.showMessageDialog(this, "Cliente agregado(a)");
                            }
                            else
                                p = false;
                        }
    
                }
                else{
                    if(interes.isVisible()){
                        if(validarTipos(1)){
                            cuentaDeAhorros cta = new cuentaDeAhorros(Double.parseDouble(sal.getText()),Double.parseDouble(inte.getText()));
                            b.obtenerCliente(nom.getText()).agregarCuenta(cta);
                            JOptionPane.showMessageDialog(this, "Cuenta agregada");
                        }
                        else
                                p = false;
                     }
                     else{
                        if(validarTipos(0)){
                            cuentaDeCheques  cta2 = new cuentaDeCheques(Double.parseDouble(sal.getText()),Double.parseDouble(sob.getText()));
                            b.obtenerCliente(nom.getText()).agregarCuenta(cta2);
                            JOptionPane.showMessageDialog(this, "Cuenta agregada");
                        }
                        else
                                p = false;
                     } 
                }

                banco.guardarDatos(b);

                if(p){
                    listo.setVisible(true);
                    montoS.setVisible(false);
                    sob.setVisible(false);
                    interes.setVisible(false);
                    inte.setVisible(false);
                    cuentaC.setVisible(true);
                    cuentaA.setVisible(true);
                }
            
            }
            
        }
        if(e.getSource() == listo){
            dispose();
            menuBanco w = new menuBanco();
        }
    }
    
    public boolean validar(){
        boolean x = true;
        Pattern p = Pattern.compile("[^a-z ]",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nom.getText());
        boolean b = m.find();
        
        Pattern p2 = Pattern.compile("[^0-9.]",Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(sal.getText());
        boolean b2 = m2.find();
        try{
            if(nom.getText().isEmpty()){
                throw new excepciones(2);
            }else if(b){
                throw new excepciones(0);
            }else if(sal.getText().isEmpty()){
                throw new excepciones(3);
            }else if(b2){
                throw new excepciones(1);
            }   
        }
        catch(excepciones e){
            JOptionPane.showMessageDialog(this, e.getMessage());   
            x = false;
        }
        return x;
    }
    
    public boolean validarInteres(){
        boolean i = true;
        Pattern p = Pattern.compile("[^0-9.]",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(inte.getText());
        boolean b = m.find();
        try{
            if(inte.getText().isEmpty()){
                throw new excepciones(5);
            }else if(b){
                throw new excepciones(4);
            }
        }
        catch(excepciones e){
            JOptionPane.showMessageDialog(this, e.getMessage());   
            i= false;
        }
        
        return i;
    }
        
    public boolean validarSobregiro(){
            boolean j = true;
            Pattern p = Pattern.compile("[^0-9.]",Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(sob.getText());
            boolean b = m.find();
            try{
                if(sob.getText().isEmpty()){
                    throw new excepciones(7);
                }else if(b){
                    throw new excepciones(6);
                }
            }
            catch(excepciones e){
                JOptionPane.showMessageDialog(this, e.getMessage());   
                j= false;
            }

            return j;
   }
    
    public boolean validarTipos(int t){
        if(t == 1)
            return validarInteres();
        else
            return validarSobregiro();
    }
}
