package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ResourceBundle;

import com.esprit.services.ServiceOrder;
import com.esprit.services.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class OrderResumeController implements Initializable {

    @FXML
    private Label affiche_adresse;
    @FXML
    private Button confirm_commande;
    @FXML
    private Label Livraison_button;
    @FXML
    private Label Paiement_Button;
    @FXML
    private Label Resume_button;
    @FXML
    private Label sous_total;
    @FXML
    private Label Sous_total;
    @FXML
    private Label frais_livraison;
    @FXML
    private Label Total;
    @FXML
    private Label mode_livr_choisie;
   

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceOrder so=new ServiceOrder();
        
        ServiceUser su=new ServiceUser();
        //this.affiche_adresse.setText;
        
        
        
        //getUser.getAdress; 
        
    }    
    
}
