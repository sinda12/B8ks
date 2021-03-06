package com.esprit.controllers;

import com.esprit.entities.Book;
import com.esprit.entities.UsedBook;
import com.esprit.services.CrudUsedBooks;
import com.esprit.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.event.ActionEvent;

public class ModifierUsedBooksController  extends BaseController implements Initializable {
	public ModifierUsedBooksController(ViewFactory v, String fxmlName) {
		super(v, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
	private Button btmmodif;
	@FXML
	private TextField idtext;
	@FXML
	private TextField titretext;
	@FXML
	private TextField prixtext;
	@FXML
	private TextField auteurtext;
	@FXML
	private TextField desctext;
	@FXML
	private TextField datetext;
	CrudUsedBooks aj2 = new CrudUsedBooks();

	// Event Listener on Button[#btmmodif].onAction
	@FXML
	public void Modifier(ActionEvent event) {
		aj2.modifier(new UsedBook(titretext.getText(),Double.valueOf(prixtext.getText()),auteurtext.getText(),desctext.getText(),datetext.getText()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  btmmodif.setOnAction(e ->{
		        UsedBook b = new UsedBook();
		        b.setId(Integer.parseInt(idtext.getText()));
		      
		        b.setTitre(titretext.getText());
		        b.setPrix(Double.parseDouble(prixtext.getText()));
		        b.setAuteur(auteurtext.getText());
		        b.setDescription(desctext.getText());
		        b.setDatepub(datetext.getText());
		        CrudUsedBooks sb = new CrudUsedBooks();
		        sb.modifier(b);
		        JOptionPane.showMessageDialog(null, "Livre modifi� !");
		        });
		    }



	}

