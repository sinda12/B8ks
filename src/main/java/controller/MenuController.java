package controller;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.ServiceUser;
import views.ViewFactory;

public class MenuController extends BaseController {

private int idUser ;
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

    @FXML
    void modifier(ActionEvent event) {
       User s = su.modify(new User(idUser,Integer.valueOf(idMobil.getText()),Integer.valueOf(idAge.getText()),idNom.getText(),idPrenom.getText(),idAdresse.getText(),idEmail.getText(),idPasswordInscri.getText()));
       System.out.println(s);
    }

    public MenuController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    public void setIdNom(String idNom) {
        this.idNom.setText(idNom);
    }

    public void setIdPrenom(String idPrenom) {
        this.idPrenom.setText(idPrenom);
    }

    public void setIdAge(int idAge) {
        this.idAge.setText(idAge+"");
    }

    public void setIdMobil(int idMobil) {
        this.idMobil.setText(idMobil+"");
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse.setText(idAdresse);
    }

    public void setIdEmail(String idEmail) {
        this.idEmail.setText(idEmail);
    }

    public void setIdPasswordInscri(String idPasswordInscri) {
        this.idPasswordInscri.setText(idPasswordInscri);
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
