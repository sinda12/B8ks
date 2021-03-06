/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.entities.Review;
import com.esprit.entities.User;


import com.esprit.services.ServiceReview;
import com.esprit.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CreateReviewController extends BaseController {

    @FXML
    private TextField description;
    @FXML
    private Button sendbtn;
    @FXML
    private ChoiceBox choicebox ;
    
    ObservableList<Integer> choiceboxlist = FXCollections.observableArrayList(1,2,3,4,5);

            ServiceReview sr = new ServiceReview();
            User u = new User();

    public CreateReviewController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }
    @FXML
    private void initialize(){
        choicebox.setItems(choiceboxlist);
    }

  

    @FXML
    private void send(ActionEvent event) {
        if (description.getText().trim().length() > 0){
               u.setId(21);
        sr.create(new Review(description.getText(), (int) choicebox.getValue()),u);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Review created !!");
            alert.setHeaderText(null);
            alert.setContentText("Review created successfully !!");
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
