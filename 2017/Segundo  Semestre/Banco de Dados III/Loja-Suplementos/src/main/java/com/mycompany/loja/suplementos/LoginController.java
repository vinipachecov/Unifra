package com.mycompany.loja.suplementos;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    
    private TextField usernameTextField;
    private PasswordField passwordField;    
    @FXML
    private Button loginButton;
    
    
    private Connection connection; 
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        
    
    
    public void connectDBPostgre() {
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

		connection = null;

		try {
                    connection = DriverManager.getConnection(
                        "jdbc:postgresql://127.0.0.1:5432/loja-suplemento", "postgres",
                        "123456");

		} catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;
		}

		if (connection != null) {
                    System.out.println("Connection to Postgres Succeded!");
		} else {
                    System.out.println("Failed to make connection!");
		}
                checkLoginPostgres(usernameTextField.getText().toString(), passwordField.getText());
                
    }
    
    public boolean checkLoginPostgres(String username, String password) {
        System.out.println("Fazendo login");        
        try {
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select exists( "
                    + " select 1 from usuario u "
                    + "where u.username = '" +username+"'"
                            + " and u.senha = '"+ password+"')");                                    
            
            while (rs.next()) {                
                if(rs.getString("exists").equals("t")) {
                    System.out.println("Logando usuario admin");
                    
                                                        
                }
                else                    
                    return false;                
            }
            rs.close();
            st.close();
        }
        catch (Exception e) {
            
        }        
        return false;
    }
   
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        stage=(Stage) loginButton.getScene().getWindow();
           //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("/fxml/principal.fxml"));
        
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
   
}
