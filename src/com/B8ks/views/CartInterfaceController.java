/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;

import com.B8ks.entities.CartTable;
import com.B8ks.service.CartService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class CartInterfaceController extends HomeController implements Initializable {
    
     int u_i=3;
    
    
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
    
    @FXML
    private Label prixTotal;
    
    

    @FXML
    private Button commander;


    @FXML
    private Button supprimer;


   
    @FXML
    private Button archive;
    @FXML
    private Button orders;
    
    Alert alert=new Alert(AlertType.INFORMATION);
    @FXML
    private Button moinQ;
    @FXML
    private Button plusQ;
    @FXML
    private AnchorPane C;
    
    
    void BackToHome(ActionEvent event) {

        
    

    }


    
    CartService cs = new CartService();
    CartTable ct=new CartTable();

    @FXML
    void delete(ActionEvent event) {
        
        CartTable orderSelected=table.getSelectionModel().getSelectedItem();
        System.out.println(orderSelected);
        cs.supprimerCController(orderSelected);
        UpdateTable();
        nb.setText(cs.nbPanier(user_id));
    }
    
    
    @FXML
    private void moinQuantity(ActionEvent event) {
        CartTable orderSelected=table.getSelectionModel().getSelectedItem();
        if(orderSelected.getQuantity()>1){
        System.out.println(orderSelected);
        cs.moinquantity(orderSelected);
        table.getItems().clear();
        List<CartTable> ab=new ArrayList<>();
        ab = cs.afficherCController(u_i);
        
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        quntity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cart_id.setCellValueFactory(new PropertyValueFactory<>("cart_id"));
            System.out.println(orderSelected.getBook_id());
        table.getItems().addAll(ab);}
        
        else if(orderSelected.getQuantity()<1){
            cs.supprimerCController(orderSelected);
            UpdateTable();
        }
                else{
            cs.supprimerCController(orderSelected);
            UpdateTable();
        }
        this.prixTotal.setText(cs.prixTotale(u_i));
        nb.setText(cs.nbPanier(user_id));
      
    }

    @FXML
    private void plusOuantity(ActionEvent event) {
        CartTable orderSelected=table.getSelectionModel().getSelectedItem();
        System.out.println(orderSelected);
        cs.plusquantity(orderSelected);
        table.getItems().clear();
        List<CartTable> ab=new ArrayList<>();
        ab = cs.afficherCController(u_i);
        
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        quntity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cart_id.setCellValueFactory(new PropertyValueFactory<>("cart_id"));
        
        table.getItems().addAll(ab);
        this.prixTotal.setText(cs.prixTotale(u_i));
        nb.setText(cs.nbPanier(user_id));
    }
    

    @FXML
    void goToOrder(ActionEvent event) throws IOException {
        if(Double.parseDouble(prixTotal.getText())>1){
            
        AnchorPane pane=FXMLLoader.load(getClass().getResource("Order1.fxml"));
        C.getChildren().setAll(pane); }
        else{
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Your Cart is Empty !");
            alert.showAndWait();
            
            
        }
        
        
        

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        List<CartTable> ab=new ArrayList<>();
        ab = cs.afficherCController(u_i);
        
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        quntity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cart_id.setCellValueFactory(new PropertyValueFactory<>("cart_id"));
        
        table.getItems().addAll(ab);
        
        this.prixTotal.setText(cs.prixTotale(u_i));
        
        
    }
    public ObservableList<CartTable> getItems() {
        ObservableList<CartTable> list = FXCollections.observableArrayList();
        CartService cs = new CartService();
        list.addAll(cs.afficherCController(u_i));
        System.out.println(cs.afficherCController(u_i));
        return list;
    }
    
    
    
    public void UpdateTable(){
        CartService cs=new CartService();
        List<CartTable> ab=new ArrayList<>();
        ab= cs.afficherCController(u_i);
        ObservableList<CartTable> list = FXCollections.<CartTable>observableArrayList(ab);
        this.prixTotal.setText(cs.prixTotale(u_i));

      table.setItems(list);
    }    

   
    @FXML
    private void GoToArchive(ActionEvent event) throws IOException {
      
        AnchorPane pane=FXMLLoader.load(getClass().getResource("Archive_orders.fxml"));
        C.getChildren().setAll(pane);
    }

    @FXML
    private void GoToOrders(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("Orders.fxml"));
        C.getChildren().setAll(pane);
        

        
        /*
        Parent orderParent = FXMLLoader.load(getClass().getResource("Orders.fxml"));
        Scene orderScene = new Scene(orderParent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderScene);
        window.show();*/
         
    }



    
}
