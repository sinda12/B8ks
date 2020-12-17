package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.esprit.services.CartService;
import com.esprit.services.ServiceOrder;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class Order1Controller implements Initializable {
    
    int u_i=3;

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
    @FXML
    private Button update;

    
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
     
    ServiceOrder so=new ServiceOrder();
    CartService cs = new CartService();

    public static int totPrice; 
    @FXML
    private AnchorPane C;
    @FXML
    private Label Livraison_button;
    @FXML
    private Label Paiement_Button;
    @FXML
    private Label Resume_button;

    public int getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(int totPrice) {
        Order1Controller.totPrice = totPrice;
    }

    @FXML
    private ToggleGroup livraison;
    
    public static double p;

    public double getP() {
        return p;
    }
    

    @FXML
    private void standardAction(ActionEvent event) {
        double message=7;
        double prixTot=Double.parseDouble(cs.prixTotale(u_i));
        if(Standard.isSelected()){
            message+=0;
           
           
        }
        frais_livrison.setText(Double.toString(message));
        p=message+prixTot;
        total.setText(Double.toString(p));
        
    }

    @FXML
    private void rapideAction(ActionEvent event) {
        double message=12;
        double prixTot=Double.parseDouble(cs.prixTotale(u_i));
        if(rapide.isSelected()){
            message+=0;
            
            
        }
        frais_livrison.setText(Double.toString(message));
        p=message+prixTot;
        total.setText(Double.toString(p));
        
    }
    
    

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //this.total.setText(Double.toString(Double.parseDouble(cs.prixTotale(u_i)+7.0)));
        this.affiche_adresse_livraison.setText(so.UserDetails(u_i));
        this.sous_total.setText(cs.prixTotale(u_i));
        //double totPricedouble= Double.parseDouble(total.getText())*100;
        //System.out.println(totPricedouble);
        //totPrice =(int) totPricedouble;
       
        
    }    



    @FXML
    private void GoToPayment(ActionEvent event) throws IOException {
        if(Standard.isSelected()||rapide.isSelected()){

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Order2_Payment.fxml"));
        C.getChildren().setAll(pane);} 
        else{
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("you need to choose a delivery method !");
            alert.showAndWait();
        }
    }

    @FXML
    private void UpdateAdress(ActionEvent event) throws IOException {

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Order1_updateAdress.fxml"));
        C.getChildren().setAll(pane);} 
        
    





    
}
