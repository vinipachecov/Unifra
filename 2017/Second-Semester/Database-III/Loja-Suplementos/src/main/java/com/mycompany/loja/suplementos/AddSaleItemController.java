/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import org.bson.Document;
import org.bson.types.ObjectId;
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

    public BasicDBObject currentSale;

    public AddSaleItemController(Connection connection) {
        super(connection);

    }

    AddSaleItemController(Connection connection, databaseType dbType) {
        super(connection, dbType);
    }

    AddSaleItemController(MongoDatabase mongoDatabase, databaseType dbType) {
        super(mongoDatabase, dbType);
    }

    AddSaleItemController(MongoDatabase mongoDatabase, BasicDBObject currentSale, databaseType dbType) {
        super(mongoDatabase, dbType);
        this.currentSale = currentSale;
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

    public void init(Stage modal, TableView saletable, ObservableList<ProductItem> listdata,
            AddSaleController asic) {
        this.asic = asic;
        this.subtotalAddSaleScreen = subtotalAddSaleScreen;
        this.totalAddSaleScreen = totalAddSaleScreen;
        this.auxdata = listdata;
        saleTable = saletable;
        dialog = modal;
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
                case mongodb:
                    
                    
                    break;
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
            Statement st = null;
            switch (dbType) {
                case mongodb:
                    break;
                case firebird:
                    st = this.connection.createStatement();
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
                    st = this.connection.createStatement();
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

            switch (dbType) {
                case mongodb:
                    MongoCollection<Document> sales = mongoDatabase.getCollection("sales");

                    BasicDBList saleitems = (BasicDBList) currentSale.get("saleitems");

                    System.out.println("TOTAL DE ITEMS = " + saleitems.toArray().toString());
                    if (saleitems.size() != 0) {
                        for (Object saleitem : saleitems) {
                            BasicDBObject aux = (BasicDBObject) saleitem;
                            if(aux.getString(itemname).equals(saleitem)){
                                return true;
                            }
                        }
                    } else {
                        System.out.println("VAZIO VAI ADICIONAR");
                        return false;
                    }
                    
                    // KEEP GOING
                    try {
                        List<Document> documents = sales.find().into(new ArrayList<Document>());
                        for (Document document : documents) {

                        }
                    } catch (Exception e) {
                        System.out.println(dbType + " error " + ": " + e.getMessage());
                    }
                    break;
                case firebird:
                    Statement st1 = this.connection.createStatement();
                    ResultSet rs = null;
                    st1.executeUpdate("EXECUTE PROCEDURE saleItem_exists(" + saleID + ","
                            + "'" + itemname + "');");
                    st1.close();
                    break;
                case postgres:
                    Statement st2 = this.connection.createStatement();
                    rs = st2.executeQuery(
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
                    st2.close();
                    break;
            }

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
                //addItem(itemname, quantity, unitvalue);
            }
        }
    }
}
