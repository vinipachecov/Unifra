package dbtablehandler;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {
    
    String password;
    String dbname;
    public Connection c;
    
    LoginDatabase login;
    
    DefaultTableModel model;

   
    public Principal() {
        initComponents();
        model = ((DefaultTableModel)tabelaBanco.getModel());
        
    }
    
    
    //Example of input Dialog for login ************************
    
//    
//    public Hashtable<String, String> login(JFrame frame) {
//    Hashtable<String, String> logininformation = new Hashtable<String, String>();
//
//    JPanel panel = new JPanel(new BorderLayout(5, 5));
//
//    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
//    label.add(new JLabel("E-Mail", SwingConstants.RIGHT));
//    label.add(new JLabel("Password", SwingConstants.RIGHT));
//    panel.add(label, BorderLayout.WEST);
//
//    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
//    JTextField username = new JTextField();
//    controls.add(username);
//    JPasswordField password = new JPasswordField();
//    controls.add(password);
//    panel.add(controls, BorderLayout.CENTER);
//
//    JOptionPane.showMessageDialog(frame, panel, "login", JOptionPane.QUESTION_MESSAGE);
//
//    logininformation.put("user", username.getText());
//    logininformation.put("pass", new String(password.getPassword()));
//    return logininformation;
//}

   
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
        jLabel5 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();

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

        jLabel5.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(0, 78, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
         alterar(Integer.parseInt(idTextField.getText()) ,nomeTextField.getText(), emailTextField.getText(), cargoTextField.getText());
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        excluir(Integer.parseInt(idTextField.getText()));
    }//GEN-LAST:event_jButtonExcluirActionPerformed

   
    public void conectar() {
        JPasswordField pf = new JPasswordField();      
        //password = JOptionPane.showInputDialog(this,"Digite o Password do Banco");       
                
        //Criar um LoginDatabase E pegar resultado
        
        try {
            login = new LoginDatabase(this);        
            password = login.getPassword();
            dbname = login.getDatabaseName();
            
        }catch (NullPointerException e){
            
        }
        
        
        
        
        String url = "jdbc:mysql://localhost:5432/postgres?user="+dbname+"&password="+password;   
        System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		
		try {                   

			c = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}
                
		if (c != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
    }
    
    public void consultar() {
        System.out.println("CONSULTANDO");
        String query;
        //Few values
        String id,nome,email,cargo;
        //lots of values
        String column;        
        int columnCount;
        updateTable();
        ArrayList<String> valores = new ArrayList<String>();
        System.out.println("COMEÇANDO");
        try {   
             
           query = "SELECT * FROM actor";
            System.out.println("nossa query = " + query);
           //confirmar/homologar a conexão com o banco de dados
           Statement st = c.createStatement();           
            System.out.println("nosso statement " + st);
           //retorno da execução do comando SQL
           ResultSet rs = st.executeQuery(query);   
            System.out.println(rs);
           //get properties of the table ( columns etc..)
           ResultSetMetaData rsmd = rs.getMetaData();           
           columnCount = rsmd.getColumnCount();     
            System.out.println("column numbers" + columnCount);
            
           
           if (rs != null) {
               System.out.println("retornou algo");// Verifica se a query retornou algo
              while (rs.next()) {
                  System.out.println("1");
                  //do it with a while for plenty of values
                  for (int i = 1; i <= columnCount; i++) {
                      System.out.println(rs.getString(i));
                      valores.add(rs.getString(i));                       
                  }                  
                                     
                 //getting values by its column name
//                id = rs.getString("ID");
//                nome = rs.getString("nome");
//                email = rs.getString("email");
//                cargo = rs.getString("cargo");
//                valores.add(id);
//                valores.add(nome);
//                valores.add(email);
//                valores.add(cargo);   
                                 
                model.addRow(valores.toArray());
                
                valores.clear();
              }            
           }
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
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
            consultar();
         } catch (Exception e) {}   
    }
    
    public void alterar(int id, String nome, String email, String cargo) {
        try {            
           String query = "UPDATE Funcionario SET nome='" + nomeTextField.getText() + "', "
                   + "email='" + emailTextField.getText() + "', cargo='" + cargoTextField.getText() + "'  "
                   + "WHERE id=" + idTextField.getText();
           Statement st = (Statement) c.createStatement();
           int resultado = st.executeUpdate(query);
           consultar();
        } catch (Exception e){}   
    }
    
    public void excluir(int id) {
       try { 
         String query = "DELETE FROM Funcionario WHERE id="+id;
         Statement st = (Statement) c.createStatement();
         int resultado = st.executeUpdate(query);
         consultar();
       } catch (Exception e) {}
    }
    
    
    public void updateTable(){
        //for defaultTableModel
        model.setRowCount(0);
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
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTable tabelaBanco;
    // End of variables declaration//GEN-END:variables
}
