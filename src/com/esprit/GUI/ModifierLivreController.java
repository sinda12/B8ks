/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;
import com.esprit.GUI.Aff_modi_supp_livreController;
import com.B8ks.entities.Book;
import com.esprit.services.ServicesBook;
import com.esprit.services.ServicesCategory;
import com.esprit.views.UpdateBookController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class ModifierLivreController implements Initializable {

    @FXML
    public TextField txttitre;
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
    private Button Annuler;
    @FXML
    private ImageView img;
    @FXML
    private ChoiceBox<String> catBox;
    private Button valider;

    /**
     * Initializes the controller class.
     */
    private Book b;
    @FXML
    private Button Charger;
    @FXML
    private Button Valider;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCat();
        Charger.setOnAction(e->{
             setInput();
        });
          
    }    
    public void setInput (){
        txttitre.setText(b.getTitle());
        txtauteur.setText(b.getPublisher());
        txtprix.setText(String.valueOf(b.getPrice()));
        txtann.setText(b.getPublishdDate());
        txtdesc.setText(b.getDescr());
        catBox.setValue(b.getCat());
        txtim.setText(b.getImg());
            }
    public void setB(Book b) {
        this.b = b;
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
        Stage stage = (Stage) Annuler.getScene().getWindow();
        stage.close();
                    
    }


    @FXML
    private void Valider(ActionEvent event) {
        ServicesBook sb = new ServicesBook();
        b.setTitle(txttitre.getText());
        b.setPublisher(txtauteur.getText());
        b.setDescr(txtdesc.getText());
        b.setPrice(Double.parseDouble(txtprix.getText()));
        b.setCat(catBox.getValue());
        b.setPublishdDate(txtann.getText());
        b.setImg(txtim.getText());
        sb.modifier(b);
        Stage stage = (Stage) Valider.getScene().getWindow();
        stage.close();
    }
    
}
