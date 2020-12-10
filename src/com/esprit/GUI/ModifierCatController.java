/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Category;
import com.esprit.services.ServicesCategory;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class ModifierCatController implements Initializable {

    @FXML
    private TextField txttitre;
    @FXML
    private TextArea txtdesc;
    @FXML
    private Button valider;
    @FXML
    private Button Annuler;
    
    @FXML
    private Button Charger;
    /**
     * Initializes the controller class.
     */
    Category c;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Charger.setOnAction(e->{
            setInput();
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
             app_stage.setTitle("Liste Catégories");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
                    
    }
    public void setInput (){
        txttitre.setText(c.getTitle_cat());
        txtdesc.setText(c.getDesc());
       
            }

    @FXML
    private void valider(ActionEvent event) {
        ServicesCategory sc = new ServicesCategory();
        c.setTitle_cat(txttitre.getText());
        c.setDesc(txtdesc.getText());
        sc.modifier(c);
        Stage stage = (Stage) valider.getScene().getWindow();
        stage.close();
    }
    public void setC(Category c) {
        this.c = c;
    }  
}
