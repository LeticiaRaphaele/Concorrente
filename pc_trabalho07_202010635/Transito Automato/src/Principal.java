import controll.TransitControll;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{
    public static void main(String[] args) throws Exception {
        launch();
    }

    public void start(Stage stage) throws Exception  {

        Parent root = FXMLLoader.load(getClass().getResource("/view/TransitoAu.fxml"));
        Scene scene = new Scene(root);
    
        stage.setTitle("Transito Automatico");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    
      }
}
