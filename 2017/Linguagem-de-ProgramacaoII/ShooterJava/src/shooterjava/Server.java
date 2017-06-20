/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooterjava;

import java.awt.Point;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author vinipachecov
 */
public class Server {
    int portaLocal;
    ServerSocket server;
    ArrayList<Socket> clientList;
    Socket auxClient;
    
    public Server(String ip, int Porta){
        portaLocal = Porta;    
        clientList = new ArrayList<>();
        System.out.println("Inciando Servidor na porta " + Porta + "...");
          try{ 
             ServerSocket server = new ServerSocket(Porta);
         // ServerSocket servidor = new ServerSocket(Integer.parseInt(this.jTFPortaLocal.getText()));
          while (true) {
              
            
            Socket client = server.accept();                              
            clientList.add(client);
             System.out.println("Cliente conectou = " + client.getInetAddress() +":"+client.getPort());          
              new Thread(){
            
                Socket myclient = client;
                public void run(){//
                    try {
                        
                        //set player
                        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                        outputStream.writeInt(clientList.size());                                    
                                         
                        while(true){
                            try{
                                ObjectInputStream entrada = new ObjectInputStream(client.getInputStream()); 
                                Point pontonovo =(Point) entrada.readUnshared();                               
                                //System.out.println("valor recebido = " + pontonovo);
                                if(pontonovo.equals(new Point(0,0))){
                                    broadcast(myclient);
                                }else
                                    broadcast(myclient, pontonovo);
                                //System.out.println("Lista de clientes : " + clientList);
                            }catch(Exception e){

                            }
                            try {
                                
                            } catch (Exception e) {

                            }                                                                             
                        }                                    
                    } catch (Exception e) {
                        //case where client leaved
                        e.printStackTrace();                        
                        clientList.remove(myclient);
                    }

                }
            }.start();
                     
          
          } 
       } catch(Exception e){
       }
    }
    
    public void broadcast(Socket client, Point novoPonto){
        for (Socket socket : clientList) {
            if(!client.equals(socket)){
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream()); 
                    outputStream.writeUnshared(novoPonto);              
                } catch (Exception e) {
                }                
            }            
        }        
    }
    
    public void broadcast(Socket client){          
        //get which player has scored
        int index = clientList.indexOf(client);
        
        //send signal to all players to lower lifepoint
        for (Socket socket : clientList) {            
                try {
                    //send score signal
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream()); 
                    outputStream.writeUnshared(new Point(0,0));  
                } catch (Exception e) {
                }            
                //send who scored
                try {
                    //send score signal
                    DataOutputStream outputStream1 = new DataOutputStream(socket.getOutputStream());
                    outputStream1.writeInt(index+1);                    
                } catch (Exception e) {
                }                                    
        }               
    }
    
    public static void main(String[] args) {
        Server soServer = new Server("127.0.0.1", 1234);
        
        while (true) {            
            
        }
    }
    
}
