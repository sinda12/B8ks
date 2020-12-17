package com.esprit.controllers;


import com.B8ks.entities.User;
import com.B8ks.service.ServiceUser;
import com.esprit.views.ViewFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class UsersController extends BaseController implements Initializable {

    @FXML
    private TableView<User> idTableView;

    @FXML
    private TableColumn<User, String> idTableColN;

    @FXML
    private TableColumn<User, String> idTableColPrenom;

    @FXML
    private Label idNom;

    @FXML
    private Label idPrenom;

    @FXML
    private Label idMobile;

    @FXML
    private Label idAge;

    @FXML
    private Label idAdresse;

    @FXML
    private Label idEmail;

    @FXML
    private Label idRole;


    private ObservableList<User> userData = FXCollections.observableArrayList();

    ServiceUser us = new ServiceUser();

    public UsersController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idTableColN.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNom()));
        idTableColPrenom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrenom()));

        userData.addAll(us.getList());
        System.out.println(userData);
        idTableView.setItems(userData);

        idTableView.getSelectionModel().selectedItemProperty().addListener((a, b, c) -> showPersonDetails(c));

    }

    private void showPersonDetails(User user) {
        if (user != null) {

            idNom.setText(user.getNom());
            idPrenom.setText(user.getPrenom());
            idAdresse.setText(user.getAdresse());
            idAge.setText(Integer.toString(user.getAge()));
            idEmail.setText(user.getEmail());
            idMobile.setText(Integer.toString(user.getMobile()));
            if (user.getAdmin()) idRole.setText("Admin");
            else idRole.setText("User");


        } else {

            idNom.setText("");
            idPrenom.setText("");
            idAdresse.setText("");
            idAge.setText("");
            idEmail.setText("");
            idMobile.setText("");
            idRole.setText("");
        }
    }


    @FXML
    void ajouterUser(ActionEvent event) {

    }

    @FXML
    void modifierUser(ActionEvent event) {

    }

    @FXML
    void suppreimerUser(ActionEvent event) {
        int selectedIndex = idTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            idTableView.getItems().remove(selectedIndex);
            us.delete(idTableView.getSelectionModel().getSelectedItem().getId());
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    void cancel(ActionEvent event) {

        Stage stage = (Stage) idRole.getScene().getWindow();
        v.closeStage(stage);
        v.showSignUp();

    }
}