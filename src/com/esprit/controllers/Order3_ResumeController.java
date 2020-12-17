package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.esprit.services.CartService;
import com.esprit.services.ServiceOrder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class Order3_ResumeController implements Initializable {
    
    int u_i=3;
    
    ServiceOrder so=new ServiceOrder();
    CartService cs = new CartService();

    @FXML
    private Label Livraison_button;
    @FXML
    private Label Paiement_Button;
    @FXML
    private Label Resume_button;
    private Label affiche_adresse;
    @FXML
    private Button confirm_commande;
    @FXML
    private AnchorPane C;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //affiche_adresse.setText(so.UserDetails(u_i));
    }    

    @FXML
    private void BackToHome(ActionEvent event) {
                try{
             
            //-----recuperation de prix
            Order1Controller oc=new Order1Controller();
            double priceP=oc.getP();
            int amount=(int) priceP;
   
                 
            Document document =new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\sghai\\Downloads/facture.pdf"));
            document.open();
            document.add(new Paragraph("******************your order has been processed********************** \n \n "+"Your Details are :\n"+so.UserDetails(u_i)+"You payed : "+amount+"dt"));
            document.close();
            
            
        }
        catch(  DocumentException | FileNotFoundException e){
            System.out.println(e);
            
        }
        System.out.println("pdf enregistré");
    
}
}
