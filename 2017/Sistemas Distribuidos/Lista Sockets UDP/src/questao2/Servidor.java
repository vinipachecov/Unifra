package questao2;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Servidor extends javax.swing.JFrame {

    DatagramSocket socket;
    DefaultListModel<String> model = new DefaultListModel<>();

    ArrayList<String> listaClientes = new ArrayList<>();

    public Servidor() {

        initComponents();
        jListClientes.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListClientes = new javax.swing.JList<>();
        messageJTF = new javax.swing.JTextField();

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

        messageJTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageJTFKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(messageJTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(messageJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new Thread() {
            public void run() {
                try {
                    socket = new DatagramSocket(1234);
                    jTAChat.append("Servidor criado com sucesso na porta 1234\n");
                    while (true) {
                        //instanciar um pacote datagrama "vazio" de até 10 0bytes
                        DatagramPacket pacoteRecebido = new DatagramPacket(new byte[100], 100);
                        //servidor começa a aguardar mensagens pela rede por referência
                        socket.receive(pacoteRecebido);
                        //tratar do que se trata o pacote recebido

                        //retiramos do pacote os bytes da mensagem
                        byte buffer[] = pacoteRecebido.getData();
                        //convertemos os bytes em string
                        String mensagemRecebida = new String(buffer, 0, buffer.length);
                        //separamos a string em comando e conteúdo
                        String partes[] = mensagemRecebida.split(":", 2);
                        String comando = partes[0];
                        String conteudo = partes[1];
                        //retira do pacote o ip do cliente
                        String ip = pacoteRecebido.getAddress().getHostAddress();
                        //retira do pacote a porta do cliente
                        int porta = pacoteRecebido.getPort();
                        //adiciona no log a mensagem recebida
                        jTAChat.append("["+ip+":"+porta+" => "+mensagemRecebida + "\n");
                        //autoscroll
                        jTAChat.setCaretPosition(jTAChat.getDocument().getLength());
                        if (comando.equals("CONECTAR")) {
                             //adiciona na lista somente se o cliente não está
                            if (!listaClientes.contains(ip + ":" + porta)) {
                                //adicionar o cliente na lista
                                listaClientes.add(ip + ":" + porta);
                                //adiciona no jlist
                                model.addElement(ip + ":" + porta);
                            }
                        } else if (comando.equals("DESCONECTAR")) {
                            //remove o cliente na lista
                            listaClientes.remove(ip + ":" + porta);
                            //remove do jlist
                            model.removeElement(ip + ":" + porta);
                        } else if (comando.equals("MENSAGEM")) {
                            //repassar a mensagem para todos os clientes da lista
                            for (String cliente : listaClientes) {
                                //retiro o ip e a porta do cliente da lista
                                String clientePartes[] = cliente.split(":");
                                String ipEnviar = clientePartes[0];
                                int portaEnviar = Integer.parseInt(clientePartes[1]);
                                //montamos a mensagem a ser enviada
                                String mensagemEnviar = ip + ":" + porta + " disse " + conteudo;
                                //monto um pacote datagrama para enviar
                                DatagramPacket pacoteEnviar = new DatagramPacket(
                                        mensagemEnviar.getBytes(),
                                        mensagemEnviar.getBytes().length,
                                        InetAddress.getByName(ipEnviar),
                                        portaEnviar);
                                socket.send(pacoteEnviar);
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

    private void messageJTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageJTFKeyPressed
            // TODO add your handling code here:
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                sendMessage();
            }
    }//GEN-LAST:event_messageJTFKeyPressed

    /**
     * @param args the command line arguments
     */
    public void sendMessage(){
        String mensagemEnviar =  "Servidor Disse: "+  messageJTF.getText();
        try {
            for (String cliente : listaClientes) {
            //retiro o ip e a porta do cliente da lista
            String clientePartes[] = cliente.split(":");
            String ipEnviar = clientePartes[0];
            int portaEnviar = Integer.parseInt(clientePartes[1]);
            //monto um pacote datagrama para enviar
            DatagramPacket pacoteEnviar = new DatagramPacket(
                    mensagemEnviar.getBytes(),
                    mensagemEnviar.getBytes().length,
                    InetAddress.getByName(ipEnviar),
                    portaEnviar);
            socket.send(pacoteEnviar);
        }            
        } catch (Exception e) {
            System.out.println("Error = " + e.getMessage());
        }        
        messageJTF.setText("");
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jListClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAChat;
    private javax.swing.JTextField messageJTF;
    // End of variables declaration//GEN-END:variables
}
