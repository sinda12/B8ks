/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class InputValidationController implements Initializable {

    @FXML
    private TextField numbers;
    @FXML
    private TextField array;
    @FXML
    private Button valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valider.setOnAction(e -> {
            if(!numbers.getText().matches("^\\d+$")){
                //when it not matches the pattern (1.0 - 6.0)
                //set the textField empty
                System.out.println("Not numbers");
            }
         else
                System.out.println("Numbers");
        

    });

    }    
    
}
