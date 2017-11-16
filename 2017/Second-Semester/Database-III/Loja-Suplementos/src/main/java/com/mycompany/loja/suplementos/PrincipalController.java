/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import supportClasses.BestClient;
import java.sql.Connection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supportClasses.TopProduct;
import supportClasses.User;
import supportClasses.databaseType;
import supportClasses.userType;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class PrincipalController extends ControllerModel {

    /**
     * Initializes the controller class.
     */
    @FXML
    public MenuBar menuBar;
    @FXML
    public MenuItem addUserMenuItem;

    
//    TOP SOLD PRODUCTS
    @FXML
    public TextField yearTopProductsTextField;

    @FXML
    public TableView<TopProduct> topProductsTable;

    @FXML
    public TableColumn<TopProduct, String> productNameColumn;

    @FXML
    public TableColumn<TopProduct, Integer> numberSalesColumn;

    @FXML
    public TableColumn<TopProduct, Float> cashGeneratedColumn;
    
    public TopSaleProductsController topSaleProductsController;
    
    // WORST SOLD PRODUCTS
    
     @FXML
    public TextField yearWorstProductsTextField;

    @FXML
    public TableView<TopProduct> worstProductsTable;
    
    public ObservableList<TopProduct> worstProductWSData;

    @FXML
    public TableColumn<TopProduct, String> productNameWSColumn;

    @FXML
    public TableColumn<TopProduct, Integer> numberSalesWSColumn;

    @FXML
    public TableColumn<TopProduct, Float> cashGeneratedWSColumn;
    
    public WorstSaleProductsController worstSaleProductsController;
    
// TOP CLIENTS
    
    
    @FXML
    public TextField bestClientTextField;
            
    @FXML
    public TableView<BestClient> bestClientsTable;

    @FXML
    public TableColumn<BestClient, String> clientNameBCColumn;

    @FXML
    public TableColumn<BestClient, Integer> boughtTimesBCColumn;

    @FXML
    public TableColumn<BestClient, Float> cashGeneratedBCColumn;
    
    public BestClientsController bestClientsController;
    
    

    public Stage dialog;

    public Stage currentStage;

    public PrincipalController(Connection db, User current) {
        super(db, current);
    }

    public PrincipalController(Connection db, User current, databaseType databType) {
        super(db, current, databType);

    }
    
    
    
    
    public void init(Stage stage) {
        this.currentStage = stage;
        
        topSaleProductsController = new TopSaleProductsController(yearTopProductsTextField, topProductsTable, productNameColumn, numberSalesColumn, cashGeneratedColumn, connection, dbType);
        bestClientsController = new BestClientsController(bestClientTextField ,bestClientsTable, clientNameBCColumn, boughtTimesBCColumn, cashGeneratedBCColumn, connection, dbType);
        worstSaleProductsController = new WorstSaleProductsController(yearWorstProductsTextField, worstProductsTable, productNameWSColumn, numberSalesWSColumn, cashGeneratedWSColumn, connection, dbType);
    }
    
    @FXML 
    public void searchWorstSaleProducts(ActionEvent event){
        worstSaleProductsController.searchWorstProducts(event);
    }
    
    @FXML
    public void searchTopProducts(ActionEvent event) {
        topSaleProductsController.searchTopProducts(event);
    }
    
    @FXML
    public void searchBestClients(){
        bestClientsController.searchBestClients();
    }
    

    @FXML
    public void addSupplier(ActionEvent event) {
        if (getUserType() == userType.admin) {
            AddSupplierController addSupplier = new AddSupplierController(this.connection, this.dbType);
            dialog = CreateModal(event, menuBar,
                    "/fxml/AddSupplier.fxml",
                    addSupplier,
                    "Add a Supplier");
            addSupplier.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to add Suppliers. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void checkHistory(ActionEvent event) {
        if (getUserType() == userType.admin) {
            CheckHistoryController historyController = new CheckHistoryController(this.connection, this.dbType);
            dialog = CreateModal(event, menuBar,
                    "/fxml/CheckHistory.fxml",
                    historyController,
                    "Check History");
            historyController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to check History. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void addSale(ActionEvent event) {
        AddSaleController saleController = new AddSaleController(this.connection, this.dbType);
        ChangeScreen(menuBar,
                "/fxml/AddSale.fxml",
                saleController,
                "Add a Sale");
        saleController.init(currentStage, this);
    }

    @FXML
    public void addPurchase(ActionEvent event) {
        AddPurchaseController purchaseController = new AddPurchaseController(this.connection, this.dbType);
        ChangeScreen(menuBar,
                "/fxml/AddPurchase.fxml",
                purchaseController,
                "Add a Purchase");
        purchaseController.init(currentStage, this);
    }

    @FXML
    public void searchProduct(ActionEvent event) {
        SearchProductController searchController = new SearchProductController(connection, this.dbType);
        dialog = CreateModal(event, menuBar, "/fxml/SearchProduct.fxml", searchController, "Searching Products");
        searchController.init(dialog);
    }

    @FXML
    public void searchSupplier(ActionEvent event) {

        if (getUserType() == userType.admin) {
            SearchSupplierController searchController = new SearchSupplierController(connection, this.dbType);
            dialog = CreateModal(event, menuBar, "/fxml/SearchSupplier.fxml", searchController, "Searching Suppliers");
            searchController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to search Suppliers data. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void searchPurchase(ActionEvent event) {

        if (getUserType() == userType.admin) {
            SearchPurchaseController searchController = new SearchPurchaseController(connection, this.dbType);
            dialog = CreateModal(event, menuBar, "/fxml/SearchPurchase.fxml", searchController, "Searching Purchases");
            searchController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to search Suppliers data. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void searchSale(ActionEvent event) {

        if (getUserType() == userType.admin) {
            SearchSaleController searchController = new SearchSaleController(connection, this.dbType);
            dialog = CreateModal(event, menuBar, "/fxml/SearchSale.fxml", searchController, "Searching Sales");
            searchController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to search Suppliers data. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void searchBrands(ActionEvent event) {
        SearchBrandController searchController = new SearchBrandController(connection, this.dbType);
        dialog = CreateModal(event, menuBar, "/fxml/SearchBrand.fxml", searchController, "Searching Brands");
        searchController.init(dialog);

    }

    @FXML
    public void addProduct(ActionEvent event) {
        if (getUserType() == userType.admin) {
            AddProductController productController = new AddProductController(connection, this.dbType);
            dialog = CreateModal(event, menuBar,
                    "/fxml/AddProduct.fxml",
                    productController,
                    "Add a Product");
            productController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to add Products. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void addTypes(ActionEvent event) {
        if (getUserType() == userType.admin) {
            AddTypeController addTypeController = new AddTypeController(this.connection, this.dbType);
            dialog = CreateModal(event, menuBar,
                    "/fxml/AddType.fxml",
                    addTypeController,
                    "Add a Product Type");
            addTypeController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to add Types. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void searchClients(ActionEvent event) {

        if (getUserType() == userType.admin) {
            SearchClientController searchController = new SearchClientController(connection, this.dbType);
            dialog = CreateModal(event, menuBar, "/fxml/SearchClient.fxml", searchController, "Searching Clients");
            searchController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to search Client data. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void addClient(ActionEvent event) {
        AddClientController clientController = new AddClientController(this.connection, this.dbType);
        dialog = CreateModal(event, menuBar,
                "/fxml/AddClient.fxml",
                clientController,
                "Add new Client");
        clientController.init(dialog);

    }

    @FXML
    public void searchTypes(ActionEvent event) {
        SearchTypeController controller = new SearchTypeController(connection, this.dbType);
        dialog = CreateModal(event, menuBar, "/fxml/SearchType.fxml", controller, "Searching Types");
        controller.init(dialog);

    }

    @FXML
    public void addBrands(ActionEvent event) {

        if (getUserType() == userType.admin) {
            AddBrandController brandController = new AddBrandController(this.connection, this.dbType);
            dialog = CreateModal(event, menuBar,
                    "/fxml/AddBrand.fxml",
                    brandController,
                    "Add a Brand");
            brandController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to add Brands. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void Logout(ActionEvent event) {
        LoginController lc = new LoginController(null);
        ChangeScreen(menuBar, "/fxml/LoginScreen.fxml", lc, "Loja de Suplementos");
    }

    @FXML
    public void addUserMenu(ActionEvent event) {
        if (getUserType() == userType.admin) {
            AddUserController controller = new AddUserController(connection, this.currentUser);
            dialog = CreateModal(event, menuBar, "/fxml/AddUser.fxml", controller, "Add a User");
            controller.init(dialog);
        } else {
            sendAlert("Access Error",
                    "Attempt to access admin feature.",
                    "YOu are not allowed to add Users. Sign in as an administrator.",
                    Alert.AlertType.ERROR);
        }
    }
}
