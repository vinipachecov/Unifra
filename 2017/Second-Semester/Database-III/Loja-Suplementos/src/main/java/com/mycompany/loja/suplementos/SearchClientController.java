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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import supportClasses.Client;

/**
 *
 * @author vinicius
 */
public class SearchClientController extends ControllerModel {

    @FXML
    public TextField clientSearchTextField;

    @FXML
    public TableColumn<Client, Integer> idColumn;

    @FXML
    public TableColumn<Client, String> nameColumn;

    @FXML
    public TableColumn<Client, Integer> numsalesColumn;

    @FXML
    public TableColumn<Client, String> emailColumn;

    @FXML
    public TableColumn<Client, String> telephoneColumn;

    @FXML
    public TableColumn<Client, String> govidColumn;

    @FXML
    public TableColumn<Client, LocalDate> birthdateColumn;

    @FXML
    public javafx.scene.control.TableView<Client> clientTable;

    public ObservableList<Client> data;

    public Stage dialog;

    public SearchClientController(Connection db) {
        super(db);
    }

    public void init(Stage modal) {

        dialog = modal;

        data = FXCollections.observableArrayList();

        
        // the property name between "" has to be the same name of the attribute on the class
        nameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        numsalesColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numsales"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("telephone"));
        govidColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("govid"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("birthdate"));

        clientTable.setItems(data);

    }

    public void addToCLientList(String name, Integer numsales, 
            String email, String telephone, String govid, LocalDate birthdate) {
        data.add(
                new Client(name, numsales, email, telephone, govid, birthdate)                                                              
        );
    }

    @FXML
    public void Search(ActionEvent event) {

        data.clear();
        String clientSearchString = null;
        try {
            clientSearchString = clientSearchTextField.getText();
        } catch (Exception e) {

        }

        if (clientSearchString == null) {
            sendAlert("Error finding Brand",
                    "No Brand name to search.", 
                    "Pick a brand name to search.", 
                    Alert.AlertType.ERROR);
        }

        // if no brand name find all
        if (clientSearchString.equals("")) {
            try {
                Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(
                        "select * "
                        + " FROM clients "
                        + " limit 50"
                );
                while (rs.next()) {
                    addToCLientList(
                            rs.getString("name"),
                            rs.getInt("numsales"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("govid"),
                            (rs.getDate("birthdate").toLocalDate()));                    
                }
                rs.close();
                st.close();

            } catch (Exception e) {

            }

        } // find a specific client name
        else {
            try {
                Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(
                        "select * "
                        + " FROM clients"
                        + " WHERE name = '" + clientSearchString + "'"
                );
                if (rs.next()) {
                    addToCLientList(
                            rs.getString("name"),
                            rs.getInt("numsales"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("govid"),
                            (rs.getDate("birthdate").toLocalDate()));   
                } else {
                    sendAlert(
                            "No results!",
                            "Search lead to 0 results. Try a different Client Name",
                            "No Client with this name",
                            Alert.AlertType.INFORMATION);
                    return;
                }
                while (rs.next()) {
                    addToCLientList(
                            rs.getString("name"),
                            rs.getInt("numsales"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("govid"),
                            (rs.getDate("birthdate").toLocalDate()));   
                }
                rs.close();
                st.close();
            } catch (Exception e) {

            }
        }
        // set items        
        clientTable.setItems(data);

    }

}
