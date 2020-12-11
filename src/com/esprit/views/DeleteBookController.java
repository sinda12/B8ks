/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import com.B8ks.entities.Book;
import com.esprit.services.ServicesBook;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gar4a
 */
public class DeleteBookController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private Button Supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Supprimer.setOnAction(e ->{
            ServicesBook sb = new ServicesBook();
            Book b = new Book();
            b.setId(Integer.parseInt(id.getText()));
            sb.supprimer(b);
            JOptionPane.showMessageDialog(null, "Livre supprimé !");
        });
    }    
    
}
