/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Omar Ramirez
 */
public class consultas extends JFrame implements ActionListener{
    JButton regreso;
    JTextArea info;
    JLabel tituloC;
    private String nomC;
    public consultas(String n){
        configVen();
        comps();
        nomC = n;
    }
    
    public void configVen(){
        this.setSize(800, 600);
        this.setTitle("COnsualtas del cliente");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ImageFondo image=new ImageFondo();
        //image.setImage("/resources/menu.jpg");
        //this.setContentPane(image);
        this.setVisible(true);
    }
    
    public void comps(){
       tituloC = new JLabel("Información ");
       tituloC.setBounds(250, 25, 250, 50);
       tituloC.setFont(new Font("Arial",0,18));
       this.add(tituloC);
       tituloC.setVisible(true);
        
       regreso=new JButton("Regresar");
       regreso.setBounds(625, 450, 125, 50);
       regreso.addActionListener(this);
       this.add(regreso);
       regreso.setVisible(true);
    
       info = new JTextArea();
       info.setBounds(50,100,575,400);
       mostrarInfo();
       info.setOpaque(false);
       info.setEditable(false);
       this.add(info);
       info.setVisible(true);
    }
    
    public void mostrarInfo(){
        banco b = menuBanco.obtenerDatos();  
        info.setText("Nombre:"+b.obtenerCliente(nomC).obtenerNombre()+"\n\nCuentas:\n\n");
        for(int i = 0;i < b.obtenerCliente(nomC).obtenerTam();i++){
            if((b.obtenerCliente(nomC).obtenerCuenta(i)) instanceof cuentaDeCheques){
                cuentaDeCheques cta = (cuentaDeCheques) b.obtenerCliente(nomC).obtenerCuenta(i);
                info.setText(info.getText() + "Número de cuenta: "+(i+1)+"\n"+
                                              "Tipo de cuenta: De Cheques\n"+
                                              "Saldo: "+cta.consultar()+"\n"+
                                              "Monto de Sobregiro: "+cta.consultarSobg()+"\n\n");
            }
            else{
                cuentaDeAhorros cta = (cuentaDeAhorros) b.obtenerCliente(nomC).obtenerCuenta(i);
                info.setText(info.getText() + "Número de cuenta: "+(i+1)+"\n"+
                                              "Tipo de cuenta: De Ahorros\n"+
                                              "Saldo: "+cta.consultar()+"\n"+
                                              "Monto de Sobregiro: "+cta.conTasa()+"%\n\n");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        menuBanco m = new menuBanco();
    }
}
