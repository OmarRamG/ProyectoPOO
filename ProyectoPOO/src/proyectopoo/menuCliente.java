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

public class menuCliente extends JFrame implements ActionListener{
	JButton consultarC,salir,deposito, retiro, transferencia;
    JLabel SistemaBanco,imagen;
    JLabel tituloB;
    private String nom;
    
    public menuCliente(String nom){
        configVen();
        comps();
        this.nom = nom;
    }
    
    public void configVen(){
        this.setSize(800, 650);
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


        consultarC=new JButton("Consultar Cuentas");
        consultarC.setBounds(30, 100, 220, 50);
        consultarC.setFont(new Font("Arial",0,18));
        consultarC.addActionListener(this);
        this.add(consultarC);
        consultarC.setVisible(true);
        
        
        retiro=new JButton("Retiro");
        retiro.setBounds(30, 170, 220, 50);
        retiro.setFont(new Font("Arial",0,18));
        retiro.addActionListener(this);
        this.add(retiro);
        consultarC.setVisible(true);
        
        
        deposito=new JButton("Deposito Propio");
        deposito.setBounds(30, 240, 220, 50);
        deposito.setFont(new Font("Arial",0,18));
        deposito.addActionListener(this);
        this.add(deposito);
        consultarC.setVisible(true);
        
        
        transferencia=new JButton("Transferencia");
        transferencia.setBounds(30, 310, 220, 50);
        transferencia.setFont(new Font("Arial",0,18));
        transferencia.addActionListener(this);
        this.add(transferencia);
        consultarC.setVisible(true);
        
    
        salir=new JButton("Salir");
        salir.setBounds(550, 520, 150, 50);
        salir.setFont(new Font("Arial",0,14));
        salir.addActionListener(this);
        this.add(salir);
        salir.setVisible(true);   
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir){
            dispose();
            inicio i = new inicio();
        }

         
          if(e.getSource() == consultarC){
                boolean y = false;
                banco b = banco.obtenerDatos();
                for(int i=0;i<b.obtenerTam();i++){
                    if(b.obtenerCliente(i).obtenerNombre().equals(nom))
                            y = true;
                }
                if(y){
                    dispose();
                    EventQueue.invokeLater(new Runnable(){
                    public void run(){
                        try{ 
                          consultaCliente con=new consultaCliente(nom);

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
          
          
        if(e.getSource() == retiro){
              String c = JOptionPane.showInputDialog(this, "Ingresa tu contraseña");
              
              int m = Integer.parseInt(JOptionPane.showInputDialog(this, "Numero de cuenta"));
              int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad"));
              int l = 0;
              boolean y = false;

             banco b = banco.obtenerDatos();
             for(int i=0;i<b.obtenerTam();i++){
                  if(b.obtenerCliente(i).obtenerContraseña().equals(c)) {
                              y = true;
                              l=i;
                    }
             }
               if(y){
                    b.obtenerCliente(l).obtenerCuenta(m-1).retirar(x,'a');
                    banco.guardarDatos(b);
                  }
                  else{
                      JOptionPane.showMessageDialog(this,"La informacion no es correcta");
                  }
          }
        
        if(e.getSource() == deposito){
            String c = JOptionPane.showInputDialog(this, "Ingresa tu contraseña");
            int m = Integer.parseInt(JOptionPane.showInputDialog(this, "Numero de cuenta"));
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad"));
            int l = 0;
            boolean y = false;

            banco b = banco.obtenerDatos();
            for(int i=0;i<b.obtenerTam();i++){
                   if(b.obtenerCliente(i).obtenerContraseña().equals(c)) {
                            y = true;
                            l=i;
                   }
            }
            if(y){
                b.obtenerCliente(l).obtenerCuenta(m-1).depositar(x,0);
                banco.guardarDatos(b);
            }
            else{
                    JOptionPane.showMessageDialog(this,"La informacion no es correcta");
            }
        }
        
        if(e.getSource() == transferencia){
        	String c = JOptionPane.showInputDialog(this, "Ingresa tu contraseña");
        	int d = Integer.parseInt(JOptionPane.showInputDialog(this,"Cuenta de extraccion"));
        	String n = JOptionPane.showInputDialog(this, "Ingresa el nombre del beneficiario");
        	int nc = Integer.parseInt(JOptionPane.showInputDialog(this,"Numero de cuenta del beneficiario"));
        	int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad"));
        	
        	 boolean y = false;
        	 int l = 0;
        	 
             banco b = banco.obtenerDatos();
             for(int i=0;i<b.obtenerTam();i++){
                    if(b.obtenerCliente(i).obtenerContraseña().equals(c)) {
                             y = true;
                    }
             }
             if(y){
            	 boolean r = false;
            	 if((d-1)<= b.obtenerCliente(nom).obtenerTam()) {
	            	 for(int i=0;i<b.obtenerTam();i++){
	                     if(b.obtenerCliente(i).obtenerNombre().equals(n)){
	                    	 if((nc -1)<= b.obtenerCliente(i).obtenerTam())
	                    		 r = true;
	                    	 
	                     }
	            	 }
            	 }
            	 
            	 if(r) {
            		 if(b.obtenerCliente(nom).obtenerCuenta(d-1).retirar(x,1)) {
            			 b.obtenerCliente(n).obtenerCuenta(nc-1).depositar(x,1);
                                 banco.guardarDatos(b);
                                Transferencia transferencia = new Transferencia("Transferencia completada con exito");
                                TransferenciaHilo transferenciaHilo = new TransferenciaHilo(transferencia);
                                transferenciaHilo.start();
                                transferenciaHilo.join();
            		 } 
                     
            	 }
            	 else {
            		 JOptionPane.showMessageDialog(this,"La informacion no es correcta");
            	 }
                 
             }
             else{
                     JOptionPane.showMessageDialog(this,"La informacion no es correcta");
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
