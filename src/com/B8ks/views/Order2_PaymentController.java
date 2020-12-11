/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;


import com.B8ks.service.CartService;
import com.B8ks.service.ServiceOrder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class Order2_PaymentController implements Initializable {
    
    int u_i=3;

    @FXML
    private TextField nCart;
    @FXML
    private TextField mExpiration;
    @FXML
    private TextField aExpiration;
    @FXML
    private TextField codeCart;
    @FXML
    private Button payer;
    @FXML
    private AnchorPane C;
    @FXML
    private Label Livraison_button;
    @FXML
    private Label Paiement_Button;
    @FXML
    private Label Resume_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void Payer(ActionEvent event) throws StripeException, IOException {
        try{
            Stripe.apiKey = "sk_test_51HwbgyDgLCHZebRJA2SVWRSljGlqt8Be6uU4xaFn9qW5zqLdfgFmKQULEDPdg8F8zRug1Y2Tn4eO3V7astmfJNMl00BbOPa1iu";
            
            Map<String, Object> cardParam = new HashMap<String, Object>();
            if (!(nCart.getText().equals("") || mExpiration.getText().equals("") || aExpiration.getText().equals("") || codeCart.getText().equals(""))) {
                cardParam.put("number", nCart.getText());
                cardParam.put("exp_month", Integer.parseInt(mExpiration.getText()));
                cardParam.put("exp_year", Integer.parseInt(aExpiration.getText()));
                cardParam.put("cvc", codeCart.getText());}
        else {
                JOptionPane.showMessageDialog(null, "Please check your card information!");
                return;
            }
            Map<String, Object> tokenParam = new HashMap<String, Object>();
            tokenParam.put("card", cardParam);

            Token token = Token.create(tokenParam);
            
            Order1Controller oc=new Order1Controller();
            double priceP=oc.getP()*100;
            System.out.println(priceP);
            int amount=(int) priceP;
            System.out.println(amount);
            

            
            
            
            
            Map<String, Object> chargeParam = new HashMap<String, Object>();
            chargeParam.put("amount", amount);
            chargeParam.put("currency", "usd");
            chargeParam.put("source", token.getId());
            Charge charge = Charge.create(chargeParam);
            
            //***********l'ajout de commande
           
            ServiceOrder so=new ServiceOrder();
            CartService sc=new CartService();
            so.addO(u_i);
            sc.addToArchive(u_i);
            sc.deleteCartOrdred(u_i);
            
            
            
        AnchorPane pane=FXMLLoader.load(getClass().getResource("Order3_Resume.fxml"));
        C.getChildren().setAll(pane);   
            

        
            }catch (StripeException e) {
            System.out.println(e.getMessage());

            
        }
            
    
}
}
