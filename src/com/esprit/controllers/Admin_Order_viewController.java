package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esprit.entities.Order;
import com.esprit.services.ServiceOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class Admin_Order_viewController implements Initializable {

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
    private Button button_find_byID;
    @FXML
    private Button supprimer;
    @FXML
    private TextField find_by_ID;
    private TextField order;
    @FXML
    private Label cart;

    Order o =new Order();
    ServiceOrder so = new ServiceOrder();
    @FXML
    private TextField tp;
    @FXML
    private TextField s;
    @FXML
    private Label u;
    @FXML
    private Button showAll;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Order> ab=new ArrayList<>();
        ab = so.afficherO();
        order_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Order_id"));
        cart_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Cart_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("user_id"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("TotalPrice"));
        table.getItems().addAll(ab);
    }    



    @FXML
    private void delete(ActionEvent event) {
        Order orderSelected=table.getSelectionModel().getSelectedItem();
        so.supprimerO(orderSelected);
        UpdateTable();
    }

    @FXML
    private void updateAdmin(ActionEvent event) {
         List<Order> ab=new ArrayList<>();
  
        so.modifierOAdmin(Integer.parseInt(cart.getText()), s.getText(),Double.parseDouble(tp.getText()) );
        ab = so.afficherO();
        order_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Order_id"));
        cart_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Cart_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("user_id"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("TotalPrice"));
        table.getItems().clear();
        table.getItems().addAll(ab);
    }
    
    
        public ObservableList<Order> getItems() {
        ObservableList<Order> list = FXCollections.observableArrayList();
        ServiceOrder so = new ServiceOrder();
        list.addAll(so.afficherO());
        System.out.println(so.afficherO());
        return list;}
        
    public void UpdateTable(){
         ServiceOrder so=new ServiceOrder();
        List<Order> ab=new ArrayList<>();
        ab= so.afficherO();

        ObservableList<Order> list = FXCollections.<Order>observableArrayList(ab);
       
     

        table.setItems(list);
    }

    @FXML
    private void search(ActionEvent event) {
        List<Order> ab=new ArrayList<>();
        ab = so.GetByIDuser(Integer.parseInt(find_by_ID.getText()));
        order_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Order_id"));
        cart_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Cart_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("user_id"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("TotalPrice"));
        table.getItems().clear();
        table.getItems().addAll(ab);
    }

    @FXML
    private void GetData(MouseEvent event) {
        
        setInput();
                Order ot = table.getSelectionModel().getSelectedItem();
            if (!(ot==null) ) { 

                setO(ot);

            }
        
    }
    
    public void setO(Order o) {
        this.o =o;
    }
    
    
    
    
    
    public void setInput (){
        cart.setText(String.valueOf(o.getCart_id()));
        u.setText(String.valueOf(o.getUser_id()));
        s.setText(String.valueOf(o.getStatus()));
        tp.setText(String.valueOf(o.getTotalPrice()));
        
                         }

    @FXML
    private void ShowAll(ActionEvent event) {
                 List<Order> ab=new ArrayList<>();
  
       
        ab = so.afficherO();
        order_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Order_id"));
        cart_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Cart_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("user_id"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("TotalPrice"));
        table.getItems().clear();
        table.getItems().addAll(ab);
        
    }
    
}
