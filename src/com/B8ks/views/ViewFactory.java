/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;

import com.B8ks.controller.BaseController;
import com.B8ks.controller.MenuController;
import com.B8ks.controller.SignInController;
import com.B8ks.controller.LoginController;
import com.B8ks.controller.OrderAfficheAdminController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sinda
 */
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
    
    public void showCart(ViewFactory v,String file)
    {
        BaseController c = new CartInterfaceContoller(this,"CartInterface.fxml") ;
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

public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStage.remove(stageToClose);
    }

public void showOrder ()
{
    BaseController b = new OrderAfficheAdminController(this,"OrderAfficheAdmin.fxml");
}
}
