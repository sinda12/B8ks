/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.entities.Claim;
import com.esprit.services.ServiceClaim;
import com.esprit.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class UpdateClaimController extends BaseController implements Initializable {

    @FXML
    private TextField description;
    @FXML
    private Button updatebtn;
    
    private int id_claim;

    public void setId_claim(int id_claim) {
        this.id_claim = id_claim;
    }
    
    ServiceClaim sc = new ServiceClaim();

    public UpdateClaimController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) {
        sc.modify(new Claim(id_claim,description.getText()));
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Claim updated !!");
            alert.setHeaderText(null);
            alert.setContentText("Claim updated successfully !!");
            alert.showAndWait();
            
    }
    
}
