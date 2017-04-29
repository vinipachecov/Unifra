package aula28abril;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {
    
    public Connection c;
    
    DefaultTableModel model;

   
    public Principal() {
        initComponents();
        model = ((DefaultTableModel)tabelaBanco.getModel());
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonConectar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonInserir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        nomeTextField = new javax.swing.JTextField();
        cargoTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaBanco = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Gerenciamento do Banco de Dados");

        jButtonConectar.setText("Conectar");
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Cargo");

        jLabel4.setText("Email");

        tabelaBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Cargo"
            }
        ));
        jScrollPane1.setViewportView(tabelaBanco);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultar))
                            .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 84, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConectar)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonInserir)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
        conectar();
    }//GEN-LAST:event_jButtonConectarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        inserir();
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
         alterar(4,"Xuxa", "xu@xa.com", "Apresentadora");
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        excluir(4);
    }//GEN-LAST:event_jButtonExcluirActionPerformed

   
    public void conectar() {
      try {
        String url = "jdbc:mysql://localhost:3306/Aula03agenda?user=root&password=";   
        //String url = "localhost:3306/Aula03agenda?user=root&password=root";   
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        System.out.println(url);
        c = (Connection) DriverManager.getConnection(url);
        System.out.println("Conectado!");
       } catch (Exception e){
          System.out.println(e.getMessage());
       }     
    }
    
    public void consultar() {
      String query;
         String id,nome,email,cargo;
         ArrayList<String> valores = new ArrayList<String>();
         try {   
           query = "select * from Funcionario";
           //confirmar/homologar a conexão com o banco de dados
           Statement st = (Statement) c.createStatement();
           //retorno da execução do comando SQL
           ResultSet rs = st.executeQuery(query);    
           if (rs != null) { // Verifica se a query retornou algo
              while (rs.next()) {                 
                 
                  
                  //do it with a while
                  
                  
                 //getting values by its column name
                id = rs.getString("ID");
                nome = rs.getString("nome");
                email = rs.getString("email");
                cargo = rs.getString("cargo");
                valores.add(id);
                valores.add(nome);
                valores.add(email);
                valores.add(cargo);   
                                 
                model.addRow(valores.toArray());
                
                valores.clear();
              }            
           }


//            try {
//            nome = nomeTextField.getText().toString();
//            cidade = cidadeComboBox.getSelectedItem().toString();
//            email = emailTextField.getText().toString();
//            if(SolteiroRadioButton.isSelected() || casadoRadioButton.isSelected()){
//                if(SolteiroRadioButton.isSelected())
//                    estadocivil = "Solteiro";
//                else
//                    estadocivil = "Casado";
//            }
//            else
//                estadocivil= "Nao selecionado";           
//                
//            ArrayList<String> valores = new ArrayList<String>();
//            valores.add(nome);
//            valores.add(email);
//            valores.add(cidade);
//            valores.add(estadocivil);            
//            Cadastro f = new Cadastro(valores);
//            f.guardaCadastro();
        } catch (Exception e) {}
    }
    
    public void inserir() {
         try {
             
            String nome = nomeTextField.getText().toString();
            String email = emailTextField.getText().toString();
            String cargo = cargoTextField.getText().toString();
            
            if(nome.isEmpty() || email.isEmpty() || cargo.isEmpty()){
                throw new Exception("erro loco");
            }
            
            String query = "INSERT INTO Funcionario (nome, email, cargo) "
                    + "values ('" + nome + "', '" + email+  "', '" + cargo + "'" + " )";
            
            /* Inserir valores dinâmicos
            String query = "INSERT INTO Funcionario (nome, email, cargo) "
                  + "values ('"+ nome +"', '"+ email +"', '"+ cargo +"')";  
            */           
            
            Statement st = (Statement) c.createStatement();
            int resultado = st.executeUpdate(query);
            System.out.println(resultado);
         } catch (Exception e) {}   
    }
    
    public void alterar(int id, String nome, String email, String cargo) {
        try {
           String query = "UPDATE Funcionario SET nome='" + nome + "', "
                   + "email='" + email + "', cargo='" + cargo + "'  "
                   + "WHERE id=" + id;
           Statement st = (Statement) c.createStatement();
           int resultado = st.executeUpdate(query);
        } catch (Exception e){}   
    }
    
    public void excluir(int id) {
       try { 
         String query = "DELETE FROM Funcionario WHERE id="+id;
         Statement st = (Statement) c.createStatement();
         int resultado = st.executeUpdate(query);
       } catch (Exception e) {}
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cargoTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTable tabelaBanco;
    // End of variables declaration//GEN-END:variables
}
