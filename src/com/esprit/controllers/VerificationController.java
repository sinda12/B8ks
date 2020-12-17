package com.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class VerificationController /*extends BaseController*/ implements Initializable {
    @FXML
    private Button codebtn;
    private String code = "";
    private String Email;

    @FXML
    private TextField codeText;

   /* public VerificationController(ViewFactory v, String fxmlName) {
        super(v, fxmlName);
    }*/


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    void tfxcodebtn(ActionEvent event) {
System.out.println(this.code+" === "+codeText.getText());
        if (this.code.equals(codeText.getText())) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/pwd.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage registerStage = new Stage();
                registerStage.setTitle("Reset password");
                registerStage.setScene(scene);
                registerStage.show();
                pwdController vc = loader.getController();
                vc.setEmail(this.Email);
                Stage s = (Stage) codeText.getScene().getWindow();
                s.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect verification code", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }



    public void setCode(String x) {
        this.code = x;
    }

    public void setEmail(TextField idEmail) {
        this.Email=idEmail.getText();
    }
}
