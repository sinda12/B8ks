package com.esprit.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import com.esprit.cache.UserCache;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.esprit.entities.Order;
import com.esprit.services.ServiceOrder;
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
public class OrdersController implements Initializable {
    
    int u_i=UserCache.id;

    @FXML
    private Button panier;
    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order, String> book;

    @FXML
    private TableColumn<Order, Double> price;

    @FXML
    private TableColumn<Order, Integer> quntity;

    @FXML
    private TableColumn<Order, String> status;

    ServiceOrder cs = new ServiceOrder();
    @FXML
    private AnchorPane C;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Order> ab=new ArrayList<>();
        ab = cs.getOrdersClient(u_i);
        
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        quntity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        table.getItems().addAll(ab);
    } 
    
        public ObservableList<Order> getItems() {
        ObservableList<Order> list = FXCollections.observableArrayList();
        list.addAll(cs.getOrdersClient(u_i));
        System.out.println(cs.getOrdersClient(u_i));
        return list;
    }
       

    @FXML
    private void GoToCart(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("../views/CartInterface.fxml"));
        C.getChildren().setAll(pane);
    }
    
}
