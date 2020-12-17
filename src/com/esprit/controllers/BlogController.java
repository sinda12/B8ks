package com.esprit.controllers;

import com.esprit.entities.Blog;
import com.esprit.entities.Comment;
import com.esprit.entities.UserCache;
import com.esprit.services.BlogService;
import com.esprit.services.CommentService;
import com.esprit.utils.Draft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BlogController  implements Initializable {
    public VBox commentBox;
    public TextArea commentInput;
    public VBox pane;
    int v=1,v2=1;
    int sum=0;
    Blog b;

    @FXML
    private Font x1;


    @FXML
    private TextArea textareablog_id;

    @FXML
    private Label blogger_name_id;

    @FXML
    private Label posted_timing_id;


    @FXML
    private Label likes_number_id;

    @FXML
    private Label dislikes_number_id;

    @FXML
    private Font x11;

    @FXML
    private Button Blog_like_button;

    @FXML
    private Button Blog_dislike_button;

    @FXML
    private Button Blog_report_button;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
    BlogService s= new BlogService();

    @FXML
    void Dislike(ActionEvent event) {
        likes_number_id.setText(Integer.valueOf(likes_number_id.getText())+0+"");
        dislikes_number_id.setText(Integer.valueOf(dislikes_number_id.getText())+v+"");
        v=v*-1;
    }

    @FXML
    void Like(ActionEvent event) {
        dislikes_number_id.setText(Integer.valueOf(dislikes_number_id.getText())+0+"");
        likes_number_id.setText(Integer.valueOf(likes_number_id.getText())+v2+"");

        v2=v2*-1;
    }

    @FXML
    void Report(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            b= s.getBlogById(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        textareablog_id.setText(Draft.blog.getText());
        likes_number_id.setText(String.valueOf(Draft.blog.getLikes()));
//        dislikes_number_id.setText(String.valueOf(Draft.blog.getDislikes()));
        blogger_name_id.setText(UserCache.nom+" "+UserCache.prenom);
        posted_timing_id.setText(UserCache.date);
        CommentService commentService = new CommentService();
        try {
            commentService.findByBlogId(Draft.blog.getId()).forEach(comment ->{
                Label label = new Label("Aziz Bourguiba");
                Label txt = new Label(comment.getText());
                VBox vBox = new VBox();
                vBox.getChildren().add(label);
                vBox.getChildren().add(txt);
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void post(ActionEvent actionEvent) {
        CommentService commentService = new CommentService();
        System.out.println(Draft.blog.getId());
        try {
            commentService.create(new Comment(0, commentInput.getText(),  UserCache.id, Draft.blog.getId()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void back(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane  = FXMLLoader.load(getClass().getResource("../views/blogs_archive.fxml"));
            pane.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
