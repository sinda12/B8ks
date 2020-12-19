/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import com.esprit.controllers.FxmlLoader;
import com.esprit.controllers.FxmlLoader;
import com.esprit.controllers.FxmlLoader;
import com.esprit.controllers.FxmlLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class AdminController implements Initializable {
    
    ViewFactory v = new ViewFactory();

    private ChoiceBox<Button> choiceBox;
    @FXML
    private Button blogs;
    @FXML
    private BorderPane mainPane;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }


    @FXML
    private void minimize_stage(MouseEvent event) {
    }

    @FXML
    private void close_app(MouseEvent event) {
    }

    @FXML
    private void blogs(ActionEvent event) {

    }

    @FXML
    private void usedbooks(ActionEvent event) {
    }

    @FXML
    private void claim(ActionEvent event) {

    }

    @FXML
    private void order(ActionEvent event) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("../views/Admin_Order_view");
         mainPane.setCenter(view);
    }

    @FXML
    private void costumers(ActionEvent event) throws IOException {
        Pane view=v.showListUser(event);
        mainPane.setCenter(view);
    }

    @FXML
    private void product(ActionEvent event) {
        FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("../views/Product");
         mainPane.setCenter(view);
    }

    
}
