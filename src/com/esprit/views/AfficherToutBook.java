/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import com.esprit.models.Book;
import com.esprit.models.Category;
import com.esprit.services.ServicesBook;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class AfficherToutBook implements Initializable {

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
        System.out.println(sb.afficher());
        return list;
    }    

    @FXML
    private void chargerDonnee(MouseEvent event) {
    }

    @FXML
    private void searchBox(KeyEvent event) {
    }

    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void updateBook(ActionEvent event) {
    }

    @FXML
    private void deleteBook(ActionEvent event) {
                    try {
             //System.exit(0);
             Parent redirection_parent = FXMLLoader.load(getClass().getResource("Ajouter_livre.fxml"));
             Scene redirection_scene = new Scene(redirection_parent);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setScene(redirection_scene);
             app_stage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
            Stage stage = (Stage) add.getScene().getWindow();
                     // do what you have to do
                    stage.close();
            }
    }
