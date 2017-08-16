package questao3;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Servidor extends javax.swing.JFrame {
    ArrayList<Product> Products;
    DatagramSocket socket;
    DefaultListModel<String> model = new DefaultListModel<>();
    ActiveUsers l_activeusers = new ActiveUsers();
    
    public Servidor() {
        initComponents();
        jListClientes.setModel(model);
        InitializeProducts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListClientes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Inicializar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTAChat.setColumns(20);
        jTAChat.setRows(5);
        jTAChat.setFocusable(false);
        jScrollPane1.setViewportView(jTAChat);

        jListClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListClientes.setFocusable(false);
        jScrollPane2.setViewportView(jListClientes);

        jLabel1.setText("Client List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String menu = MenuOfProducts();
        new Thread() {
            public void run() {
                try {
                    socket = new DatagramSocket(1234);
                    jTAChat.append("Server Started on port 1234 \n");
                    while (true) {

                        
                        DatagramPacket packageReceived = new DatagramPacket(new byte[200], 200);
                        //servidor começa a aguardar mensagens pela rede por referência
                        socket.receive(packageReceived);
                        //tratar do que se trata o pacote recebido

                        //retiramos do pacote os bytes da mensagem
                        byte buffer[] = packageReceived.getData();
                        //convertemos os bytes em string
                        String messageReceived = new String(buffer, 0, packageReceived.getLength());
                        
                        
                        String ip = packageReceived.getAddress().getHostAddress();
                        
                        
                        //retira do pacote a porta do cliente
                        int port = packageReceived.getPort();
                        
                        
                        if(messageReceived.equals("CONNECT")){                            
                            sendMenu(menu,ip,port);
                        }else{
                            
                            //send the menu of products to the connected clients                        
                            //separamos a string em comando e conteúdo
                            String parts[] = messageReceived.split(":");  
                            Integer divisions = parts.length;                            
                            if(parts.length == 3){
                                String id = parts[0];
                                String product = parts[1];
                                Integer nquant = Integer.parseInt(parts[2]); 
                                
                        
                        
                                //autoscroll
                                jTAChat.setCaretPosition(jTAChat.getDocument().getLength());
                                
                                //check if is an incomer                                
                                if (!l_activeusers.contains(id)) {  
                                    jTAChat.append("New user " + id + '\n');
                                    //new client to client list
                                    l_activeusers.addUser(id);
                                    //add to GUI's list                                    
                                    model.addElement("Usuario: user-" + id );                            
                                }
                                //make request to add a sale of nquant units of                                 
                                l_activeusers.requestAddSale(id, product, nquant, findProductPrice(product));                                                        
                                sendMenu(menu,ip,port);                                
                            }
                            else{
                                //Finishing service                            
                                String id = parts[0];
                                String request = parts[1];
                                //return the total        
                                if(request.equals("LISTAGEM FINALIZADA")){
                                    jTAChat.append("[" + "user " + id + "asked for "
                                         +" the bottom line"+ "\n");
                                                                 
                                String stotal =  "Your total is = "+ l_activeusers.requestTotal(id).toString();
                                jTAChat.append("Total of the client " + id + 
                                        "is " + stotal);
                                
                                DatagramPacket total = new DatagramPacket(
                                        stotal.getBytes(),
                                        stotal.getBytes().length,
                                        InetAddress.getByName(ip),
                                port);
                                //envia para o servidor
                                socket.send(total);             
                                
                                l_activeusers.removeUser(id);
                                //remove do jlist
                                model.removeElement("user:" + id);    
                                }                                
                            }                                                
                        }                                              
                    }
                } catch (SocketException ex) {
                    //tratamos erro de criação do socket
                    jTAChat.append("Porta 1234 já em uso\n");
                } catch (IOException ex) {
                    //tratamos erro de recebimento de pacotes pela rede
                    jTAChat.append("Erro no recebimento de um pacote\n");
                }
            }
        }.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //fecha a conexão com todos os clientes

    }//GEN-LAST:event_formWindowClosing
    
    
    public void sendMenu(String menu, String ip, int port){
        try {
            DatagramPacket menuPackage = new DatagramPacket(
                            menu.getBytes(),
                            menu.getBytes().length,
                            InetAddress.getByName(ip),
                            port);
                        //envia para o servidor
                        socket.send(menuPackage);        
            
        } catch (Exception e) {
            jTAChat.append(e.getMessage() + '\n');
        }         
    }
    public Double findProductPrice(String name){
        for (Product Product1 : Products) {
            if(Product1.name.equals(name)){
                return Product1.getPrice();
            }                        
        }
        return 0.0;
    }
    
    public void InitializeProducts(){
        Products = new ArrayList<Product>();
        Products.add(new Product("Farinha", 1.50));
        Products.add(new Product("Beterraba", 1.25));
        Products.add(new Product("Alcatra", 25.00));
        Products.add(new Product("Alface", 2.00));
        Products.add(new Product("Ovos", 6.20));
        Products.add(new Product("Azeite", 4.30));    
        Products.add(new Product("Leite-Caixa1L", 4.40));            
    }
    
    public String MenuOfProducts(){
        String menu;
        menu = "Menu of Products | Price" + '\n';
        for (Product Product1 : Products) {
            menu = menu + Product1.name + "| " + Product1.price.toString() + " \n";             
            System.out.println(Product1.price);
        }
        menu = menu + "------------------------"+ '\n';
        return menu;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAChat;
    // End of variables declaration//GEN-END:variables
}
