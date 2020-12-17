/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.views;

import com.esprit.Controllers.ClaimController;
import com.esprit.controllers.BaseController;
import com.esprit.controllers.CreateReviewController;
import com.esprit.controllers.FXMLDocumentController;
import com.esprit.controllers.ShowClaimsController;
import com.esprit.controllers.ShowReviewsController;
import com.esprit.controllers.UpdateClaimController;
import com.esprit.controllers.UpdateReviewController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class ViewFactory {
    private ArrayList<Stage> activeStage ;
   public FXMLLoader fxmlLoader ;

    public ViewFactory() {
        activeStage = new ArrayList<Stage>();
    }

    public void initializeStage(BaseController baseController) {

         fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.show();
        activeStage.add(stage);


    }
    
    public void showClaim(){
        BaseController b = new ClaimController(this,"Claim.fxml");
        initializeStage(b);
    }
    
    public void showReview(){
        BaseController b = new CreateReviewController(this,"CreateReview.fxml");
        initializeStage(b);
    }
    
    public void ListReviews(){
        BaseController b = new ShowReviewsController(this,"ShowReviews.fxml");
        initializeStage(b);
    }
    
    public void ListClaims(){
        BaseController b = new ShowClaimsController(this,"ShowClaims.fxml");
        initializeStage(b);
    }
    
    public void ShowUpdateClaim(){
        BaseController b = new UpdateClaimController(this,"UpdateClaim.fxml");
        initializeStage(b);
    }
    
    public void ShowUpdatReview(){
        BaseController b = new UpdateReviewController(this,"UpdateReview.fxml");
        initializeStage(b);
    }
    
    public void SendEmail(){
        BaseController b =new FXMLDocumentController(this,"FXMLDocument.fxml");
        initializeStage(b);
    }
    
}
