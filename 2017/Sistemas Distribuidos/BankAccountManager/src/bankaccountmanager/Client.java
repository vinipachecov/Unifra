/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author root
 */
public class Client extends javax.swing.JFrame {
    Socket socket;
    /**
     * Creates new form view1
     */
    public Client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ipJtf = new javax.swing.JTextField();
        portaJTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        conectarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatAreaJTA = new javax.swing.JTextArea();
        mensagemJTF = new javax.swing.JTextField();
        enviarMenssagemButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nickJTF = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("IP");

        ipJtf.setText("localhost");

        portaJTF.setText("1234");

        jLabel2.setText("Porta");

        conectarButton.setText("Conectar");
        conectarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conectarButtonMouseClicked(evt);
            }
        });

        chatAreaJTA.setEditable(false);
        chatAreaJTA.setColumns(20);
        chatAreaJTA.setRows(5);
        jScrollPane1.setViewportView(chatAreaJTA);

        mensagemJTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mensagemJTFKeyPressed(evt);
            }
        });

        enviarMenssagemButton.setText("Enviar");
        enviarMenssagemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarMenssagemButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("Nick");

        nickJTF.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ipJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nickJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(conectarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mensagemJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enviarMenssagemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipJtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(conectarButton)
                    .addComponent(jLabel3)
                    .addComponent(nickJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensagemJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarMenssagemButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conectarButtonMouseClicked
        // TODO add your handling code here:
        String ip = ipJtf.getText().toString();
        int porta  = Integer.parseInt(portaJTF.getText().toString());
        try {
            socket = new Socket(ipJtf.getText().toString(), Integer.parseInt(portaJTF.getText().toString()));
            //
            enviarMenssagemButton.setEnabled(true);
            mensagemJTF.setEnabled(true);
            // criar uma thread (inline) para receber mensagens do servidor
            new Thread(){
                public void run(){
                    while(true){
                        try {                            
                            DataInputStream in = new DataInputStream(socket.getInputStream());
                            String mensagemRecebida = in.readUTF();     
                            //adiciona mensagem na interface gráfica do chat
                            chatAreaJTA.append(mensagemRecebida + '\n');                            
                        } catch (Exception e) {
                            chatAreaJTA.append("Servidor erro 500" + '\n');
                            mensagemJTF.setEnabled(false);
                            enviarMenssagemButton.setEnabled(false);
                        }                        
                        mensagemJTF.setText("");
                    }                    
                }
            }.start();
                  
        } catch (Exception e) {
            chatAreaJTA.append("Servidor " + ip + "na porta " + porta + "não encontrado");
        }

    }//GEN-LAST:event_conectarButtonMouseClicked

    private void enviaMensagem(){
        String mensagem  = mensagemJTF.getText().toString();
        String nick = nickJTF.getText().toString();
        try {
            //cria canal de envio UTF
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            //envia mensagem
            outStream.writeUTF(nick + "disse: " + mensagem);
        } catch (Exception e) {
            chatAreaJTA.append("Servidor erro 500" + '\n');
            mensagemJTF.setEnabled(false);
            enviarMenssagemButton.setEnabled(false);
        }
        
        
    }
    private void enviarMenssagemButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarMenssagemButtonMouseClicked
        // TODO add your handling code here:
        //enviar mensagem
        
        enviaMensagem();
    }//GEN-LAST:event_enviarMenssagemButtonMouseClicked

    private void mensagemJTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensagemJTFKeyPressed
        // TODO add your handling code here:
        //mensagem
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            enviaMensagem();
        }
        
    }//GEN-LAST:event_mensagemJTFKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(socket != null){
            try {
                socket.close();
            } catch (Exception e) {
            }            
        }
    }//GEN-LAST:event_formWindowClosing

    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatAreaJTA;
    private javax.swing.JButton conectarButton;
    private javax.swing.JButton enviarMenssagemButton;
    private javax.swing.JTextField ipJtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField mensagemJTF;
    private javax.swing.JTextField nickJTF;
    private javax.swing.JTextField portaJTF;
    // End of variables declaration//GEN-END:variables
}
