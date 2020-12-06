package controller;

import controller.BaseController;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceUser;
import views.ViewFactory;

public class SignInController extends BaseController {
    @FXML
    private TextField idNom;

    @FXML
    private TextField idPrenom;

    @FXML
    private TextField idAge;

    @FXML
    private TextField idMobile;

    @FXML
    private TextField idAdresse;

    @FXML
    private TextField idEmail;

    @FXML
    private TextField idPasswordInscri;

    @FXML
    private Button idInscriButton;


    public SignInController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }




    ServiceUser us = new ServiceUser();



    @FXML
    void register(ActionEvent actionEvent) {
  us.adduser(new User(Integer.valueOf(idMobile.getText()),Integer.valueOf(idAge.getText()),idNom.getText(),idPrenom.getText(),idAdresse.getText(),idEmail.getText(),idPasswordInscri.getText()));
    }
    @FXML
    void cancelInscri() {
Stage stage = (Stage) idNom.getScene().getWindow();
v.closeStage(stage);
    }
}
