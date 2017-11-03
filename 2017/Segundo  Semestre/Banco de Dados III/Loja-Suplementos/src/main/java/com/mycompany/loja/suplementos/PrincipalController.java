/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import supportClasses.User;
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

    public Stage dialog;

    public PrincipalController(Connection db, User current) {
        super(db, current);
    }

    @FXML
    public void addBrands(ActionEvent event) {
        if (getUserType() == userType.admin) {
            AddBrandController brandController = new AddBrandController(this.connection);
            dialog = CreateModal(event,menuBar,
                    "/fxml/AddBrand.fxml",
                    brandController,
                    "Add a Brand");
            brandController.init(dialog);
        } else {
            sendAlert("Access error",
                    "Attempt to access admin feature.",
                    "You have no access to add Brands. Ask the administrator.",
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
