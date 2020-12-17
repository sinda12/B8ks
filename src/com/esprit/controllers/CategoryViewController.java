package com.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import Entity.Category;
import Entity.usedbook;
import Services.crudcategory;
import Views.ViewFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;
import Services.CrudUsedBooks;
import javafx.scene.control.TextArea;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class CategoryViewController  extends BaseController implements Initializable {
	public CategoryViewController(ViewFactory v, String fxmlName) {
		super(v, fxmlName);
		// TODO Auto-generated constructor stub
	}
	private ObservableList <Category> CategoryData = FXCollections.observableArrayList();

	@FXML
	private TextField cstitre;
	@FXML
	private Button btcajouter;
	@FXML
	private Button btcsup;
	@FXML
	private Button btcmodif;
	@FXML
	private Button btccherch;
	@FXML
	private TableView <Category> tableau;
	@FXML
	private TableColumn <Category,String>coltitre;
	crudcategory aj = new crudcategory();
	// Event Listener on Button[#btcajouter].onAction
	@FXML
	public void ajouter(ActionEvent event) {
		if (cstitre.getText().trim().length() > 0){
			aj.ajouter(new Category(cstitre.getText()));
			
			 CategoryData.addAll(aj.afficher());

		        System.out.println(CategoryData);
		        tableau.setItems(CategoryData);

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
		/*aj.ajouter(new Category(cstitre.getText()));
		
		 CategoryData.addAll(aj.afficher());

	        System.out.println(CategoryData);
	        tableau.setItems(CategoryData);*/
	}
	// Event Listener on Button[#btcsup].onAction
	@FXML
	public void supprimer(ActionEvent event) {
		Category Ub = new Category();
		Ub.setId(tableau.getSelectionModel().getSelectedItem().getId());
		aj.supprimer(Ub);
		int selectedIndex = tableau.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
            tableau.getItems().remove(selectedIndex);
	}
	// Event Listener on Button[#btcmodif].onAction
	@FXML
	ViewFactory vf3 = new ViewFactory();

	public void modifier(ActionEvent event) {
		vf3.showModifierCategory();
		CategoryViewController af1 = vf3.fxmlLoader.getController();	}
	// Event Listener on Button[#btccherch].onAction
	@FXML
	public void suivant(ActionEvent event) {
		vf3.showUsedBooksView();
		CategoryViewController af1 = vf3.fxmlLoader.getController();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		coltitre.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getTitle()));
		
		
	      
		CategoryData.addAll(aj.afficher());
System.out.println(aj.afficher());
		        System.out.println(CategoryData);
		        tableau.setItems(CategoryData);
		        /*idTableView.getSelectionModel().selectedItemProperty().addListener((a,b,c)->showPersonDetails(c));*/

		
	}
}
