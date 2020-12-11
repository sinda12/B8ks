import com.B8ks.entities.User;
import javafx.application.Application;
import javafx.stage.Stage;
import com.B8ks.service.ServiceUser;
import com.B8ks.views.ViewFactory;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);


    }

   @Override
    public void start(Stage primaryStage) throws IOException {
/* try{
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.showSignUp();
}
catch (Exception e){
    e.printStackTrace();
}*/
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/OrderAfficheAdmin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        primaryStage.setTitle("Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    
}
