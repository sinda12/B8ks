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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.B8ks.service.CartService;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class HomeController implements Initializable {
    
    int user_id=3;

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
    private Button btnCart;
    @FXML
    public BorderPane mainPane;
    @FXML
    private AnchorPane parent;

    private double xOffSet = 0;
    private double yOffSet = 0;
    
    
    @FXML
    private Label nbPanier;
    CartService cs=new CartService();
    
    public static Label nb;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("home_page");
         mainPane.setCenter(view);
        makeStageDragable();
        nbPanier.setText(cs.nbPanier(user_id));
        nb=nbPanier;
    }
    



    private void makeStageDragable() {
        parent.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        parent.setOnMouseDragged((event) -> {
            B8ks_Main.stage.setX(event.getScreenX() - xOffSet);
            B8ks_Main.stage.setY(event.getScreenY() - yOffSet);
            B8ks_Main.stage.setOpacity(0.8f);
        });
        parent.setOnDragDone((event) -> {
            B8ks_Main.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((event) -> {
            B8ks_Main.stage.setOpacity(1.0f);
        });
    }    

    @FXML
    private void Home(ActionEvent event) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("home_page");
         mainPane.setCenter(view);
    }

    @FXML
    private void Profile(ActionEvent event) {
    }

    @FXML
    private void Books(ActionEvent event) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("../../esprit/GUI/Liste_livres");
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
    private void GoToCart(ActionEvent event) {
         FxmlLoader o=new FxmlLoader();
         Pane view=o.getPage("CartInterface");
         mainPane.setCenter(view);
         
        
  
    }
     @FXML
    private void minimize_stage(MouseEvent event) {
        B8ks_Main.stage.setIconified(true);
    }

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }
    
}
