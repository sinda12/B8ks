import com.B8ks.entities.User;
import javafx.application.Application;
import javafx.stage.Stage;
import com.B8ks.service.ServiceUser;
import com.B8ks.views.ViewFactory;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) {
try{
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.showSignUp();
}
catch (Exception e){
    e.printStackTrace();
}

    }
}
