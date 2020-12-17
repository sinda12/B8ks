package com.esprit.controllers;

import com.esprit.controllers.BaseController;
import com.esprit.entities.UsedBook;
import com.esprit.services.CrudUsedBooks;
import com.esprit.views.ViewFactory;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

import static javafx.collections.FXCollections.observableArrayList;


public class UsedBooksViewController extends BaseController implements Initializable{
	public UsedBooksViewController(ViewFactory v, String fxmlName) {
		super(v, fxmlName);
		// TODO Auto-generated constructor stub
	}
	private ObservableList <UsedBook> usedbookData = observableArrayList();
	@FXML
	private TextField lstitre;
	@FXML
	private TextField lsprix;
	@FXML
	private TextField lsauteur;
	@FXML
	private TextArea lsdesc;
	@FXML
	private TextField lsdate;
	@FXML
	private Button btmajouter;
	
	@FXML
	private Button btmaffich;
	@FXML
	private Button btmsup;
	@FXML
	private Button btmmodif;
	@FXML
	private Button btmcherch;
	@FXML
	private TableView <UsedBook> tableau;
	@FXML
	private TableColumn <UsedBook,String> cltitre;
	@FXML
	private TableColumn <UsedBook,String>  clprix;
	@FXML
	private TableColumn <UsedBook,String> clauteur;
	@FXML
	private TableColumn<UsedBook,String>  cldesc;
	@FXML
	private TableColumn <UsedBook,String> cldate;
	CrudUsedBooks aj2 = new CrudUsedBooks();
	// Event Listener on Button[#btmajouter].onAction
	@FXML
	public void ajouter(ActionEvent event) {
		if (lstitre.getText().trim().length() > 0 && lsprix.getText().trim().length()> 0
				&& lsauteur.getText().trim().length() > 0 && lsdesc.getText().trim().length() > 0
				&& lsdate.getText().trim().length() > 0){
			aj2.ajouter(new UsedBook(lstitre.getText(),Double.valueOf(lsprix.getText()),lsauteur.getText(),lsdesc.getText(),lsdate.getText()));
			usedbookData.clear();
			 usedbookData.addAll(aj2.afficher());

		        System.out.println(usedbookData);
		        tableau.setItems(usedbookData);
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Review created !!");
         alert.setHeaderText(null);
         alert.setContentText("Review created successfully !!");
         alert.showAndWait();
     }else{
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("TextField is empty !!");
         alert.setHeaderText(null);
         alert.setContentText("Please Write Something !!");
         alert.showAndWait();
          }
		
	}
	// Event Listener on Button[#btmaffich].onAction
	@FXML
	public void afficher(ActionEvent event) {
		aj2.afficher();
	}
	// Event Listener on Button[#btmsup].onAction
	@FXML
	public void supprimer(ActionEvent event) {
		UsedBook Ub = new UsedBook();
		Ub.setId(tableau.getSelectionModel().getSelectedItem().getId());
		aj2.supprimer(Ub);
		int selectedIndex = tableau.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
            tableau.getItems().remove(selectedIndex);
	
	}
	// Event Listener on Button[#btmmodif].onAction
	@FXML
	ViewFactory vf3 = new ViewFactory();

	public void Modifier(ActionEvent event) {
		//vf3.showModifierUsedBooks();
		UsedBooksViewController af1 = vf3.fxmlLoader.getController();
	}
	// Event Listener on Button[#btmcherch].onAction
	ViewFactory vf2 = new ViewFactory();
	@FXML
	public void chercher(ActionEvent event) {
		//vf2.showCategoryView();
		CategoryViewController af = vf2.fxmlLoader.getController();
	}
	@Override
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		


		cltitre.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getTitre()));
		clprix.setCellValueFactory(c->new SimpleStringProperty(String.valueOf(c.getValue().getPrix())));
		clauteur.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getAuteur()));
		cldesc.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getDescription()));
		cldate.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getDatepub()));
      
		usedbookData.addAll(aj2.afficher());
System.out.println(aj2.afficher());
		        System.out.println(usedbookData);
		        tableau.setItems(usedbookData);
		        /*idTableView.getSelectionModel().selectedItemProperty().addListener((a,b,c)->showPersonDetails(c));*/

		    }		
	}

