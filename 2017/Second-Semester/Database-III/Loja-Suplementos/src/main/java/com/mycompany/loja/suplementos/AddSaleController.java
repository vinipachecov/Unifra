/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import supportClasses.Product;
import supportClasses.SaleItem;

/**
 *
 * @author vinicius
 */
public class AddSaleController extends ControllerModel {
    
    @FXML
    public Button addItemButton;
    
    @FXML
    public Button backButton;

    @FXML
    public TextField discountTextField;

    
    @FXML
    public TableColumn<SaleItem, String> productNameColumn;

    @FXML
    public TableColumn<SaleItem, String> productBrandColumn;

    @FXML
    public TableColumn<SaleItem, String> productTypeColumn;

    @FXML
    public TableColumn<SaleItem, Float> totalProductPriceColumn;
    @FXML
    public TableColumn<SaleItem, Integer> productQuantityColumn;

    @FXML
    public ComboBox<String> clientComboBox;

    @FXML
    public Label subtotalLabel;

    @FXML
    public Label totalLabel;

    @FXML
    public javafx.scene.control.TableView<Product> saleTable;

    public ObservableList<Product> data;

    public Stage dialog;
    public Stage dialogAddItem;

    public boolean saleCreated = false;
    
    public ImageView imageView;
    
    private PrincipalController pc;
    
    private Integer saleId;

    public AddSaleController(Connection db) {
        super(db);
    }

    public void init(Stage modal, PrincipalController princpController) {        
        
        
        pc = princpController;        

        dialog = modal;

        data = FXCollections.observableArrayList();

        getComboBoxClients();

        productNameColumn.setCellValueFactory(new PropertyValueFactory<SaleItem, String>("name"));
        productBrandColumn.setCellValueFactory(new PropertyValueFactory<SaleItem, String>("brandname"));
        productTypeColumn.setCellValueFactory(new PropertyValueFactory<SaleItem, String>("typename"));
        totalProductPriceColumn.setCellValueFactory(new PropertyValueFactory<SaleItem, Float>("total"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<SaleItem, Integer>("quantity"));
        
        ImageView im = new ImageView("file:leftarrow.png");
        im.setFitHeight(20);
        im.setFitWidth(20);
        backButton.setGraphic(im);

        saleTable.setItems(data);        
        
        addItemButton.setDisable(true);        

    }

    @FXML
    public void cancel() {
        deleteSale();
        ChangeScreen(dialog,"/fxml/MainScreen.fxml", pc);
        
    }
    
    public void deleteSale(){
        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate("DELETE FROM sales where id = " + saleId);
                    
        } catch (Exception e) {
        }
    }

    public void getComboBoxClients() {
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from get_clients();");
            while (rs.next()) {
                clientComboBox.getItems().add(rs.getString("name"));
            }
        } catch (Exception e) {
        }
        
        
    }

    //Add item to this sale
    @FXML
    public void addItemSale() {
        
        AddSaleItemController itemController = new AddSaleItemController(connection);
        dialogAddItem = CreateModal(backButton, "/fxml/AddSaleItem.fxml", itemController, "Add Product Item");
        itemController.init(dialog);

    }

    @FXML
    public void createSale(String discount) {
        //Create a sale but it is not finished 
        //so the salesman can add products to this sale and then 
        // generate its invoice
        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(
                    "DO $$ BEGIN\n" +
                    "PERFORM add_sale(0.0,0.0,"
                            + "'" + clientComboBox.getValue() + "',"
                            + "" + discount + ", 'F');\n" +
                    "END $$;"
            );                       
            Statement st2 = this.connection.createStatement();            
            ResultSet rs = st2.executeQuery(""
                    + "select max(id) from sales");
            if(rs.next()){
                saleId = rs.getInt("max");                
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        addItemButton.setDisable(false);
    }

    // fake fiscal notes
    public String generateFiscalNote() {
        boolean newnumber = false;

        while (!newnumber) {
            String FN = Integer.toString(ThreadLocalRandom.current().nextInt(100000000, 999999999 + 1));

            //verify if there is already a sale with the generated fiscal note        
            try {
                Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery("select * from checkFNAlreadyExists('" + FN + "');");

                if (rs.next()) {

                } else {
                    return FN;
                }
            } catch (Exception e) {
            }
            
        }
        sendAlert(
                "Error invoice generation",
                "Error creating invoice.", 
                "Critical error on invoice", Alert.AlertType.ERROR);
        return "";
    }

    @FXML
    public void checkForm() {
        System.out.println("começou a verificar o form");
        String discount = null;
        try {
            discount = discountTextField.getText();
        } catch (Exception e) {
            sendAlert("Error Adding new Type",
                    "No Type name", "Choose a product type name.", Alert.AlertType.ERROR);
            return;
        }

        if (discount.equals("")) {
            sendAlert("Error Adding new Type",
                    "No Type name", "Fill all the fields! Choose a product type name.", Alert.AlertType.ERROR);
        } else {
            if (!saleCreated) {
                createSale(discount);
            }
        }
    }

}
