package com.esprit;

import com.esprit.views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) {
try{
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.showSignUp();
}
catch (Exception e){
    e.printStackTrace();
}

    }
}
