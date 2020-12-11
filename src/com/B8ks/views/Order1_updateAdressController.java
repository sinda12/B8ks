/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;

import com.B8ks.service.ServiceOrder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class Order1_updateAdressController implements Initializable {

    @FXML
    private Button save;
    @FXML
    private AnchorPane C;
    @FXML
    private Button save1;
    
    
    int user_id=3;
    @FXML
    private TextField mobile;
    @FXML
    private TextField adresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    Alert alert=new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void GoToOrder1(ActionEvent event) throws IOException {
        

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Order1.fxml"));
        C.getChildren().setAll(pane); 
    }

    @FXML
    private void Save(ActionEvent event) throws IOException {
        if((!"".equals(mobile.getText()))&&(!"".equals(adresse.getText()))){
        ServiceOrder so=new ServiceOrder();
        so.modifierClient(user_id,adresse.getText(),Integer.parseInt(mobile.getText()));
        
        AnchorPane pane=FXMLLoader.load(getClass().getResource("Order1.fxml"));
        C.getChildren().setAll(pane);}
        else if(("".equals(mobile.getText()))&&("".equals(adresse.getText()))){
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("type valide information !");
            alert.showAndWait();
                
                
                }
    }
    
}
