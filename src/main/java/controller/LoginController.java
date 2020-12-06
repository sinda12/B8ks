package controller;

import controller.BaseController;
import entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.ServiceUser;
import views.ViewFactory;


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
    public void signIn() {
        v.showSignIn();
    }
    @FXML
    void signUp() {
        User s =su.login(this.idEmail.getText(),idPassword.getText());
        if (s!=null) {v.showMenu();
        System.out.println(s);
        MenuController m = v.fxmlLoader.getController();
        m.setIdUser(s.getId());
        m.setIdNom(s.getNom());
        m.setIdAdresse(s.getAdresse());
        m.setIdAge(s.getAge());
        m.setIdEmail(s.getEmail());
        m.setIdMobil(s.getMobile());
        m.setIdPasswordInscri(s.getPassword());
        m.setIdPrenom(s.getPrenom());



        }
        else {idEmail.setText("");
        idPassword.setText("");
        }

    }
}
