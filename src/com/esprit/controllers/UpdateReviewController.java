/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.models.Review;
import com.esprit.services.ServiceReview;
import com.esprit.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class UpdateReviewController extends BaseController implements Initializable {

    @FXML
    private TextField description;
    @FXML
    private Button sendbtn;
    @FXML
    private ChoiceBox<Integer> choicebox;
    @FXML
    private Label lb_comment;
    @FXML
    private Label lb_rate;
    
    private int id_review;
    
    ObservableList<Integer> choiceboxlist = FXCollections.observableArrayList(1,2,3,4,5);
    
    ServiceReview sr = new ServiceReview();

    public UpdateReviewController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setChoicebox(Integer choicebox) {
        this.choicebox.setValue(choicebox);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void initialize (){
        choicebox.setItems(choiceboxlist);
    }

    @FXML
    private void send(ActionEvent event) {
        sr.modify(new Review(id_review,description.getText(),choicebox.getValue()));
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Review updated !!");
            alert.setHeaderText(null);
            alert.setContentText("Review updated successfully !!");
            alert.showAndWait();
    }
    
}
