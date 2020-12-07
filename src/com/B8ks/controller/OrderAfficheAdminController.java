/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.controller;

import com.B8ks.cache.UserCache;
import com.B8ks.views.*;
import com.B8ks.entities.Order;
import com.B8ks.entities.User;
import com.B8ks.service.ServiceOrder;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class OrderAfficheAdminController extends BaseController implements Initializable {

    @FXML
    private TableView<Order> table;
    @FXML
    private TableColumn<Order, Integer> order_id;
    @FXML
    private TableColumn<Order, Integer> cart_id;
    @FXML
    private TableColumn<Order, Integer> user_id;
    @FXML
    private TableColumn<Order, String> status;
    @FXML
    private TableColumn<Order, Float> totalPrice;
    @FXML
    private TextField find_by_ID;
    @FXML
    private Button button_find_byID;
    @FXML
    private TextField order;
    @FXML
    private TextField tprice;
    @FXML
    private TextField stat;
    @FXML
    private TextField user;
    @FXML
    private TextField cart;
    Order o =new Order();
    ServiceOrder so = new ServiceOrder();
    @FXML
    private Button supprimer;
    @FXML
    private Button Actualiser;
    @FXML
    private Button Clear;
    private Button Ajouter;
    @FXML
    private Button add;

    public OrderAfficheAdminController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }
    
    
    
    

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       

        ServiceOrder so=new ServiceOrder();
        List<Order> ab=new ArrayList<>();
        ab = so.afficherO();
        order_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Order_id"));
        cart_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Cart_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("User"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("TotalPrice"));
        table.getItems().addAll(ab);
        
                add.setOnAction(e -> {
            add_meth();
            JOptionPane.showMessageDialog(null, "Order Created!");
        });
        
        
    }
    public ObservableList<Order> getItems() {
        ObservableList<Order> list = FXCollections.observableArrayList();
        ServiceOrder so = new ServiceOrder();
        list.addAll(so.afficherO());
        System.out.println(so.afficherO());
        return list;
    }
    public void UpdateTable(){
         ServiceOrder so=new ServiceOrder();
        List<Order> ab=new ArrayList<>();
        ab= so.afficherO();

        ObservableList<Order> list = FXCollections.<Order>observableArrayList(ab);
       
     

        table.setItems(list);
    }
    




    @FXML
    private void delete(ActionEvent event) {
        Order orderSelected=table.getSelectionModel().getSelectedItem();
        so.supprimerO(orderSelected);
        UpdateTable();

        
        
    }

    @FXML
    private void actualiser(ActionEvent event) {
        UpdateTable();
    }

    @FXML
    private void Clear(ActionEvent event) {
                 ServiceOrder so=new ServiceOrder();
        List<Order> ab=new ArrayList<>();
        ab = so.afficherO();
        order_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Order_id"));
        cart_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Cart_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("User"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("TotalPrice"));
        table.getItems().clear();
    }

    @FXML
    private void add_meth() {
        User s = new User();
        s.setId(UserCache.id);
    so.ajouterO((new Order(Integer.valueOf(cart.getText()),s,stat.getText(),Float.valueOf(tprice.getText()))));
    UpdateTable();
    
    }
    
    
}
