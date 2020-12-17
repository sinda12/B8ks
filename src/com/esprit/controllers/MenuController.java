package com.esprit.controllers;



import com.esprit.cache.UserCache;
import com.esprit.entities.User;
import com.esprit.services.ServiceUser;
import com.esprit.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuController extends BaseController implements Initializable {

    private int idUser;
    @FXML
    private Button idEditB;

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


    ServiceUser su = new ServiceUser();
String pass ;
    public MenuController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    @FXML
    void modifier(ActionEvent event) {
        if (validateEmail() & validateNom() &  validatePrenom() & validateTel() & validateFields()) {
            if(idPasswordInscri.getText()=="") pass = UserCache.password;
            else pass = idPasswordInscri.getText();
            User s = su.modify(new User(idUser, Integer.valueOf(idMobil.getText()), Integer.valueOf(idAge.getText()), idNom.getText(), idPrenom.getText(), idAdresse.getText(), idEmail.getText(), idPasswordInscri.getText(), null));
            v.showAlertWithHeaderText("Modification reussite !!");
            idMobil.clear();
            idAdresse.clear();
            idNom.clear();
            idPrenom.clear();
            idAge.clear();
            idEmail.clear();
            idPasswordInscri.clear();
        } else
            v.showAlertWithHeaderText("les champs sont vides");
    }


    private boolean validateEmail() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(idEmail.getText());
        if (m.find() && m.group().equals(idEmail.getText())) {
            return true;
        } else {
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
        if (m.find() && m.group().equals(idMobil.getText())) {
            return true;
        } else {
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
        if (m.find() && m.group().equals(idNom.getText())) {
            return true;
        } else {
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
        if (m.find() && m.group().equals(idPrenom.getText())) {
            return true;
        } else {
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
        if (m.find() && m.group().equals(idPasswordInscri.getText())) {
            return true;
        } else {
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
                idEmail.getText().isEmpty() | idMobil.getText().isEmpty() | idAdresse.getText().isEmpty() | idPasswordInscri.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter into fields ");
            alert.showAndWait();

            return false;
        } else
            return true;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("siiiiinnnddaaaaaaa");
        this.idNom.setText(UserCache.nom);
        this.idPrenom.setText(UserCache.prenom);
        this.idAge.setText(UserCache.age + "");
        this.idMobil.setText(UserCache.mobile + "");
            this.idAdresse.setText(UserCache.adresse);
            this.idEmail.setText(UserCache.email);
        this.idUser = UserCache.id;
    }
}