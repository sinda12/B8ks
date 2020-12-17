package com.esprit.controllers;

import com.esprit.controllers.BaseController;
import com.esprit.entities.Category;
import com.esprit.services.crudcategory;
import com.esprit.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.event.ActionEvent;

public class ModifierCategoryController extends BaseController implements Initializable {
	public ModifierCategoryController(ViewFactory v, String fxmlName) {
		super(v, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
	private Button modifbtm;
	@FXML
	private TextField idcs;
	@FXML
	private TextField titrecs;
	crudcategory aj = new crudcategory();
	// Event Listener on Button[#modifbtm].onAction
	@FXML
	public void modifier(ActionEvent event) {
		aj.modifier(new Category(titrecs.getText()));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 modifbtm.setOnAction(e ->{
		        Category b = new Category();
		        b.setId(Integer.parseInt(idcs.getText()));
		      
		        b.setTitle_cat(titrecs.getText());
		        crudcategory sb = new crudcategory();
		        sb.modifier(b);
		        JOptionPane.showMessageDialog(null, "Cat�gorie Modifi� !");
		   });
    }



}
		 