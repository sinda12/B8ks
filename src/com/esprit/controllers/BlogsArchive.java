package com.esprit.controllers;

import com.esprit.entities.Blog;
import com.esprit.services.BlogService;
import com.esprit.utils.Draft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BlogsArchive  implements Initializable {
    public VBox vboxBlogList;
    @FXML
    private TableView<Blog> Archive_table;

    @FXML
    private TableColumn<Blog, String> archive_title;

    @FXML
    private TableColumn<Blog, String> archive_category;

    @FXML
    private TableColumn<Blog, String> archive_author;

    @FXML
    private TableColumn<Blog, String> archive_date;

    @FXML
    private AnchorPane pane;

BlogService bs = new BlogService();


    private ObservableList<Blog> archiveData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BlogService blogService = new BlogService();
        vboxBlogList.getChildren().removeAll(vboxBlogList.getChildren());

        try {
                blogService.getAll().forEach(b -> {
                    ImageView showIV = new ImageView(new Image(getClass().getResourceAsStream("/com/esprit/views/show.png")));
                    ImageView deleteIV = new ImageView(new Image(getClass().getResourceAsStream("/com/esprit/views/delete.png")));
                    showIV.setFitHeight(30);
                    showIV.setFitWidth(30);
                    deleteIV.setFitHeight(30);
                    deleteIV.setFitWidth(30);
                    showIV.setPreserveRatio(true);
                    HBox hBox = new HBox();
                    hBox.setSpacing(100);
                    hBox.getStyleClass().add("line");

                    Label titleLabel = new Label(b.getTitle());
                    titleLabel.setPrefSize(100, 50);
                    titleLabel.setPadding(new Insets(0, 0, 0, 30));
                    Label categoryLabel = new Label(b.getCategory());
                    categoryLabel.setPrefSize(100, 50);

                    Label authorLabel = new Label("aymen");
                    authorLabel.setPrefSize(100, 50);

                    Label dateLabel = new Label(b.getDate());
                    dateLabel.setPrefSize(150, 50);
                    dateLabel.setPadding(new Insets(0, 0, 0, 20));
                    Button showButton = new Button();
                    showButton.setGraphic(showIV);
                    showButton.setStyle("-fx-background-color: rgba(0,0,0,0);");
                    showButton.setPrefSize(30, 30);
                    showButton.setOnAction(event -> {
                        try {
                            Draft.blog = b;
                            VBox anchorPane = FXMLLoader.load(getClass().getResource("../views/blog.fxml"));
                            pane.getChildren().setAll(anchorPane);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    Button deleteButton = new Button();
                    deleteButton.setGraphic(deleteIV);
                    deleteButton.setPrefSize(30, 30);

                    deleteButton.setStyle("-fx-background-color: rgba(0,0,0,0);");
                    deleteButton.setOnAction(event -> {
                        try {
                            blogService.deleteById(b.getId());
                            initialize(null, null);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    });
                    HBox actionBox = new HBox();
                    actionBox.getChildren().add(showButton);
                    actionBox.getChildren().add(deleteButton);
                    actionBox.setAlignment(Pos.CENTER);
                    hBox.setPadding(new Insets(10));
                    hBox.getChildren().add(titleLabel);
                    hBox.getChildren().add(categoryLabel);
                    hBox.getChildren().add(authorLabel);
                    hBox.getChildren().add(dateLabel);
                    hBox.getChildren().add(actionBox);

                    vboxBlogList.getChildren().add(hBox);

                });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }




    public void delete(ActionEvent actionEvent) {
        BlogService blogService = new BlogService();
        try {
            Blog b = Archive_table.getSelectionModel().getSelectedItem();
            blogService.deleteById(b.getId());
            Archive_table.getItems().remove(b);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void add(ActionEvent actionEvent) {
        try {
            VBox anchorPane = FXMLLoader.load(getClass().getResource("../views/Createblog.fxml"));
            pane.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
