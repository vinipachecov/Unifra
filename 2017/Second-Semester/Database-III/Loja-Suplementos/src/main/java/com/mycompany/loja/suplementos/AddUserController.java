/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supportClasses.User;
import supportClasses.userType;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class AddUserController extends ControllerModel {

    @FXML
    public Button addUserButton;

    @FXML
    public Button cancelAddUserButton;

    @FXML
    public TextField usernameTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public ComboBox<userType> userTypeComboBox;
    
    public Stage dialog;

    public AddUserController(Connection connection, User current) {
        super(connection, current);
        
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void Cancel(ActionEvent event) {
        dialog.close();
    }

    public void init(Stage modal) {
        userTypeComboBox.getItems().removeAll(userTypeComboBox.getItems());
        userTypeComboBox.getItems().addAll(userType.admin, userType.salesman);
        dialog = modal;
    }

    public void addUser() {        
        String usertype;
        // Get usertype
        try {

            usertype = userTypeComboBox.getSelectionModel().getSelectedItem().toString();
        } catch (Exception e) {
            sendAlert("Error to add a User", "Form error", "Choose a UserType!", Alert.AlertType.ERROR);
            return;
        }

        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(
                    "insert into users (username,password,usertype)"
                    + " VALUES('" + usernameTextField.getText() + "', '" + passwordField.getText() + "' , '" + usertype + "' )"
            );            
            st.close();
            sendAlert("User added with success!", "User Added", "An user have been added!", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return;
        }               
    }

    public boolean userAlreadyExists() {

        System.out.println("testando se tem usuario igual");
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select id "
                    + " FROM users "
                    + " WHERE username = '" + usernameTextField.getText() + "'"
                    + " limit 1 ");
            if (rs.next()) {
                System.out.println("já tem usuario assim");
                sendAlert("Error to add a User",
                        "User exists.",
                        "User already Exists! Choose a different username!",
                        Alert.AlertType.ERROR);
                return true;
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error user already exists! :" + e.getMessage());
        }

        return false;
    }

    @FXML
    public void checkForm() {
        System.out.println("Começando a adicionar");

        if (usernameTextField.getText().equals("") || passwordField.getText().equals("")) {
            sendAlert("Error to add a User",
                    "Form Error",
                    "Fill all the fields", Alert.AlertType.ERROR);
        } else {
            if (!userAlreadyExists()) {
                addUser();
            }

        }
    }
}
