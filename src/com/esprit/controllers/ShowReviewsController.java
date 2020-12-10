/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.controllers.BaseController;
import com.esprit.models.Review;
import com.esprit.models.User;
import com.esprit.services.ServiceReview;
import com.esprit.views.ViewFactory;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ShowReviewsController extends BaseController implements Initializable {

    @FXML
    private TableView<Review> table;
    @FXML
    private TableColumn<Review, User> col_username;
    @FXML
    private TableColumn<Review, String> col_review;
    @FXML
    private TableColumn<Review, String> col_reviewdate;
    @FXML
    private TableColumn<Review, Integer> col_rate;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_refresh;
    
    ViewFactory vf = new ViewFactory();

    public ShowReviewsController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceReview sr=new ServiceReview();
        List<Review> ab=new ArrayList<>();
        ab = sr.show();
        col_username.setCellValueFactory(new PropertyValueFactory<Review, User>("UserID"));
        col_review.setCellValueFactory(new PropertyValueFactory<Review, String>("review"));
        col_reviewdate.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewDate"));
        col_rate.setCellValueFactory(new PropertyValueFactory<Review, Integer>("rate"));
        table.getItems().addAll(ab);
    }    
    
     public ObservableList<Review> getItems() {
        ObservableList<Review> list = FXCollections.observableArrayList();
        ServiceReview sr = new ServiceReview();
        list.addAll(sr.show());
        System.out.println(sr.show());
        return list;
    }
     
     public void UpdateTable(){
         ServiceReview sr=new ServiceReview();
        List<Review> ab=new ArrayList<>();
        ab= sr.show();

        ObservableList<Review> list = FXCollections.<Review>observableArrayList(ab);
       
     

        table.setItems(list);
    }

    @FXML
    private void delete(ActionEvent event) {
            ServiceReview sr =new ServiceReview();
             Review orderSelected=table.getSelectionModel().getSelectedItem();
                sr.delete(orderSelected);
                UpdateTable();
    }

    @FXML
    private void refresh(ActionEvent event) {
                vf.ShowUpdatReview();
        UpdateReviewController ur = vf.fxmlLoader.getController();
        ur.setDescription(table.getSelectionModel().getSelectedItem().getReview());
        ur.setChoicebox(table.getSelectionModel().getSelectedItem().getRate());
        ur.setId_review(table.getSelectionModel().getSelectedItem().getId());
    }
    
}
