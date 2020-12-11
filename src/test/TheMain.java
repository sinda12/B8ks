package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author sinda
 */
public class TheMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../com/B8ks/views/CartInterface.fxml"));
    
    //FXMLLoader loader = new FXMLLoader(getClass().getResource("../com/B8ks/views/Admin_Order_view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        primaryStage.setTitle("Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
