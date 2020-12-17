package com.esprit.controllers;

import com.B8ks.entities.User;
import com.B8ks.service.ServiceUser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.esprit.controllers.ViewFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInController extends BaseController {
    @FXML
    private TextField idNom;

    @FXML
    private TextField idPrenom;

    @FXML
    private TextField idAge;

    @FXML
    private TextField idMobil;

    @FXML
    private TextField idAdresse;

    @FXML
    private TextField idEmail;

    @FXML
    private TextField idPasswordInscri;


    public SignInController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }




    ServiceUser us = new ServiceUser();


    @FXML
    void register() {
        if (validateEmail() & validateNom() & validatePassword() & validatePrenom() & validateTel() & validateFields()){
us.adduser(new User(Integer.valueOf(idMobil.getText()),Integer.valueOf(idAge.getText()),idNom.getText(),idPrenom.getText(),idAdresse.getText(),idEmail.getText(),idPasswordInscri.getText()));
idNom.clear();idAge.clear();idMobil.clear();idEmail.clear();idPasswordInscri.clear();idAdresse.clear();idPrenom.clear();
v.showAlertWithHeaderText("Ajout reussi !!");
v.showSignUp();
cancelInscri();
}
else v.showAlertWithHeaderText("les champs sont vides");
    }


    @FXML
    void cancelInscri() {
Stage stage = (Stage) idNom.getScene().getWindow();
v.closeStage(stage);

    }

    Boolean test1 ()
    {
       return idNom.getText().isEmpty() || idPrenom.getText().isEmpty()
                || idAdresse.getText().isEmpty() || idPasswordInscri.getText().isEmpty() || idEmail.getText().isEmpty()
                || idMobil.getText().isEmpty() || idAge.getText().isEmpty()   ;
    }


    private boolean validateEmail() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(idEmail.getText());
        if (m.find() && m.group().equals(idEmail.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Email");
            alert.showAndWait();
            return false;
        }
    }

    private boolean validateTel() {
        Pattern p = Pattern.compile("[2-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]+");
        Matcher m = p.matcher(idMobil.getText());
        if (m.find() && m.group().equals(idMobil.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Tel Number");
            alert.showAndWait();
            return false;
        }
    }

    private boolean validateNom() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(idNom.getText());
        if (m.find() && m.group().equals(idNom.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate name");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid name ");
            alert.showAndWait();
            return false;
        }
    }

    private boolean validatePrenom() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(idPrenom.getText());
        if (m.find() && m.group().equals(idPrenom.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate prenom");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid prenom ");
            alert.showAndWait();
            return false;
        }
    }

    private boolean validatePassword() {
        Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
        Matcher m = p.matcher(idPasswordInscri.getText());
        if (m.find() && m.group().equals(idPasswordInscri.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate password");
            alert.setHeaderText(null);
            alert.setContentText("Password must contain at least one(Digit,Lowercase, Uppercase and Specials charac");
            alert.showAndWait();
            return false;
        }
    }

    private boolean validateFields() {
        if (idNom.getText().isEmpty() | idPrenom.getText().isEmpty() |
                idEmail.getText().isEmpty() | idMobil.getText().isEmpty() |  idAdresse.getText().isEmpty() | idPasswordInscri.getText().isEmpty() ) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter into fields ");
            alert.showAndWait();

            return false;
        }else
            return true;
    }






   /* boolean test2()
    {
        if (Integer.valueOf(idNom.getText()) ) ;
    }*/
}
