/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula28marco;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author root
 */
public class Aula28marco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(1234);
        
        System.out.println("Socket Servidor criado com sucesso");
        
        while(true){
            
            
            Socket cliente = servidor.accept();
            
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            DataInputStream in = new DataInputStream(cliente.getInputStream());
        }
    }
    
    
    
}
