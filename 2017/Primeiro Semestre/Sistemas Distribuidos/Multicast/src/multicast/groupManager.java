/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author vinipachecov
 */
public class groupManager {
    MulticastSocket s;
     String nick;
    String mensagemRecebida;
    String ipAddress;
    InetAddress grupo;
    JTextArea chat;
    JList<String> listaClientes;
    int lineCount;
    private DefaultListModel listModel;
    private Object test;
    
    public groupManager(){
        try {
            //Configuração padrão
            grupo = InetAddress.getByName("239.1.2.4"); 
            s = new MulticastSocket(3455);
            s.joinGroup(grupo);         
            listModel = new DefaultListModel<>();         
            
            //Criação da thread para recebimento de mensagens
            new Thread(){
                @Override
                public void run(){
                    while(true){
                        try{
                            byte[] buffer = new byte[1000];
                            DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
                            s.receive(pacoteRecebido);//receive bloqueante                                  
                            ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
                            ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
                            Object o = is.readObject();      
                            System.out.println();
      
                                                        
//                            mensagemRecebida = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());   
//                            System.out.println("valor recebido " + mensagemRecebida);
                            
                            
                            
                           
                           
//                            ipAddress = (pacoteRecebido.getAddress()).getHostAddress();//ip do cliente de recebimento da mensagem      
                            
//                            chat.append("\n" + nick  + ":" + ipAddress + "enviou:" + "\n" + mensagemRecebida);
                            
                            
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            
                       
            //processo deixa o grupo
            //s.leaveGroup(grupo);            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
     public void sendMessage(DefaultListModel novo){
         String aux = novo.toString();         
        try {
            DatagramPacket pacote = new DatagramPacket(aux.getBytes(),aux.getBytes().length, grupo, 3455);
            s.send(pacote);//send não bloqueante            
        } catch (Exception e) {
        }        
    }
     
    public void teste(DefaultListModel novo){
        Object [] aux = novo.toArray();        
        System.out.println("valor dentro do model");            
        for (Object object : aux) {
            System.out.println(object);            
        }        
    }
       public static void main(String[] args) {
        groupManager gm = new groupManager();
        DefaultListModel listModel = new DefaultListModel<>();
        listModel.addElement("João");
        listModel.addElement("João1");
        listModel.addElement("João10");
        listModel.addElement("João4");        
        gm.sendMessage(listModel);
        gm.teste(listModel);
        while (true) {            
            
        }
    }
}

