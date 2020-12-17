package com.esprit.controller;

import com.esprit.services.ServiceUser;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class pwdController {

    @FXML
    private PasswordField idNouvPass;

    @FXML
    private PasswordField idConfirmePass;
    private String eMail;

    ServiceUser us = new ServiceUser();


    @FXML
    void BtnChange() {

if(idConfirmePass == idConfirmePass)
{
us.setPassword(eMail,idConfirmePass.getText());
}

    }


    public void setEmail(String email) {
        this.eMail=email;
    }
}
