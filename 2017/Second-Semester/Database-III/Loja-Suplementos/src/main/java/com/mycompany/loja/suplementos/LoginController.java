package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supportClasses.User;
import supportClasses.userType;

public class LoginController extends ControllerModel {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    public LoginController(Connection db) {
        super(db);
    }

    @FXML
    public void connectDBPostgre(ActionEvent event) {
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
        checkLoginPostgres(event, usernameTextField.getText().toString(), passwordField.getText().toString());

    }

    public boolean checkLoginPostgres(ActionEvent event, String username, String password) {
        System.out.println("Signing in...");
        try {
            // Find user
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * "
                    + " FROM users "
                    + " WHERE username = '" + username + "'"
                    + " AND password = '" + password + "'"
                    + " limit 1");
            // found a user                 
            if (rs.next()) {
                User current = new User(username,
                        userType.ParseUserType(rs.getString("usertype").toString())
                );
                Stage stage;
                PrincipalController controller = new PrincipalController(this.connection, current);
                stage = ChangeScreen(loginButton, "/fxml/MainScreen.fxml", controller);
                controller.init(stage);
            } else {
                sendAlert("Erro de Login",
                        "Erro ao efetuar Login",
                        "Usuário ou senha incorretos",
                        Alert.AlertType.ERROR);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            sendAlert("Erro de Login",
                    "Erro na função de login!",
                    e.getMessage(),
                    Alert.AlertType.ERROR);
            System.out.println(e.getMessage());
        }
        return false;
    }

}
