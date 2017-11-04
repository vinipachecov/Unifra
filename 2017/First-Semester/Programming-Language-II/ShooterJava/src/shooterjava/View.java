/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooterjava;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author vinipachecov
 */


/*
WESTERN shooter pong game

1- COnnect two computers through network
2- Connect each computer to move a single object (player object)

*/

public class View extends javax.swing.JFrame {

    public int portaPlayer1 = 0;
    public String ipPlayer2 = "";
    public int portaServidor=0;
    public int player;
    public Socket socket;
    public Point vitoria;
    public Rectangle rectareaP1;
    public Rectangle rectareaP2;
    
    public View() {
        initComponents();
                Thread thread = new Thread() {  
           @Override
           public void run() {  
              inicializaCliente();              
           }  
        };  
        thread.start();             
    }
    
    public void inicializaCliente(){  
        
        //código para demonstrar que alguém marcou um ponto
        vitoria = new Point(0,0);
        
        try {
            socket = new Socket("127.0.0.1",1234);            
        } catch (Exception e) {
        }       
        try{           
             DataInputStream entrada = new DataInputStream(socket.getInputStream()); 
             player = entrada.readInt();     
             System.out.println("VOCE É O PLAYER " + player);
             //Create a thread to receive other players position updates
             new Thread(){
                public void run(){
                    while(true){
                        try {                            
                            //read menu of operations
                            ObjectInputStream updatepoint = new ObjectInputStream(socket.getInputStream()); 
                            Point novoponto = (Point) updatepoint.readUnshared();                            
                            if(novoponto.equals(vitoria)){
                                System.out.println("Alguém marcou um ponto");
                                DataInputStream vencedor = new DataInputStream(socket.getInputStream());
                                int pvencedor = vencedor.readInt();
                                System.out.println("Player "+ pvencedor + "tirou uma vida do " + (pvencedor+1));
                                //player one scored so player 2 lose a life point
                                if(pvencedor == 1){
                                    if(Integer.parseInt(nvidasPlayer2.getText()) == 1){
                                        JOptionPane.showMessageDialog(null, "O player 1 Ganhou");                                        
                                        newbattle();   
                                        restart();
                                    }else{
                                        Integer novavida = Integer.parseInt(nvidasPlayer2.getText()) -1;
                                        nvidasPlayer2.setText(novavida.toString());                                                                        
                                        newbattle();    
                                        
                                    }                                        
                                }else{
                                    //player two scored so player 1 lose a life point
                                    if(Integer.parseInt(nvidasPlayer1.getText()) == 1){
                                        JOptionPane.showMessageDialog(null, "O player 2 Ganhou");                                        
                                        newbattle();   
                                        restart();                                        
                                    }else{
                                        Integer novavida = Integer.parseInt(nvidasPlayer1.getText()) -1;
                                        nvidasPlayer1.setText(novavida.toString());                                                                        
                                        newbattle();                                                                            
                                    }                                        
                                }
                            }
                            else if(player == 1){
                                Player2.setLocation(novoponto);
                            }else
                                Player1.setLocation(novoponto);                        
                        } catch (Exception e) {
                        
                        }                        
                        
                    }                    
                }
            }.start();
       } catch(Exception e){
       }       
    }
    
    public void restart(){
        nvidasPlayer1.setText("3");
        nvidasPlayer2.setText("3");
    }
    
    public void newbattle(){
        Player1.setLocation(new Point(54,48));
        Player2.setLocation(new Point(796,48));        
    }
        
    public void move(Point nponto) { 
        try{          
            //Send the point of the changed player to the server
            ObjectOutputStream ponto = new ObjectOutputStream(socket.getOutputStream());
           ponto.writeUnshared(nponto);    
           
      
        } catch(Exception e){                
        }
    }
            
       
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1 = new javax.swing.JPanel();
        Player2 = new javax.swing.JPanel();
        vidasPlayer2 = new javax.swing.JLabel();
        vidasPlayer1 = new javax.swing.JLabel();
        nvidasPlayer1 = new javax.swing.JLabel();
        nvidasPlayer2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        Player1.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout Player1Layout = new javax.swing.GroupLayout(Player1);
        Player1.setLayout(Player1Layout);
        Player1Layout.setHorizontalGroup(
            Player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        Player1Layout.setVerticalGroup(
            Player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Player2.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout Player2Layout = new javax.swing.GroupLayout(Player2);
        Player2.setLayout(Player2Layout);
        Player2Layout.setHorizontalGroup(
            Player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        Player2Layout.setVerticalGroup(
            Player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        vidasPlayer2.setText("Vidas");

        vidasPlayer1.setText("Vidas");

        nvidasPlayer1.setText("3");

        nvidasPlayer2.setText("3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vidasPlayer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nvidasPlayer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 693, Short.MAX_VALUE)
                        .addComponent(vidasPlayer2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nvidasPlayer2)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vidasPlayer2)
                    .addComponent(vidasPlayer1)
                    .addComponent(nvidasPlayer1)
                    .addComponent(nvidasPlayer2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        rectareaP1 = Player1.getBounds();
        rectareaP2 = Player2.getBounds();
        
        if(player == 1){ 
            if(rectareaP1.intersects(rectareaP2)){
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                     System.out.println("Player 1 está marcando ponto!");
                // alterar a posicao na minha tela e enviar a posicao para ser alterada na tela do adversário
                move(new Point(0,0));                
                }
            }
            if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                // alterar a posicao na minha tela e enviar a posicao para ser alterada na tela do adversário
                //alterar na minha tela:
                Player1.setLocation(Player1.getX() + 10, Player1.getY());
                //enviar a posicvao ao adversário
                Point nposition = Player1.getLocation();                
                move(nposition);
            }

            else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                //alterar na minha tela:
                Player1.setLocation(Player1.getX() - 10, Player1.getY());
                //enviar a posicvao ao adversário
                 Point nposition = Player1.getLocation();                
                move(nposition);
            }
            else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                //alterar na minha tela:
                Player1.setLocation(Player1.getX(), Player1.getY() - 10);
                //enviar a posicvao ao adversário
                Point nposition = Player1.getLocation();                
                move(nposition);            
            }
            else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                //alterar na minha tela:
                Player1.setLocation(Player1.getX(), Player1.getY() + 10);
                //enviar a posicvao ao adversário
                 Point nposition = Player1.getLocation();                
                move(nposition);
            }            
        }else{
            if(rectareaP2.intersects(rectareaP1)){
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("Player 2 está marcando ponto!");
                // alterar a posicao na minha tela e enviar a posicao para ser alterada na tela do adversário
                move(new Point(0,0));                
                }
            }
            if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                // alterar a posicao na minha tela e enviar a posicao para ser alterada na tela do adversário
                //alterar na minha tela:
                Player2.setLocation(Player2.getX() + 10, Player2.getY());
                //enviar a posicvao ao adversário
                Point nposition = Player2.getLocation();                
                move(nposition);
            }

            else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                //alterar na minha tela:
                Player2.setLocation(Player2.getX() - 10, Player2.getY());
                //enviar a posicvao ao adversário
                 Point nposition = Player2.getLocation();                
                move(nposition);
            }
            else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                //alterar na minha tela:
                Player2.setLocation(Player2.getX(), Player2.getY() - 10);
                //enviar a posicvao ao adversário
                 Point nposition = Player2.getLocation();                
                move(nposition);
            }
            else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                //alterar na minha tela:
                Player2.setLocation(Player2.getX(), Player2.getY() + 10);
                //enviar a posicvao ao adversário
                 Point nposition = Player2.getLocation();                
                move(nposition);
            }            
            
        }
        
        
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Player1;
    private javax.swing.JPanel Player2;
    private javax.swing.JLabel nvidasPlayer1;
    private javax.swing.JLabel nvidasPlayer2;
    private javax.swing.JLabel vidasPlayer1;
    private javax.swing.JLabel vidasPlayer2;
    // End of variables declaration//GEN-END:variables
}
