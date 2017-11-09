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
import supportClasses.ProductItem;
import supportClasses.databaseType;

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

    public ObservableList<ProductItem> auxdata;

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

    AddSaleItemController(Connection connection, databaseType dbType) {
        super(connection, dbType);
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void cancel(ActionEvent event) {
        dialog.close();
    }

    public void init(Stage modal, Integer id, TableView saletable, ObservableList<ProductItem> listdata,
            AddSaleController asic) {
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
            ResultSet rs = null;
            switch (dbType) {
                case firebird:
                    rs = st.executeQuery(
                            "EXECUTE PROCEDURE get_a_typeby_product('" + findProductComboBox.getValue() + "');"
                    );
                    break;
                case postgres:
                    rs = st.executeQuery(
                            "select * from get_a_typeby_product('" + findProductComboBox.getValue() + "')"
                    );
                    break;
            }
            if (rs.next()) {
                typename = rs.getString("TYPENAME");
            } else {
                System.out.println("ERROR");
            }

            st = this.connection.createStatement();
            switch (dbType) {
                case firebird:
                    rs = st.executeQuery(
                            "EXECUTE PROCEDURE get_a_brandby_product('" + findProductComboBox.getValue() + "');"
                    );
                    break;
                case postgres:
                    rs = st.executeQuery(
                            "select * from get_a_brandby_product('" + findProductComboBox.getValue() + "')"
                    );
                    break;
            }
            if (rs.next()) {
                brandname = rs.getString("BRANDNAME");
            }
        } catch (Exception e) {
            System.out.println("ERROR GETTING TYPES AND BRANDS " + e.getMessage());
            sendAlert(
                    "Error ",
                    "Error retrieving values.",
                    "Error getting type or brand names", Alert.AlertType.ERROR);
        }

        auxdata.add(new ProductItem(itemname, unitvalue, brandname, typename, Quantity, total));
        saleTable.setItems(auxdata);
        asic.calculateSubtotalAndTotal();
    }

    public void getProducts() {
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = null;
            switch (dbType) {
                case firebird:
                    rs = st.executeQuery(
                            "SELECT productname FROM get_products_additem;");
                    break;
                case postgres:
                    rs = st.executeQuery(
                            "select * from get_products();");
                    break;
            }
            while (rs.next()) {
                findProductComboBox.getItems().add(rs.getString("productname"));
            }
        } catch (Exception e) {
            sendAlert("Error",
                    "Error Retreiving Products",
                    "Error on function to get products",
                    Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void getUnitValue() {
        Float valperUnit = null;
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = null;
            switch (dbType) {
                case firebird:
                    rs = st.executeQuery(
                            "EXECUTE PROCEDURE get_itemunitvalue('" + findProductComboBox.getValue() + "');"
                    );
                    if (rs.next()) {
                        valperUnit = rs.getFloat("UNITVALUE");
                    }
                    break;
                case postgres:
                    rs = st.executeQuery(
                            "select * from get_itemunitvalue('" + findProductComboBox.getValue() + "')"
                    );
                    if (rs.next()) {
                        valperUnit = rs.getFloat("get_itemunitvalue");
                    }
                    break;

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
            switch (dbType) {
                case firebird:
                    st.executeUpdate(
                            "EXECUTE PROCEDURE add_saleitem("
                            + "" + saleID + ","
                            + "'" + itemname + "',"
                            + "" + unitValue + "  ,"
                            + "" + Quantity + ", "
                            + "" + totalLabel.getText() + ");"
                    );
                    break;
                case postgres:
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
                    break;
            }

            sendAlert("SaleItem added with success!", "SaleItem Added", "A saleItem has been added!", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage() + e.getLocalizedMessage());
            return;
        }

        addToTable(itemname, Quantity, Float.parseFloat(totalLabel.getText()), unitValue);
    }

    public boolean checkItemAlreadyExists(String itemname) {

        try {
            System.out.println("CUrrent saleid = " + saleID);
            Statement st = this.connection.createStatement();
            ResultSet rs = null;
            switch (dbType) {
                case firebird:
                    st.executeUpdate("EXECUTE PROCEDURE saleItem_exists(" + saleID + ","
                            + "'" + itemname + "');");
                    break;
                case postgres:
                    rs = st.executeQuery(
                            "select * from item_exists(" + saleID + ","
                            + "'" + itemname + "');");
                    rs.next();
                    if (rs.getString("hasitem").equals("t")) {
                        System.out.println("Error to add a item");
                        sendAlert("Duplication error",
                                "Item already added.",
                                "Item already added! Choose a different product!",
                                Alert.AlertType.ERROR);
                        rs.close();
                        return true;
                    }

                    break;
            }
            st.close();

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            sendAlert("Duplication error",
                    "Item already added.",
                    "Item already added! Choose a different product!",
                    Alert.AlertType.ERROR);
            return true;
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
