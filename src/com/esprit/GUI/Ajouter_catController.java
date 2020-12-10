/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Book;
import com.esprit.models.Category;
import com.esprit.services.SendMail;
import com.esprit.services.ServicesBook;
import com.esprit.services.ServicesCategory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class Ajouter_catController implements Initializable {

    @FXML
    private TextField txttitre;
    @FXML
    private TextArea txtdesc;
    @FXML
    private Button ajouter;
    @FXML
    private Button Annuler;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouter.setOnAction(e -> {              
            ServicesCategory sc = new ServicesCategory();
            Category c = new Category(txttitre.getText(), txtdesc.getText());
            sc.ajouter(c);          
            });
    }    

    @FXML
    private void Annuler(ActionEvent event) {
        try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("Aff_modi_supp_cat.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Liste Catégorie");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }
    
}
