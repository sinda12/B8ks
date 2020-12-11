/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.B8ks.entities.Book;
import com.B8ks.entities.Category;
import com.esprit.services.ServicesBook;
import com.esprit.services.ServicesCategory;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class Aff_modi_supp_catController implements Initializable {

    @FXML
    private TableColumn<Category, String> Coltitle;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableView<Category> TabCat;
    @FXML
    private TableColumn<Category, String> descr;
    public Aff_modi_supp_catController(){
        }
    /**
     * Initializes the controller class.
     */
    Category c;
    public String getIdCat(){
        return String.valueOf(c.getId());
            }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServicesCategory sc = new ServicesCategory();
         ArrayList ab;
         ab = (ArrayList) sc.afficher();
         Coltitle.setCellValueFactory(new PropertyValueFactory<Category, String>("title_cat"));
         descr.setCellValueFactory(new PropertyValueFactory<Category, String>("desc"));
         TabCat.setItems(getItems());
    }    
    public ObservableList<Category> getItems() {
        ObservableList<Category> list = FXCollections.observableArrayList();
        ServicesCategory sc = new ServicesCategory();
        list.addAll(sc.afficher());
        return list;
    }    

    @FXML
    private void chargerDonnee(MouseEvent event) {
    }

    @FXML
    private void addCat(ActionEvent event) {
        try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("Ajouter_cat.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Add new Category");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }

    private void updateCat(ActionEvent event) throws IOException {
       Category eventSelected = TabCat.getSelectionModel().getSelectedItem();
        if (eventSelected == null)
            JOptionPane.showMessageDialog(null, "Select Row to Update!");
        else{
            try {
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("ModifierCat.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Update Category");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
             
    }
    }

    @FXML
    private void deleteCat() {
        
        Category eventSelected = TabCat.getSelectionModel().getSelectedItem();
        if (eventSelected == null){
          validationSaisie.notif("Error", "Select a row to remove !");}
        else{
            ServicesCategory sc = new ServicesCategory();
            sc.supprimer(eventSelected);
            TabCat.setItems(getItems());
            validationSaisie.notif("Succès", "Category deleted !");
        }
    }    

    @FXML
    private void setSelectedItem(MouseEvent e) {
        
        Category c = TabCat.getSelectionModel().getSelectedItem();
            if (!(c==null) ) { 
                
            try {
                sendData(c);
            } catch (IOException ex) {
                Logger.getLogger(Aff_modi_supp_catController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
    }
    public void sendData(Category c) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifierCat.fxml"));
        Parent parent = loader.load();

        ModifierCatController mc = loader.getController();

        mc.setC(c);
       
        Scene scene = new Scene(parent);
        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.show();
    }
    }
