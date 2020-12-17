package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.esprit.entities.Category;
import com.esprit.services.ServicesCategory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class CategoryController implements Initializable {

    @FXML
    private Button ajouterCategorie;
    @FXML
    private TextField title_cat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouterCategorie.setOnAction(e ->{
            ServicesCategory sc = new ServicesCategory();
            Category c = new Category(title_cat.getText());
            sc.ajouter(c);
            JOptionPane.showMessageDialog(null, "Catégorie ajoutée !");
            
        });
    }    
    
}
