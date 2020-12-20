/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.controllers.FxmlLoader;
import com.esprit.controllers.FxmlLoader;
import com.esprit.controllers.FxmlLoader;
import com.esprit.controllers.FxmlLoader;
import com.esprit.views.ViewFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane parent;
    
    private double xOffSet = 0;
    private double yOffSet = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
    }
    
    private void makeStageDragable() {
        parent.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });

        parent.setOnMouseDragged((event) -> {
            B8ks_Main.stage.setX(event.getScreenX() - xOffSet);
            B8ks_Main.stage.setY(event.getScreenY() - yOffSet);
            B8ks_Main.stage.setOpacity(0.8f);
        });
        parent.setOnDragDone((event) -> {
            B8ks_Main.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((event) -> {
            B8ks_Main.stage.setOpacity(1.0f);
        });
    } 

   @FXML
    private void minimize_stage(MouseEvent event) {
        B8ks_Main.stage.setIconified(true);
    }

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void blogs(ActionEvent event) {

    }

    @FXML
    private void usedbooks(ActionEvent event) {
    }

    @FXML
    private void claim(ActionEvent event) throws IOException {
        Pane view=v.ListClaims(event);
        mainPane.setCenter(view);

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

    @FXML
    private void newsletter(ActionEvent event) throws IOException {
        Pane view=v.SendEmail(event);
        mainPane.setCenter(view);
    }

    
}
