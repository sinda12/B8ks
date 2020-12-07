package com.B8ks.controller;

import com.B8ks.cache.UserCache;
import com.B8ks.controller.BaseController;
import com.B8ks.entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.B8ks.service.ServiceUser;
import com.B8ks.views.ViewFactory;


public class LoginController extends BaseController {

    public LoginController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }

    @FXML
    private TextField idEmail;

    @FXML
    private TextField idPassword;

    @FXML
    private Button idBLogin;

ServiceUser su = new ServiceUser();

    @FXML
    public void order() {
        v.showSignIn();
    }
    @FXML
    void signUp() {
        User s =su.login(this.idEmail.getText(),idPassword.getText());
        if (s!=null) {v.showMenu();
        System.out.println(s);
        MenuController m = v.fxmlLoader.getController();
        m.setIdUser(s.getId());
        UserCache.id=s.getId();
        m.setIdNom(s.getNom());
        UserCache.nom=s.getNom();
        m.setIdAdresse(s.getAdresse());
        UserCache.adresse=s.getAdresse();
        m.setIdAge(s.getAge());
        UserCache.age=s.getAge();
        m.setIdEmail(s.getEmail());
        UserCache.email=s.getEmail();
        m.setIdMobil(s.getMobile());
        UserCache.mobile=s.getMobile();
        m.setIdPasswordInscri(s.getPassword());
        UserCache.password=s.getPassword();
        m.setIdPrenom(s.getPrenom());
        UserCache.prenom=s.getPrenom();



        }
        else {idEmail.setText("");
        idPassword.setText("");
        }

    }
}
