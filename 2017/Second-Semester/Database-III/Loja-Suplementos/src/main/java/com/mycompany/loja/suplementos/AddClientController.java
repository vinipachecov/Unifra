 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author vinicius
 */
public class AddClientController extends ControllerModel {

    public Stage modal;

    @FXML
    public TextField NameTextField;

    @FXML
    public TextField emailTextField;

    @FXML
    public TextField telephoneTextField;

    @FXML
    public TextField govidTextField;

    @FXML
    public DatePicker birthdatePicker;

    public AddClientController(Connection db) {
        super(db);
    }

    public void init(Stage dialog) {
        modal = dialog;
        birthdatePicker.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null) {
                    return "";
                }
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
    }

    @FXML
    public void cancel() {
        modal.close();
    }

    public void addClient(String name, String email,
            String telephone, String govid, LocalDate date) {

        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(""
                    + "insert into clients(name,numsales,email,telephone,govid,birthdate) \n"
                    + "values('" + name + "',0,'" + email + "','" + telephone + "','" + govid + "','" + date + "')");
            st.close();
        } catch (Exception e) {

        }
        sendAlert("Success", "Client Added!", "Client Added with Success.", Alert.AlertType.CONFIRMATION);
    }

    public boolean checkClientAlreadyExists(String name, String email,
            String telephone, String govid, LocalDate date) {

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select *  "
                    + " FROM clients "
                    + " where name = '" + name + "'"
                    + " AND email = '" + email + "'"
                    + " AND govid = '" + govid + "'"
                    + " limit 1"
            );
            if (rs.next()) {
                sendAlert("Error",
                        "Client already exists!",
                        "User already exists with those values",
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
        // check if the user has filled the fields, trying to get all 
        String name = null;
        String email = null;
        String telephone = null;
        String govid = null;
        LocalDate date = null;

        try {
            name = NameTextField.getText();
            email = emailTextField.getText();
            telephone = telephoneTextField.getText();
            govid = govidTextField.getText();
            date = birthdatePicker.getValue();

        } catch (Exception e) {
            sendAlert("Form Error", "Error adding a client", "Error on getting values", Alert.AlertType.ERROR);
        }

        if (name.equals("") || email.equals("") || telephone.equals("")
                || govid.equals("") || date.equals(null) || date.equals("")) {
            sendAlert("Error", "Form Error", "Fill all the fields!", Alert.AlertType.ERROR);
        } else {
            System.out.println("Vai verificar se tem dados iguais");
            if (!checkClientAlreadyExists(name, email, telephone, govid, date)) {
                addClient(name, email, telephone, govid, date);
            }
        }

    }

}
