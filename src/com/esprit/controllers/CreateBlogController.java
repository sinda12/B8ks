package com.esprit.controllers;

import com.esprit.entities.Blog;
import com.esprit.entities.BlogCache;
import com.esprit.entities.User;
import com.esprit.entities.UserCache;
import com.esprit.services.BlogService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CreateBlogController  implements Initializable {
    @FXML
    public TextField category;
    @FXML
    public TextField title;
    @FXML
    public TextArea text;
    public VBox pane;
    BlogService bs = new BlogService();

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(formatter.format(date));

        text.setText(BlogCache.text);
    }


    public void post(ActionEvent actionEvent) {

        User s = new User();
        s.setId(UserCache.id);
        Blog b = new Blog(title.getText(), category.getText(), text.getText(),formatter.format(date)+"");
        UserCache.prenom="beer";
        UserCache.nom="beer";
        UserCache.date=formatter.format(date)+"";
        b.setUser(s);
//        System.out.println("hedhiii ell dataaeee"+b.getDate());


         try {
         bs.create(b);
        BlogCache.text = text.getText();


         } catch (SQLException exception) {
        exception.printStackTrace();
    }

}

    public void cancel(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane  = FXMLLoader.load(getClass().getResource("../views/blogs_archive.fxml"));
            pane.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draftIt(ActionEvent actionEvent) {
        BlogCache.text= text.getText();

    }

}
