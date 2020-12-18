package com.esprit.views;


import com.esprit.controllers.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStage ;
   public FXMLLoader fxmlLoader ;

    public ViewFactory() {
        activeStage = new ArrayList<Stage>();
    }

    public void initializeStage(BaseController baseController, ActionEvent ac) {

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
        Stage window =(Stage)((Node)ac.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();


    }




public void showSignUp(ActionEvent ac)
{
    BaseController b = new LoginController(this, "sign_up.fxml");
    initializeStage(b,ac);

}

public void showSignIn(ActionEvent ac)
{
    BaseController be = new SignInController(this, "sign_in.fxml");
    initializeStage(be,ac);
}

    public Pane showProfil(ActionEvent ac) throws IOException {
        BaseController b = new MenuController(this, "../views/menu.fxml");
        fxmlLoader = new FXMLLoader(getClass().getResource(b.getFxmlName()));
        fxmlLoader.setController(b);
            return  fxmlLoader.load();
    }


public void showMenu(ActionEvent ac) throws IOException {
    Parent orderParent = FXMLLoader.load(getClass().getResource("../views/Home.fxml"));
    Scene orderScene = new Scene(orderParent);
    Stage window =(Stage)((Node)ac.getSource()).getScene().getWindow();
    window.setScene(orderScene);
    window.show();
}

public void showListUser(ActionEvent ac)
    {
        BaseController b = new UsersController(this,"list_users.fxml");
        initializeStage(b,ac);
    }

public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStage.remove(stageToClose);

    }

    public void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("login try");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);

        alert.showAndWait();
    }

  /*  public void showVerifMail()
    {

        BaseController b = new VerificationController(this,"verification.fxml");
        initializeStage(b);
    }*/

    public Pane showClaim(ActionEvent ac) throws IOException {
        BaseController b = new ClaimController(this,"Claim.fxml");
        fxmlLoader = new FXMLLoader(getClass().getResource(b.getFxmlName()));
        fxmlLoader.setController(b);
        return  fxmlLoader.load();
    }
//
//    public void showReview(){
//        BaseController b = new CreateReviewController(this,"CreateReview.fxml");
//        initializeStage(b);
//    }
//
//    public void ListReviews(){
//        BaseController b = new ShowReviewsController(this,"ShowReviews.fxml");
//        initializeStage(b);
//    }
//
//    public void ListClaims(){
//        BaseController b = new ShowClaimsController(this,"ShowClaims.fxml");
//        initializeStage(b);
//    }
//
//    public void ShowUpdateClaim(){
//        BaseController b = new UpdateClaimController(this,"UpdateClaim.fxml");
//        initializeStage(b);
//    }
//
//    public void ShowUpdatReview(){
//        BaseController b = new UpdateReviewController(this,"UpdateReview.fxml");
//        initializeStage(b);
//    }
//
//    public void SendEmail(){
//        BaseController b =new FXMLDocumentController(this,"FXMLDocument.fxml");
//        initializeStage(b);
//    }
//
//    public void showUsedBooksView()
//    {
//        BaseController B = new UsedBooksViewController(this,"../Views/UsedBooksView.fxml" );
//        initializeStage(B);
//
//    }
//    public void showCategoryView()
//    {
//        BaseController A = new CategoryViewController(this,"../Views/CategoryView.fxml" );
//        initializeStage(A);
//
//    }
//
//    public void showModifierCategory() {
//        BaseController c = new ModifierCategoryController(this,"../Views/ModifierCategory.fxml" );
//        initializeStage(c);
//
//
//    }
//    public void showModifierUsedBooks() {
//        BaseController d = new ModifierUsedBooksController(this,"../Views/ModifierUsedBooks.fxml" );
//        initializeStage(d);
//    }

}
