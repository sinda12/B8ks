/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.entities.Claim;
import com.esprit.entities.User;

import com.esprit.services.ServiceClaim;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.esprit.views.ViewFactory;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ClaimController extends BaseController {

    @FXML
    private TextField description;
    @FXML
    private Button sendidbtn;

            ServiceClaim sc = new ServiceClaim();
            User u = new User();

    public ClaimController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }
    /**
     * Initializes the controller class.
     */

    @FXML
    private void send(ActionEvent event) {
        if (description.getText().trim().length() > 0){
               u.setId(21);
        sc.create(new Claim(description.getText()),u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Claim sent !!");
            alert.setHeaderText(null);
            alert.setContentText("Claim sent successfully !!");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("TextField is empty !!");
            alert.setHeaderText(null);
            alert.setContentText("Please Write Something !!");
            alert.showAndWait();
             }
    }
    
}
