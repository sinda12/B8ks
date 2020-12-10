/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.models.Claim;
import com.esprit.services.ServiceClaim;
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
public class ShowClaimsController extends BaseController implements Initializable {

    @FXML
    private TableView<Claim> table;
    @FXML
    private TableColumn<Claim, String> col_username;
    @FXML
    private TableColumn<Claim, String> col_claim;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_update;
    
    
    
    ViewFactory vf = new ViewFactory();

    public ShowClaimsController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              ServiceClaim sr=new ServiceClaim();
        List<Claim> ab=new ArrayList<>();
        ab = sr.show();
        col_username.setCellValueFactory(new PropertyValueFactory<Claim, String>("UserID"));
        col_claim.setCellValueFactory(new PropertyValueFactory<Claim, String>("description"));
        table.getItems().addAll(ab);
    }    
    
        public ObservableList<Claim> getItems() {
        ObservableList<Claim> list = FXCollections.observableArrayList();
        ServiceClaim sc = new ServiceClaim();
        list.addAll(sc.show());
        System.out.println(sc.show());
        return list;
    }
        
            public void UpdateTable(){
         ServiceClaim sr=new ServiceClaim();
        List<Claim> ab=new ArrayList<>();
        ab= sr.show();
        ObservableList<Claim> list = FXCollections.<Claim>observableArrayList(ab);
        table.setItems(list);
    }

    @FXML
    private void delete(ActionEvent event) {
                   ServiceClaim sc =new ServiceClaim();
                     Claim orderSelected=table.getSelectionModel().getSelectedItem();
                     sc.delete(orderSelected);
                        UpdateTable();
    }

    @FXML
    private void update(ActionEvent event) {
        vf.ShowUpdateClaim();
        UpdateClaimController uc = vf.fxmlLoader.getController();
        uc.setDescription(table.getSelectionModel().getSelectedItem().getDescription());
        uc.setId_claim(table.getSelectionModel().getSelectedItem().getId());
    }
    
}
