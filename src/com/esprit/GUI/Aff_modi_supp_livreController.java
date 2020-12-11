/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.B8ks.entities.Book;
import com.esprit.services.ServicesBook;
import com.esprit.utils.validationSaisie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class Aff_modi_supp_livreController implements Initializable {

    @FXML
    private TableView<Book> TabBook;
    @FXML
    private TableColumn<Book, String> Coltitle;
    @FXML
    private TableColumn<Book, String> ColAuth;
    @FXML
    private TableColumn<Book, String> ColType;
    @FXML
    private TableColumn<Book, String> ColDescription;
    @FXML
    private TableColumn<Book, String> ColDate;
    @FXML
    private TableColumn<Book, Double> Colprix;
    @FXML
    private TextField search;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    public Aff_modi_supp_livreController(){
        
    }
    Book b;
    public Book getClickedBook(){
        return b;
    }
    
    public String getIdBook(){
        return String.valueOf(b.getId());
            }
    
    public TableView<Book> getTabBook(){
        return TabBook;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesBook sb = new ServicesBook();
        ArrayList ab;
        ab = (ArrayList) sb.afficher();
        Colprix.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
        Coltitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        ColDescription.setCellValueFactory(new PropertyValueFactory<Book, String>("descr"));
        ColDate.setCellValueFactory(new PropertyValueFactory<Book, String>("publishDate"));
        ColAuth.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        ColType.setCellValueFactory(new PropertyValueFactory<Book, String>("Cat"));
        TabBook.setItems(getItems());
        
        }
    
    
    public ObservableList<Book> getItems() {
        ObservableList<Book> list = FXCollections.observableArrayList();
        ServicesBook sb = new ServicesBook();
        list.addAll(sb.afficher());
        return list;
    }    

    @FXML
    private void searchBox(KeyEvent event) {
     FilteredList<Book> flBook = new FilteredList<>(getItems(), f->true);
     search.textProperty().addListener((list, oldValue, newValue)->{
         flBook.setPredicate(b ->{
             if (newValue == null || newValue.isEmpty()){
                 return true;
             }
             String lowerCaseFilter = newValue.toLowerCase();
             if (b.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }
             else if (b.getPublisher().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }
             else if (b.getCat().toLowerCase().indexOf(lowerCaseFilter) != -1)
                 return true;
             else return false;
         });
     });
        SortedList<Book> sortedData = new SortedList<>(flBook);
        sortedData.comparatorProperty().bind(TabBook.comparatorProperty());
        TabBook.setItems(sortedData);
    
    }

    @FXML
    private void addBook(ActionEvent event) {
    try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("Ajouter_livre.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Ajout Livre");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
                
    }
    
    public void redirection (ActionEvent event){
    
    }
    
    public void updateBook(ActionEvent event) throws IOException{
   
        Book eventSelected = TabBook.getSelectionModel().getSelectedItem();
        if (eventSelected == null)
            JOptionPane.showMessageDialog(null, "Select Row to Update!");
        else{
        try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("ModifierLivre.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Modifier Livre");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
             
    }
    }
    @FXML
    private void setSelectedItem(MouseEvent e) {
        Book b = TabBook.getSelectionModel().getSelectedItem();
            if (!(b==null) ) { 
                
            try {
                sendData(b);
            } catch (IOException ex) {
                Logger.getLogger(Aff_modi_supp_livreController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
    }

    public void sendData(Book b) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifierLivre.fxml"));
        Parent parent = loader.load();
        ModifierLivreController c = loader.getController();
        c.setB(b);
        Scene scene = new Scene(parent);
        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.show();
    }
    
    
    @FXML
    private void deleteBook() {
        Book eventSelected = TabBook.getSelectionModel().getSelectedItem();
        if (eventSelected == null)
            JOptionPane.showMessageDialog(null, "Select Row to Remove!");
        else{
            ServicesBook sb = new ServicesBook();
            sb.supprimer(eventSelected);
             TabBook.setItems(getItems());
             validationSaisie.notifConfirm("ok", "Livre supprimé");
        }
    }

    private void afficher(ActionEvent event) {
         Book eventSelected = TabBook.getSelectionModel().getSelectedItem();
        if (eventSelected == null)
            JOptionPane.showMessageDialog(null, "Select Row to Update!");
        else{
            try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("Infos_livres.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.setTitle("Ajout Livre");
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
        }      
    }
    
}
