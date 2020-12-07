 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.B8ks.views;

import b8ks.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author sinda
 */
public class Mainfx extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        ViewFactory v = new ViewFactory();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
