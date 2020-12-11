package Views;




import java.io.IOException;






import java.util.ArrayList;

import Controller.UsedBooksViewController;
import Controller.BaseController;
import Controller.CategoryViewController;
import Controller.ModifierCategoryController;
import Controller.ModifierUsedBooksController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
public void showUsedBooksView()
{
	BaseController B = new UsedBooksViewController(this,"../Views/UsedBooksView.fxml" );
	initializeStage(B);
	
}
public void showCategoryView()
{
	BaseController A = new CategoryViewController(this,"../Views/CategoryView.fxml" );
	initializeStage(A);
	
}

public void showModifierCategory() {
	BaseController c = new ModifierCategoryController(this,"../Views/ModifierCategory.fxml" );
	initializeStage(c);
	
	
}
public void showModifierUsedBooks() {
	BaseController d = new ModifierUsedBooksController(this,"../Views/ModifierUsedBooks.fxml" );
	initializeStage(d);
	
	
}
}

