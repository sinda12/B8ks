/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import com.B8ks.entities.Book;
import com.esprit.services.ServicesBook;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class UpdateBookController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField titre;
    @FXML
    private TextField auteur;
    @FXML
    private TextField description;
    @FXML
    private TextField date;
    @FXML
    private TextField prix;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        update.setOnAction(e ->{
        Book b = new Book();
        b.setId(Integer.parseInt(id.getText()));
        b.setTitle(titre.getText());
        b.setPublisher(auteur.getText());
        b.setDescr(description.getText());
        b.setPublishdDate(date.getText());
        b.setPrice(Double.parseDouble(prix.getText()));
        ServicesBook sb = new ServicesBook();
        sb.modifier(b);
        JOptionPane.showMessageDialog(null, "Livre modifié !");
        });
    }    
    
}
