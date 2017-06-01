package multicast;


import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



public class Multicast{

    MulticastSocket s;
    String nick;
    String mensagemRecebida;
    String ipAddress;
    InetAddress grupo;
    JTextArea chat;
    JList<String> listaClientes;
    int lineCount;
    private DefaultListModel listModel;    
    
   
    public Multicast(String address, JTextArea chat, String nick, DefaultListModel listModel){
        this.nick = nick;
        this.listModel = listModel;
        this.chat = chat;   
        DefaultListModel aux;
        
        try {
            //Configuração padrão
            grupo = InetAddress.getByName(address); 
            s = new MulticastSocket(3456);
            s.joinGroup(grupo);         
            
            
            //Criação da thread para recebimento de mensagens
            new Thread(){
                @Override
                public void run(){
                    while(true){
                        try{
                            byte[] buffer = new byte[1000];
                            DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
                            s.receive(pacoteRecebido);//receive bloqueante
                            
                            
                            
                                                        
                            mensagemRecebida = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
                            ipAddress = (pacoteRecebido.getAddress()).getHostAddress();//ip do cliente de recebimento da mensagem      
                            
                            chat.append("\n" + nick  + ":" + ipAddress + "enviou:" + "\n" + mensagemRecebida);
                            
                            
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
    
    public String getMensagemRecebida(){
        if(mensagemRecebida != null){
            return mensagemRecebida;
        }else
            return null;
    }
    
    public String getIpAddress(){
        if(ipAddress != null){
            return ipAddress;
        }else
            return null;
    }
    
    public void AdicionaCliente(){
        if(!listModel.contains(nick)){
            listModel.addElement(nick);
        }else
            JOptionPane.showConfirmDialog(null, "Erro: Nome já existente");                
    }    
    public void sendMessage(String message){
        try {
            DatagramPacket pacote = new DatagramPacket(message.getBytes(),message.length(), grupo, 3456);
            s.send(pacote);//send não bloqueante            
        } catch (Exception e) {
        }        
    }
    
    public void brodcastClientList(){
        try {
              String clientes = listModel.toString();

            DatagramPacket pacote = new DatagramPacket(clientes.getBytes(),clientes.length(), grupo, 3456);
            s.send(pacote);//send não bloqueante            
        } catch (Exception e) {
        }    
        
    }
    
    public DefaultListModel getCLientList(){
        return listModel;        
    }
    
    public void leaveGroup(){
        try {
            s.leaveGroup(grupo);                         
        } catch (Exception e) {
        }
          
    }
    
}