package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import com.esprit.cache.UserCache;
import java.net.URL;
import java.util.ResourceBundle;

import com.esprit.entities.Book;
import com.esprit.services.CartService;
import com.esprit.utils.validationSaisie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class Infos_livresController extends HomeController implements Initializable {
int user_id=UserCache.id;
    @FXML
    private Label txttitre;
    @FXML
    private Label txtauteur;
    @FXML
    private Label txtprix;
    @FXML
    private Label txtann;
    @FXML
    private Label txtdesc;
    @FXML
    private Button valider;
    @FXML
    private Label book_i;
    @FXML
    private Button Annuler;
    @FXML
    private Label txttype;
    private Book b;
    @FXML
    private ImageView imglivre;
    @FXML
    private AnchorPane GetInfos;

    
    HomeController h=new HomeController();
    CartService cs=new CartService();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GetInfos.setOnMouseEntered(e->{
            setInput();
        });
        
        
    } 
    
    public void setB(Book b) {
        this.b = b;
    }
    public void setInput (){
        book_i.setText(Integer.toString(b.getId()));
        txttitre.setText(b.getTitle());
        txtauteur.setText(b.getPublisher());
        txtprix.setText(String.valueOf(b.getPrice()));
        txtann.setText(b.getPublishdDate());
        txtdesc.setText(b.getDescr());
        txttype.setText((b.getCat()));
        imglivre.setImage(new Image(b.getImg()));
        

            }
    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = (Stage) Annuler.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ADDTOCART(ActionEvent event) {
        //cs.addBookToCart_copy(user_id, Integer.parseInt(book_i.getText()),b.getPrice());
        
        
        cs.addBookToCart(user_id, Integer.parseInt(book_i.getText()),b.getPrice());
        
        nb.setText(cs.nbPanier(user_id));
            validationSaisie.notifConfirm("Success", "Title : "+b.getTitle()+ " ADDED TO YOUR CART !");
            
            //JOptionPane.showMessageDialog(null, "Book created !");*/
      
    }
}
