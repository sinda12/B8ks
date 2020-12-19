/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import com.esprit.controllers.FxmlLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class ProductController implements Initializable {

    @FXML
    private BorderPane paneHamza;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBook(ActionEvent event) {
                 FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("../views/Aff_modi_supp_livre");
         paneHamza.setCenter(view);
    }
    
}
