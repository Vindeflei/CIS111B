import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.*;

public class PokeAppMain extends Application
{
   public static void main(String[] args) {
      launch(args);
   }
   @Override
   public void start(Stage stage) throws Exception
   {
      // Load the GUI from FXML built in Scene Builder
      FXMLLoader loader = new FXMLLoader();
      final URL resource = getClass().getResource("PokeApp.fxml");
      loader.setLocation(resource);
      System.out.println(loader.getLocation());
      Parent root = loader.load(resource);
      //Parent root = FXMLLoader.load(getClass().getResource("PokeApp.fxml"));    
      // Scene scene = new Scene(root);      
//       stage.setTitle("PokePics App");
//       
//       // The stylesheet is currently set in Scene Builder
//       // Note you can also load this programmatically
//       // scene.getStylesheets().add("styles.css");
// 
//       stage.setScene(scene);
//       stage.show();
//       
      // All of the code that interacts with the API and the Scene 
      //   is found in FXMLTempAppController.java
      
   }
   @Override
   public void stop() {
      System.out.println("Stop is called in Application class");
   }
}
