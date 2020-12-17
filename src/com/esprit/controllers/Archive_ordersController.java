package com.esprit.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.esprit.entities.CartTable;
import com.esprit.services.CartService;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class Archive_ordersController implements Initializable {

    
     int u_i=3;
    
    
    
    @FXML
    private Button panier;
 @FXML
    private TableView<CartTable> table;

    @FXML
    private TableColumn<CartTable, String> book;

    @FXML
    private TableColumn<CartTable, Double> price;

    @FXML
    private TableColumn<CartTable, Integer> quntity;

    @FXML
    private TableColumn<CartTable, Integer> cart_id;
    
    CartService cs = new CartService();
    @FXML
    private AnchorPane C;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<CartTable> ab=new ArrayList<>();
        ab = cs.afficheArchive(u_i);
        
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        quntity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cart_id.setCellValueFactory(new PropertyValueFactory<>("cart_id"));
        
        table.getItems().addAll(ab);
    }    

    @FXML
    private void GoToCart(ActionEvent event) throws IOException {

        AnchorPane pane=FXMLLoader.load(getClass().getResource("CartInterface.fxml"));
        C.getChildren().setAll(pane);
    }
    public ObservableList<CartTable> getItems() {
        ObservableList<CartTable> list = FXCollections.observableArrayList();
        list.addAll(cs.afficherCController(u_i));
        System.out.println(cs.afficherCController(u_i));
        return list;
    }
    
    
    
}
