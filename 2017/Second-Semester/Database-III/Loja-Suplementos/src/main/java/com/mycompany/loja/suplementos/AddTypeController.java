/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author vinicius
 */
public class AddTypeController extends ControllerModel {
    
    @FXML
    public TextField  typeTextField;
    
    public Stage modal;    
    
    public AddTypeController(Connection db) {
        super(db);
    }
    
    public void init(Stage dialog) {
        modal = dialog;
    }

    @FXML
    public void cancel() {
        modal.close();
    }

    public void addType(String typeString) {
        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(
                    "insert into types (name)"
                    + " VALUES('" + typeString + "' )"
            );
            st.close();
            sendAlert("Product type added with success!", "Type Added", "A new type have been added!", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return;
        }
    }

    public boolean checkTypeExists(String typeString) {
        
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select id "
                    + " FROM types "
                    + " WHERE name = '" + typeString + "'"
                    + " limit 1 ");
            if (rs.next()) {
                System.out.println("There is already a type with this name");
                sendAlert("Error to add a type",
                        "Type exists.",
                        "Type already Exists! Choose a different Type name!",
                        Alert.AlertType.ERROR);
                return true;
            }

            rs.close();
            st.close();

        } catch (Exception e) {

        }
        return false;
    }

    @FXML
    public void checkForm() {
        System.out.println("começou a verificar o form");
        String typeString = null;
        try {
            typeString = typeTextField.getText();            
        } catch (Exception e) {
            sendAlert("Error Adding new Type",
                    "No Type name", "Choose a product type name.", Alert.AlertType.ERROR);
            return;
        }
        
        if (typeString.equals("")) {
            sendAlert("Error Adding new Type",
                    "No Type name", "Fill all the fields! Choose a product type name.", Alert.AlertType.ERROR);
        } else {
            if (!checkTypeExists(typeString)) {
                addType(typeString);
            }
        }
    }    
}
