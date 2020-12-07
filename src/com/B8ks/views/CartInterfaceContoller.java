/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;
    
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import com.B8ks.controller.BaseController;
import com.B8ks.entities.Cart;
import com.B8ks.service.CartService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 *
 * @author sinda
 */
public class CartInterfaceContoller extends BaseController implements Initializable{
    
    @FXML
    private TableView<?> table;

    
    @FXML
    private TableColumn<Cart, String> book;

    @FXML
    private TableColumn<Cart, Double> price;

    @FXML
    private TableColumn<Cart, Integer> quntity;

    @FXML
    private Label prixTotal;

    @FXML
    private Button commander;

    @FXML
    private Button clear;

    @FXML
    private Button supprimer;

    @FXML
    private Button retour;

    public void UpdateTable(){
        CartService cs=new CartService();
        List<Cart> ab=new ArrayList<>();
        ab= cs.afficherC();

        ObservableList<Cart> list = FXCollections.<Cart>observableArrayList(ab);

        table.setItems(list);
    }    
    
    @FXML
    void delete(ActionEvent event) {
        CartService cs=new CartService();
        Cart cartSelected=(Cart) table.getSelectionModel().getSelectedItem();
        cs.supprimerC(cartSelected);
        UpdateTable();
        
        

    }

    public CartInterfaceContoller(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CartService cs=new CartService();
        List<Cart> ab =new ArrayList<>();
        ab=cs.afficherC();
        
        
        
        
       
    }



}
