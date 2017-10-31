package com.mycompany.loja.suplementos;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    private Stage thestage;
    private Parent root;    
    
    Scene loginscreen, mainscene;

    @Override
    public void start(Stage stage) throws Exception {
        thestage = stage;
        root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        loginscreen = new Scene(root);
        loginscreen.getStylesheets().add("/styles/Styles.css");


        
        stage.setTitle("Loja de Suplementos");
        stage.setScene(loginscreen);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
