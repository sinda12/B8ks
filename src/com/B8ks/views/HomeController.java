/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnBooks;
    @FXML
    private Button btnBlog;
    @FXML
    private Button btnUsedBook;
    @FXML
    private Button btnComplaint;
    @FXML
    private Button btnSignout;
    @FXML
    private TextField serch;
    @FXML
    private Button btnCart;
    @FXML
    public BorderPane mainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Home(ActionEvent event) {
    }

    @FXML
    private void Profile(ActionEvent event) {
    }

    @FXML
    private void Books(ActionEvent event) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("@../com/esprit/GUI/Infos_livres");
         mainPane.setCenter(view);
    }

    @FXML
    private void Blog(ActionEvent event) {
    }

    @FXML
    private void UsedBook(ActionEvent event) {
    }

    @FXML
    private void Complaint(ActionEvent event) {
    }

    @FXML
    private void SingOut(ActionEvent event) {
    }

    @FXML
    private void SearchBookByN(ActionEvent event) {
    }

    @FXML
    private void GoToCart(ActionEvent event) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("CartInterface");
         mainPane.setCenter(view);
         
        
  
    }
    
}
