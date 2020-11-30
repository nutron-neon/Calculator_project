
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage window) throws Exception{
        VBox lay = Display.numpad();

        window.setTitle("Calculator");
        Scene sc = new Scene(lay, 230, 300);
        sc.getStylesheets().add("Calculator.css");
        window.setScene(sc);
        window.show();
    }

} 