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
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class AddProductController extends ControllerModel {

    @FXML
    public Button addUserButton;

    @FXML
    public Button cancelAddUserButton;

    @FXML
    public TextField nameTextField;

    @FXML
    public TextField minimumQuantityTextField;

    @FXML
    public TextField currentQuantityTextField;

    @FXML
    public TextField unitValueTextField;

    @FXML
    public TextField unitTextField;

    @FXML
    public ComboBox<String> typeComboBox;

    @FXML
    public ComboBox<String> brandComboBox;

    public Stage dialog;
    
    public ArrayList<String> brandsList;
    public ArrayList<String> typesList;    
    
    public AddProductController(Connection connection) {
        super(connection);

    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void cancel(ActionEvent event) {
        dialog.close();
    }

    public void getBrands() {
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("Select name from get_brands()");
            while (rs.next()) {               
                brandComboBox.getItems().add(rs.getString("name"));
            }
        } catch (Exception e) {
        }
    }

    public void getTypes() {
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("Select name from get_types()");
            while (rs.next()) {                
                typeComboBox.getItems().add(rs.getString("name"));
            }
        } catch (Exception e) {
        }

    }

    public void init(Stage modal) {        
        brandComboBox.getItems().removeAll(brandComboBox.getItems());
        getBrands();
        getTypes();
        dialog = modal;
    }

    public void addProduct(String name, String brandname, String typename,
            Integer minimumQ, Integer currentQ, Float unitvalue, String unittype) {   
        try {
            Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(
                "DO $$ BEGIN\n" +
            "    PERFORM add_product("
                        + "'" + name +"',"
                        + "'" + brandname + "',"
                        + "'" + typename + "', " +minimumQ + ","
                        + "" + currentQ + "," + unitvalue + ","
                                + "'" + unittype + "');\n" +
                        
            "END $$;"
        );
        st.close();
        } catch (Exception e) {
        }        
        sendAlert("Product Added!",
                "Success!", 
                "Success adding a product!",
                Alert.AlertType.CONFIRMATION);
    }

    public boolean productAlreadyExists(String productname) {

        
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("select hasproduct from product_exists('" + productname + "')");
            rs.next();            
            if (rs.getString("hasproduct").equals("t")) {
                sendAlert("Error to add a Product",
                        "Product exists.",
                        "Product already Exists! Choose a different product name!",
                        Alert.AlertType.ERROR);
                return true;
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error product already exists! :" + e.getMessage());
        }

        return false;
    }

    @FXML
    public void checkForm() {        
        String name = nameTextField.getText();
        String brandname = brandComboBox.getValue();
        String typename = typeComboBox.getValue();
        Integer minimumQ = Integer.parseInt(minimumQuantityTextField.getText());
        Integer currentQ = Integer.parseInt(currentQuantityTextField.getText());
        Float unitvalue = Float.parseFloat(unitValueTextField.getText());
        String unittype = unitTextField.getText();
        

        if (name.equals("") && brandname.equals("") || typename.equals("") ||
                minimumQ.equals(null) || currentQ.equals(null) || 
                unitvalue.equals(null) || unittype.equals("")) {
            sendAlert("Error to add a Product",
                    "Form Error",
                    "Fill all the fields", Alert.AlertType.ERROR);
        } else {
            if (!productAlreadyExists(name)) {
                addProduct(name, brandname, typename, minimumQ, currentQ, unitvalue, unittype);
            }
        }
    }
}
