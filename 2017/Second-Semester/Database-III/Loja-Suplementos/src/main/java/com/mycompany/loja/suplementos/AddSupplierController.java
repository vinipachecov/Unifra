/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author vinicius
 */
public class AddSupplierController extends ControllerModel {

    public Stage dialog;

    @FXML
    public TextField socialReasonTextField;

    @FXML
    public TextField emailTextField;

    @FXML
    public TextField cnpjTextField;

    @FXML
    public TextField telephoneTextField;

    @FXML
    public TextField fantasynameTextField;

    public AddSupplierController(Connection db) {
        super(db);
    }

    public void init(Stage modal) {
        dialog = modal;
    }

    @FXML
    public void cancel() {
        dialog.close();
    }

    public void addSupplier(String socialrtf, String emailString,
            String cnpj, String telephone, String fantasyname) {

        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(""
                    + "insert into suppliers(socialreason, email, cnpj, telephone, fantasyname, numberpurchases)\n"
                    + "values('" + socialrtf + "', '" + emailString + "' ,"
                            + "'" + cnpj + "','" + telephone + " ', '" +fantasyname + "', 0)");
            st.close();
        } catch (Exception e) {

        }
        sendAlert("Success", "Supplier Added!", "Supplier Added with Success.", Alert.AlertType.CONFIRMATION);
    }

    public boolean checkSupplierAlreadyExists(String socialrtf, String emailString,
            String cnpj, String telephone, String fantasyname) {

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select *  "
                    + " FROM suppliers "
                    + " where socialreason = '" + socialrtf + "'"
                    + " AND email = '" + emailString + "'"
                    + " AND cnpj= '" + cnpj + "'"
                    + " AND telephone= '" + telephone + "'"
                    + " AND fantasyname= '" + fantasyname + "'"
                    + " limit 1"
            );
            if (rs.next()) {
                sendAlert("Error",
                        "Supplier already exists!",
                        "Supplier already exists with those values",
                        Alert.AlertType.ERROR);
                return true;
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error = " + e.getMessage());

        }

        return false;
    }

    @FXML
    public void checkForm() {
        String socialrtf = null;
        String emailString = null;
        String cnpj = null;
        String telephone = null;
        String fantasyname = null;

        try {
            socialrtf = socialReasonTextField.getText();
            emailString = emailTextField.getText();
            cnpj = cnpjTextField.getText();
            telephone = telephoneTextField.getText();
            fantasyname = fantasynameTextField.getText();

        } catch (Exception e) {
        }

        if (socialrtf.equals("") || emailString.equals("") || cnpj.equals("")
                || telephone.equals("") || fantasyname.equals("")) {
            sendAlert("Error Adding Supplier",
                    "FOrm Error",
                    "Fill all the fields!",
                    Alert.AlertType.ERROR);
            return;
        }
        if (!checkSupplierAlreadyExists(socialrtf, emailString, cnpj, telephone, fantasyname)) {
                addSupplier(socialrtf, emailString, cnpj, telephone, fantasyname);
        }

    }

}
