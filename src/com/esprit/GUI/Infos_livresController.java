/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.B8ks.entities.Book;
import com.B8ks.service.CartService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class Infos_livresController implements Initializable {
int user_id=3;
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
    private Button Annuler;
    @FXML
    private Label txttype;
    private Book b;
    @FXML
    private ImageView imglivre;
    @FXML
    private AnchorPane GetInfos;
    @FXML
    private Label book_i;
    /**
     * Initializes the controller class.
     */
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
        txttitre.setText(b.getTitle());
        txtauteur.setText(b.getPublisher());
        txtprix.setText(String.valueOf(b.getPrice()));
        txtann.setText(b.getPublishdDate());
        txtdesc.setText(b.getDescr());
        txttype.setText((b.getCat()));
        imglivre.setImage(new Image(b.getImg()));
        book_i.setText(String.valueOf(b.getId()));

            }
    @FXML
    private void Annuler(ActionEvent event) {
        Stage stage = (Stage) Annuler.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ADDTOCART(ActionEvent event) {
        
        CartService cs=new CartService();
        cs.addBookToCart(user_id, Integer.parseInt(book_i.getText()),b.getPrice());
        
    }
}
