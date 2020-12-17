package com.esprit.views;

import com.esprit.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStage ;
   public FXMLLoader fxmlLoader ;

    public ViewFactory() {
        activeStage = new ArrayList<Stage>();
    }

    public void initializeStage(BaseController baseController) {

         fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.show();
        activeStage.add(stage);


    }

public void showSignUp()
{
    BaseController b = new LoginController(this, "sign_up.fxml");
    initializeStage(b);

}

public void showSignIn()
{
    BaseController be = new SignInController(this, "sign_in.fxml");
    initializeStage(be);
}

public void showMenu()
{
    BaseController b = new MenuController(this,"menu.fxml");
    initializeStage(b);
}

public void showListUser()
    {
        BaseController b = new UsersController(this,"list_users.fxml");
        initializeStage(b);
    }

public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStage.remove(stageToClose);
    }

    public void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("login try");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);

        alert.showAndWait();
    }

 /*   public void showVerifMail()
    {

        BaseController b = new VerificationController(this,"verification.fxml");
        initializeStage(b);
    }*/
}
