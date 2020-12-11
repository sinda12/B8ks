/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.B8ks.entities.Book;
import com.B8ks.entities.Category;
import com.B8ks.service.CartService;
import com.esprit.services.ServicesBook;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class Liste_livresController implements Initializable {
int user_id=3;
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
    ObservableList o;
    @FXML
    private TextField search;
    @FXML
    private AnchorPane C;
    /**
     * Initializes the controller class.
     */
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
    public void sendData(Book b) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Infos_livres.fxml"));
        Parent parent = loader.load();
        Infos_livresController c = loader.getController();
        c.setB(b);
        Scene scene = new Scene(parent);
        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.show();
    }          

    @FXML
    private void chargerDonnee(MouseEvent event) {
        Book b = TabBook.getSelectionModel().getSelectedItem();
            if (!(b==null) ) { 
                
            try {
                sendData(b);
                
            } catch (IOException ex) {
                Logger.getLogger(Liste_livresController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
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


    }
 
