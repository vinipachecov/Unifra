/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10marco;

import javax.swing.JOptionPane;
import sun.awt.X11.XConstants;

/**
 *
 * @author root
 */
public class View extends javax.swing.JFrame {
    String estadocbx1 = "";
    String estadocbx2 = "";
    
    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        resLabel.setText("");
        buttonGroup1.add(jRadioMasculino);
        buttonGroup1.add(jRadioFeminino);
        
        for (int i = 0; i < 10; i++) {
            jcomboBox.addItem("Olar" + i);            
        }
        
        //jcomboBox.setSelectedIndex(-1);
        // Setar para garantir pois nem sempre a jvm vai rodar do mesmo jeito
        // em SO's diferentes ou até em jvms diferentes
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        caixaSelecao2 = new javax.swing.JCheckBox();
        caixaSelecao1 = new javax.swing.JCheckBox();
        botaoRes = new javax.swing.JButton();
        resLabel = new javax.swing.JLabel();
        jRadioMasculino = new javax.swing.JRadioButton();
        jRadioFeminino = new javax.swing.JRadioButton();
        jRadioSolteiro = new javax.swing.JRadioButton();
        jRadioCasado = new javax.swing.JRadioButton();
        jcomboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        caixaSelecao2.setText("Caixa Seleção 2");
        caixaSelecao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaSelecao2ActionPerformed(evt);
            }
        });

        caixaSelecao1.setText("Caixa Seleção 1");
        caixaSelecao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaSelecao1ActionPerformed(evt);
            }
        });

        botaoRes.setText("Botao Locaço");
        botaoRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoResActionPerformed(evt);
            }
        });

        resLabel.setText("BotaoResultado");

        jRadioMasculino.setText("Masculino");

        jRadioFeminino.setText("Feminino");

        jRadioSolteiro.setText("Solteiro");

        jRadioCasado.setText("Casado");

        jcomboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Santa Maria", "Porto Alegre", "Passo Fundo", "Capão da Canoa" }));
        jcomboBox.setSelectedIndex(-1);
        jcomboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(caixaSelecao1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioMasculino)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botaoRes)
                                        .addGap(80, 80, 80)
                                        .addComponent(resLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(caixaSelecao2)
                                        .addGap(277, 277, 277)
                                        .addComponent(jRadioFeminino)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioSolteiro)
                            .addComponent(jRadioCasado))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaSelecao1)
                    .addComponent(jRadioMasculino)
                    .addComponent(jRadioSolteiro))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(caixaSelecao2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioFeminino)
                            .addComponent(jRadioCasado))))
                .addGap(31, 31, 31)
                .addComponent(jcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoRes)
                    .addComponent(resLabel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caixaSelecao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaSelecao2ActionPerformed
        if(caixaSelecao2.isSelected())
            estadocbx2 = "Selecionado";
        else
            estadocbx2 = "";
        
    }//GEN-LAST:event_caixaSelecao2ActionPerformed

    private void caixaSelecao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaSelecao1ActionPerformed
        if(caixaSelecao1.isSelected())
            estadocbx1 = "Selecionado";
        else
            estadocbx1 = "";
    }//GEN-LAST:event_caixaSelecao1ActionPerformed

    private void botaoResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoResActionPerformed
               
//        if(caixaSelecao1.isSelected() && !caixaSelecao2.isSelected())
//            resLabel.setText("Foi selecionado apenas a caixa 1");
//        if(!caixaSelecao1.isSelected() && caixaSelecao2.isSelected())
//            resLabel.setText("Foi selecionado apenas a caixa 2");
//        if(caixaSelecao1.isSelected() && caixaSelecao2.isSelected())
//            resLabel.setText("Foram selecionados amboas caixas de Selecao");
//        if(!caixaSelecao1.isSelected() && !caixaSelecao2.isSelected())
//            resLabel.setText("Nenhuma Caixa Selecionada");   
        try {
            resLabel.setText(jcomboBox.getSelectedItem().toString());            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Escolha uma opção válida "
                    + "no Dropdown");
        }
        
        
    }//GEN-LAST:event_botaoResActionPerformed

    private void jcomboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboBoxActionPerformed

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
    private javax.swing.JButton botaoRes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox caixaSelecao1;
    private javax.swing.JCheckBox caixaSelecao2;
    private javax.swing.JRadioButton jRadioCasado;
    private javax.swing.JRadioButton jRadioFeminino;
    private javax.swing.JRadioButton jRadioMasculino;
    private javax.swing.JRadioButton jRadioSolteiro;
    private javax.swing.JComboBox<String> jcomboBox;
    private javax.swing.JLabel resLabel;
    // End of variables declaration//GEN-END:variables
}