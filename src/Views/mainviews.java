package Views;



import javafx.application.Application;
import javafx.stage.Stage;

public class mainviews extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
            ViewFactory viewFactory = new ViewFactory();
            viewFactory.showUsedBooksView();
            
           /* ViewFactory viewFactory2 = new ViewFactory();
            viewFactory2.showCategoryView();*/
}
catch (Exception e){
e.printStackTrace();
}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
