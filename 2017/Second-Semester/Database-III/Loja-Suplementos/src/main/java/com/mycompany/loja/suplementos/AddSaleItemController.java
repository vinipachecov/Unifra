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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supportClasses.SaleItem;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class AddSaleItemController extends ControllerModel {

    @FXML
    public Button addUserButton;

    @FXML
    public Button cancelAddUserButton;

    @FXML
    public TextField quantityTextField;

    @FXML
    public TextField unitValueTextField;

    @FXML
    public ComboBox<String> findProductComboBox;

    public ObservableList<SaleItem> auxdata;

    @FXML
    public Label totalLabel;
    
    public Integer saleID;

    public Stage dialog;

    public TableView saleTable;
    
    public Label subtotalAddSaleScreen;
    
    public Label totalAddSaleScreen;
    
    public AddSaleController asic;    

    public AddSaleItemController(Connection connection) {
        super(connection);

    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void cancel(ActionEvent event) {
        dialog.close();
    }

    public void init(Stage modal, Integer id, TableView saletable, ObservableList<SaleItem> listdata,
            AddSaleController asic ) {
        this.asic = asic;
        this.subtotalAddSaleScreen = subtotalAddSaleScreen;
        this.totalAddSaleScreen = totalAddSaleScreen;
        this.auxdata = listdata;
        saleTable = saletable;
        dialog = modal;
        this.saleID = id;
        getProducts();
    }
    
    

    @FXML
    public void recalculateTotal(ActionEvent event) {
        Float quantity = Float.parseFloat(quantityTextField.getText());
        Float unitvalue = Float.parseFloat(unitValueTextField.getText());
        Float total = quantity * unitvalue;
        totalLabel.setText(total.toString());
    }

    public void addToTable(String itemname, Integer Quantity, Float total, Float unitvalue) {

        String brandname = "";
        String typename = "";
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from get_a_typeby_product('" + findProductComboBox.getValue() + "')"
            );
            if (rs.next()) {
                typename = rs.getString("typename");
            } else {
                System.out.println("ERROR");
            }

            st = this.connection.createStatement();
            rs = st.executeQuery(
                    "select * from get_a_brandby_product('" + findProductComboBox.getValue() + "')"
            );
            if (rs.next()) {
                brandname = rs.getString("brandname");
            }
        } catch (Exception e) {
        }

        
        auxdata.add(new SaleItem(itemname, unitvalue, brandname, typename, Quantity, total));
        saleTable.setItems(auxdata);
        asic.calculateSubtotalAndTotal();
    }

    public void getProducts() {
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from get_products();");
            while (rs.next()) {
                findProductComboBox.getItems().add(rs.getString("productname"));
            }
        } catch (Exception e) {
        }

    }

    @FXML
    private void getUnitValue(ActionEvent event) {
        Float valperUnit = null;
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from get_itemunitvalue('" + findProductComboBox.getValue() + "')"
            );
            if (rs.next()) {
                valperUnit = rs.getFloat("get_itemunitvalue");
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return;
        }
        quantityTextField.setText("1");
        unitValueTextField.setText(valperUnit.toString());
        calculateTotal();
    }

    public void calculateTotal() {
        Float valperunit = Float.parseFloat(unitValueTextField.getText());
        Float quantity = Float.parseFloat(quantityTextField.getText());
        Float total = valperunit * quantity;
        totalLabel.setText(total.toString());
    }

    public void addItem(String itemname, Integer Quantity, Float unitValue) {

        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(
                    "DO $$ BEGIN\n"
                    + "    PERFORM add_saleitem("
                    + "" + saleID + ","
                    + "'" + itemname + "',"
                    + "" + unitValue + "  ,"
                    + "" + Quantity + ", "
                    + "" + totalLabel.getText() + ");\n"
                    + "END $$;"
            );
            sendAlert("SaleItem added with success!", "SaleItem Added", "A saleItem has been added!", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage() + e.getLocalizedMessage());
            return;
        }

        addToTable(itemname, Quantity, Float.parseFloat(totalLabel.getText()), unitValue);
    }

    public boolean checkItemAlreadyExists(String itemname) {

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from item_exists(" + saleID + ","
                    + "'" + itemname + "');");
            rs.next();
            if (rs.getString("hasitem").equals("t")) {
                System.out.println("Error to add a item");
                sendAlert("Duplication error",
                        "Item already added.",
                        "Item already added! Choose a different product!",
                        Alert.AlertType.ERROR);
                return true;
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error on checkfunciont additemsale! :" + e.getMessage());
        }

        return false;
    }

    @FXML
    public void checkForm() {

        String itemname = findProductComboBox.getValue();
        Integer quantity = Integer.parseInt(quantityTextField.getText());
        Float unitvalue = Float.parseFloat(unitValueTextField.getText());

        if (itemname.equals("") || quantity.equals("")
                || unitvalue.equals("")) {
            sendAlert("Error to add an Item",
                    "Form Error",
                    "Fill all the fields", Alert.AlertType.ERROR);
        } else {
            if (!checkItemAlreadyExists(findProductComboBox.getValue())) {
                addItem(itemname, quantity, unitvalue);
            }
        }
    }
}
