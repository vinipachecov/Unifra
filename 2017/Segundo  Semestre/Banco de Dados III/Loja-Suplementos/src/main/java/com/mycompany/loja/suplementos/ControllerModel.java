/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.suplementos;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import supportClasses.User;
import supportClasses.userType;

/**
 *
 * @author vinicius
 */
public class ControllerModel {
    
    Connection connection;
    User currentUser;
    
    public ControllerModel(Connection db){
        this.connection = db;
        
    }
    
    public ControllerModel(Connection db, User user){
        this.connection = db;
        currentUser = user;   
        System.out.println("current user " 
                +currentUser.getUserType());
        
        System.out.println("user recebido " 
                +currentUser.getUserType());
    }
    
    public userType getUserType(){
        return currentUser.getUserType();
    }
    
    @FXML
    public void ChangeScreen(ActionEvent event, Button button, String FXMLFile, Class controller){
        Stage stage; 
        Parent root = null;
        stage=(Stage) button.getScene().getWindow();
           
        FXMLLoader mainscreenLoader = new FXMLLoader(getClass().getResource(FXMLFile));
        
        
        mainscreenLoader.setController(controller);      
                                
        try {
            root = mainscreenLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        
    }
    
    @FXML
    public void ChangeScreen(Button button, String FXMLFile, Object controller){
        Stage stage; 
        Parent root = null;
        stage=(Stage) button.getScene().getWindow();
           
        FXMLLoader mainscreenLoader = new FXMLLoader(getClass().getResource(FXMLFile));
                
        mainscreenLoader.setController(controller);      
        
        try {
            root = mainscreenLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        
    }
    
    
    
    
    @FXML
    public void ChangeScreen(MenuBar menubar, String FXMLFile, Object controller, String Title){
        Stage stage; 
        Parent root = null;
        stage=(Stage) menubar.getScene().getWindow();
           
        FXMLLoader mainscreenLoader = new FXMLLoader(getClass().getResource(FXMLFile));
        
        mainscreenLoader.setController(controller);      
                                
        try {
            root = mainscreenLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(ControllerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }    
    
    @FXML
    public Stage CreateModal(ActionEvent event, MenuBar menubar, String FXMLFile, Object controller,String title){
        
        Stage stage = new Stage();
        Parent root = null;        
        //stage =  addUsuarioMenuItem.
           //load up OTHER FXML document
        FXMLLoader screenLoader = new FXMLLoader(getClass()
                .getResource(FXMLFile));
        
        screenLoader.setController(controller);              
        
        try {
            root = screenLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(ControllerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
                                
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        //Put the owner you want for your modal
        // In this case I'm using menubar because it is a
        //node inherit class of my previous screen
        stage.initOwner(
            (menubar.getScene().getWindow() 
        ));
        stage.setScene(new Scene(root));        
        stage.show();    
        return stage;
    }
    
    public void sendAlert(String Title, String HeaderText, String ContentText, AlertType tipo){
        Alert alert = new Alert(tipo);        
        alert.setTitle(Title);
        alert.setHeaderText(HeaderText);
        alert.setContentText(ContentText);
        alert.showAndWait();
    }
    
    
   
        

}
