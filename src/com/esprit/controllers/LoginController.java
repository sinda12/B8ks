package com.esprit.controllers;



import com.esprit.cache.UserCache;
import com.esprit.entities.User;
import com.esprit.services.ServiceUser;
import com.esprit.utils.Mail;
import com.esprit.utils.Tools;
import com.esprit.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class LoginController extends BaseController implements Initializable {

    private static String code = "";

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
    public void signIn(ActionEvent ac) {
        v.showSignIn(ac);
    }
    @FXML
    void signUp(ActionEvent ac) throws IOException {
        if (test()) {
            
            User s = su.login(this.idEmail.getText(), idPassword.getText());
            if (s != null && !s.getAdmin()) {
                                UserCache.id=s.getId();
                UserCache.nom=s.getNom();
                UserCache.adresse=s.getAdresse();
                UserCache.age=s.getAge();
                UserCache.email=s.getEmail();
                UserCache.mobile=s.getMobile();
                UserCache.password=idPassword.getText();
                System.out.println(BCrypt.hashpw(s.getPassword(), Tools.BCRYPT_SALT));
                UserCache.prenom=s.getPrenom();
                v.showMenu(ac);
                cancel();
                System.out.println(s);






            } else if (s != null && s.getAdmin()) {
                v.showListUser(ac);
                cancel();
            } else {
                idEmail.setText("");
                idPassword.setText("");
                v.showAlertWithHeaderText("user not found");
            }

        }
        else v.showAlertWithHeaderText("re-verifier les champs");


    }

    @FXML
    void cancel() {
        Stage s = (Stage) idBLogin.getScene().getWindow();
v.closeStage(s);
    }



    public Boolean test ()
    {
        if(idEmail.getText()!=""&&idEmail.getText().indexOf("@")!=-1  &&  idPassword.getText()!="")return true;
        else return false ;
    }


    @FXML
    void tfxcodebtn(ActionEvent event)throws Exception {

        this.code = randomcode();
        int count = 0;
        ServiceUser su = new ServiceUser();
        count = su.validateEmail(idEmail.getText());
        if (count != 0) {
            Mail.sendMail(idEmail.getText(), this.code);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/verification.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            VerificationController vc = loader.getController();
            vc.setCode(this.code);
            vc.setEmail(this.idEmail);
            Scene scene = new Scene(root);
            Stage registerStage = new Stage();
            registerStage.setTitle("Code verif");
            registerStage.setScene(scene);
            registerStage.show();
        } else {
            JOptionPane.showMessageDialog(null, "This email doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }



    }

    public static String randomcode() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String salt = BCrypt.gensalt();
        String pw_hash = BCrypt.hashpw("0101010101","$2a$10$TXaBV2h1b2jQlNlm6dU5we");
        String pw_hash0 = BCrypt.hashpw("0202020202", "$2a$10$TXaBV2h1b2jQlNlm6dU5we");
        String pw_hash1 = BCrypt.hashpw("01010101", BCrypt.gensalt());
        String pw_hash2 = BCrypt.hashpw("010101", BCrypt.gensalt());
        String pw_hash3 = BCrypt.hashpw("0101", BCrypt.gensalt());
        System.out.println("le salt est   "+salt);
        System.out.println("le passsee  "+pw_hash0);
        System.out.println("le passsee  "+pw_hash);
        System.out.println("le passsee  "+pw_hash2);
        System.out.println("le passsee  "+pw_hash3);
        System.out.println(BCrypt.checkpw("0101010101",pw_hash));

        System.out.println(BCrypt.checkpw("01010101",pw_hash1));
        System.out.println(BCrypt.checkpw("010101",pw_hash2));
        System.out.println(BCrypt.checkpw("0101",pw_hash3));

    }







}
