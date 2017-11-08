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
import supportClasses.databaseType;

/**
 *
 * @author vinicius
 */
public class AddBrandController extends ControllerModel {

    @FXML
    TextField brandTextField;

    public Stage modal;

    public AddBrandController(Connection db) {
        super(db);
    }

    AddBrandController(Connection connection, databaseType dbType) {
        super(connection, dbType);
    }

    public void init(Stage dialog) {
        modal = dialog;
    }

    @FXML
    public void cancel() {
        modal.close();
    }

    public void addBrand(String brandString) {

        switch (this.dbType) {
            case firebird:
                try {
                    Statement st = this.connection.createStatement();
                    st.executeUpdate(
                            "insert into brands (name)"
                            + " VALUES('" + brandString + "' )"
                    );
                    st.close();
                    sendAlert("Brand added with success!", "Brand Added", "A brand have been added!", Alert.AlertType.CONFIRMATION);
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                    return;
                }
                break;

            case postgres:
                try {
                    Statement st = this.connection.createStatement();
                    st.executeUpdate(
                            "insert into brands (name)"
                            + " VALUES('" + brandString + "' )"
                    );
                    st.close();
                    sendAlert("Brand added with success!", "Brand Added", "A brand have been added!", Alert.AlertType.CONFIRMATION);
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                    return;
                }
                break;
        }

    }

    public boolean checkBrandExists(String brandString) {

        switch (this.dbType) {
            case firebird:
                try {
                    Statement st = this.connection.createStatement();
                    ResultSet rs = st.executeQuery(
                            "select id "
                            + " FROM brands "
                            + " WHERE name = '" + brandString + "'"
                            + " limit 1 ");
                    if (rs.next()) {
                        System.out.println("There is already a brand with this name");
                        sendAlert("Error to add a Brand",
                                "Brand exists.",
                                "Brand already Exists! Choose a different brand name!",
                                Alert.AlertType.ERROR);
                        return true;
                    }

                    rs.close();
                    st.close();

                } catch (Exception e) {

                }
                return false;                

            case postgres:
                try {
                    Statement st = this.connection.createStatement();
                    ResultSet rs = st.executeQuery(
                            "select id "
                            + " FROM brands "
                            + " WHERE name = '" + brandString + "'"
                            + " limit 1 ");
                    if (rs.next()) {
                        System.out.println("There is already a brand with this name");
                        sendAlert("Error to add a Brand",
                                "Brand exists.",
                                "Brand already Exists! Choose a different brand name!",
                                Alert.AlertType.ERROR);
                        return true;
                    }

                    rs.close();
                    st.close();

                } catch (Exception e) {

                }
                return false;                
        }

        return false;
    }

    @FXML
    public void checkForm() {
        String brandString = null;
        try {
            brandString = brandTextField.getText();
        } catch (Exception e) {
            sendAlert("Error Adding Brand",
                    "No Brand name", "Choose a Brand name.", Alert.AlertType.ERROR);
            return;
        }

        if (brandTextField.getText().equals("")) {
            sendAlert("Error Adding Brand",
                    "No Brand name", "Fill all the fields! Choose a Brand name.", Alert.AlertType.ERROR);
        } else {
            if (!checkBrandExists(brandString)) {
                addBrand(brandString);
            }
        }
    }

}
