/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.B8ks.entities.Book;
import com.B8ks.entities.Category;
import com.esprit.services.SendMail;
import com.esprit.services.ServicesBook;
import com.esprit.services.ServicesCategory;
import com.esprit.tests.senMain;
import com.esprit.utils.validationSaisie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class Ajouter_livreController implements Initializable {

    @FXML
    private TextField txttitre;
    @FXML
    private TextField txtauteur;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtann;
    @FXML
    private TextField txtim;
    @FXML
    private TextArea txtdesc;
    @FXML
    private Button ajouter;
    @FXML
    private ImageView img;
    @FXML
    private ChoiceBox<String> catBox;
    @FXML
    private Button Annuler;
   
    
    
    public Ajouter_livreController(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCat();
        
        ajouter.setOnAction(e -> {
            Book b=b = new Book(txttitre.getText(), txtauteur.getText(), catBox.getValue() ,txtdesc.getText(), txtann.getText(), Double.parseDouble(txtprix.getText()), txtim.getText());
            
                        if(!(txtprix.getText()).matches("^\\d+$")){
                JOptionPane.showMessageDialog(null, "Prix invalide !");
            }
            else if(!(txtann.getText()).matches("^\\d+$")){
                JOptionPane.showMessageDialog(null, "Année invalide !");
                
            }
                else{
           
            ServicesBook sb = new ServicesBook();
            
            ArrayList al = (ArrayList) sb.afficher();
            for (int i=0; i<al.size();i++){
                if( al.get(i).equals(b))
                {
                   JOptionPane.showMessageDialog(null, "Book already exists !"); 
                return;
                }
            }
            sb.ajouter(b);
           
            validationSaisie.notifConfirm("Success", "Book created !");
            
            JOptionPane.showMessageDialog(null, "Book created !");}
                        SendMail sm = new SendMail();
            try {
                sm.envoiMail("gar4a@hotmail.fr", "Nouveau livre disponible "+b.getTitle());
            } catch (Exception ex) {
                Logger.getLogger(Ajouter_livreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
    }       
    private void loadCat (){
        ServicesCategory sc = new ServicesCategory();
        ObservableList<String> lc = FXCollections.observableArrayList();
        for (int i=0;i<sc.afficher().size();i++){
            lc.add(sc.afficher().get(i).getTitle_cat());
        }
        catBox.setItems(lc);
            }


    @FXML
    private void Annuler(ActionEvent event) {
    try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("Aff_modi_supp_livre.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Liste Livres");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
        
    }
    
}
