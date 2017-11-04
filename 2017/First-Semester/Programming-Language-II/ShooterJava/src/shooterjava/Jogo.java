package shooterjava;


import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab06
 */
public class Jogo extends javax.swing.JFrame{

    int portaLocal = 0;
    String IPRemoto = "";
    int portaRemota=0;
    /**
     * Creates new form Jogo
     */
    public Jogo() {
        initComponents();
        
        portaLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua porta"));
        IPRemoto = JOptionPane.showInputDialog("Digite o número IP do adversário");
        portaRemota = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da porta do adversário"));
        
        Thread thread = new Thread() {  
           @Override
           public void run() {  
              inicializaServidor(); 
             
           }  
        };  
        thread.start(); 
        
        
        /*
        this.jTFPortaLocal.setFocusable(false);
        this.jTFIPremoto.setFocusable(false);
        this.jTFPortaRemota.setFocusable(false);
        this.jButtonIniciar.setFocusable(false);
        
          */
       
    }
    
    
    public void inicializaServidor(){      
        try{ 
             ServerSocket servidor = new ServerSocket(portaLocal);
         // ServerSocket servidor = new ServerSocket(Integer.parseInt(this.jTFPortaLocal.getText()));
          while (true) {
             Socket s = servidor.accept();         
             DataInputStream entrada = new DataInputStream(s.getInputStream()); 
             String posicaoX = entrada.readUTF();            
             DataOutputStream saida = new DataOutputStream(s.getOutputStream());
             saida.writeUTF("");           
             jPanel1.setLocation(Integer.parseInt(posicaoX), jPanel1.getY());
          } 
       } catch(Exception e){}
    }
        
    public void move(int valor) { 
        try{
          // Socket s = new Socket(this.jTFIPremoto.getText(), Integer.parseInt(this.jTFPortaRemota.getText())); 
           Socket s = new Socket(IPRemoto, portaRemota); 
           DataOutputStream saida = new DataOutputStream(s.getOutputStream()); 
           saida.writeUTF(valor+"");                 
           DataInputStream entrada = new DataInputStream(s.getInputStream()); 
           String MsgRecebida = entrada.readUTF();    
            System.out.println(valor);
     } catch(Exception e){
       }
    }
    
    
        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Jogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        Jogo.setText("Jogo");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(Jogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Jogo)
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            // alterar a posicao na minha tela e enviar a posicao para ser alterada na tela do adversário
            
            //alterar na minha tela:
            jPanel1.setLocation(jPanel1.getX() + 5, jPanel1.getY());
            //enviar a posicvao ao adversário
            move(jPanel1.getX() + 5);
        }
        
        else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            //alterar na minha tela:
            jPanel1.setLocation(jPanel1.getX() - 5, jPanel1.getY());
            //enviar a posicvao ao adversário
             move(jPanel1.getX() - 5);
        }
        else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            //alterar na minha tela:
            jPanel1.setLocation(jPanel1.getX(), jPanel1.getY() - 5);
            //enviar a posicvao ao adversário
             move(jPanel1.getY());            
        }
        else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            //alterar na minha tela:
            jPanel1.setLocation(jPanel1.getX(), jPanel1.getY() + 5);
            //enviar a posicvao ao adversário
             move(jPanel1.getY() + 5);
        }
    }                               

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
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Jogo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
