/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import supportClasses.Brand;
import supportClasses.Type;

/**
 *
 * @author vinicius
 */
public class SearchTypeController extends ControllerModel {

    @FXML
    public TextField typeSearchTextField;

    @FXML
    public TableColumn<Type, Integer> idColumn;

    @FXML
    public TableColumn<Type, String> nameColumn;

    @FXML
    public javafx.scene.control.TableView<Type> typeTable;

    public ObservableList<Type> data;

    public Stage dialog;

    public SearchTypeController(Connection db) {
        super(db);
    }

    public void init(Stage modal) {

        dialog = modal;

        data = FXCollections.observableArrayList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Type, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Type, String>("name"));

        typeTable.setItems(data);

    }

    @FXML
    public void Search(ActionEvent event) {

        data.clear();

        String typeSearchString = null;
        try {
            typeSearchString = typeSearchTextField.getText();
        } catch (Exception e) {

        }

        if (typeSearchString == null) {
            sendAlert("Error finding Type",
                    "No Type name to search.", "Pick a type name to search.", Alert.AlertType.ERROR);
        }

        // if no type name, find all
        if (typeSearchString.equals("")) {
            try {
                Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(
                        "select * "
                        + " FROM types "
                        + " limit 50"
                );
                while (rs.next()) {
                    data.add(new Type(rs.getInt("id"), rs.getString("name")));
                }
                rs.close();
                st.close();

            } catch (Exception e) {

            }

        } // find a specific type name
        else {
            try {
                Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(
                        "select * "
                        + " FROM types "
                        + " WHERE name = '" + typeSearchString + "'"
                );
                while (rs.next()) {
                    data.add(new Type(rs.getInt("id"), rs.getString("name")));
                }
                rs.close();
                st.close();
            } catch (Exception e) {

            }
        }
        // set items        
        typeTable.setItems(data);
    }

}