/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.controller;

import com.B8ks.cache.UserCache;
import com.B8ks.entities.User;
import com.B8ks.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author sinda
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class OrderInfoReadyController extends BaseController implements Initializable {

    @FXML
    private Button CHANGER_adresse;

    @FXML
    private Label affiche_adresse_livraison;

    @FXML
    private AnchorPane affiche_info_livraison;

    @FXML
    private RadioButton Standard;

    @FXML
    private RadioButton rapide;

    @FXML
    private Button paiement;

    @FXML
    private Label sous_total;

    @FXML
    private Label frais_livrison;

    @FXML
    private Label total;

    public OrderInfoReadyController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    @FXML
    void modifier_user_adresse(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.affiche_adresse_livraison.setText(UserCache.adresse);
        
        
        
        
        
    
    
    }

}

  
    

