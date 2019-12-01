/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

/**
 *
 * @author Alumno
 */
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
public class ProyectoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                try{
                    banco b = new banco();
                    FileOutputStream fs = new FileOutputStream("Datos.dat");
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(b);
                    os.close();
                    menuBanco window = new menuBanco();

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    
}
