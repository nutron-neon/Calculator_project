import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display {

	  static String a, b, operator;//a=first number   &&  b=second number
	    static int time = 0;

	    public static VBox numpad() {
	        TextField input = new TextField();
	        input.setPromptText("Enter a value");

	        VBox lay = new VBox();
	        lay.setAlignment(Pos.CENTER);
	        lay.getChildren().add(input);

	        ToggleGroup tg = new ToggleGroup();

	        String[][] s = {
	                {"9", "8", "7", "/"},
	                {"6", "5", "4", "*"},
	                {"1", "2", "3", "-"},
	                {"0", ".", "=", "+"}
	        };

	        for (int i = 0; i < 4; i++) {
	            HBox h = new HBox();
	            for (int j = 0; j < 4; j++) {
	                ToggleButton t = new ToggleButton(s[i][j]);
	                t.setUserData(s[i][j]);
	                t.setToggleGroup(tg);
	                h.getChildren().add(t);
	            }
	            h.setPadding(new Insets(10, 0, 0, 0));
	            h.setSpacing(10);
	            h.setAlignment(Pos.CENTER);
	            lay.getChildren().add(h);
	        }

	        tg.selectedToggleProperty().addListener((v, oldValue, newValue) -> {
	            String data = newValue.getUserData().toString();
	            if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/") || data.equals("=")) {
	                if (time == 0) {
	                    a = input.getText();
	                    operator=data;
	                    input.clear();
	                    time++;
	                } else {
	                    b = input.getText();
	                    input.clear();
	                    calculation(input);
	                    time=0;
	                }
	            } else
	                input.setText(input.getText() + data);
	        });
	        return lay;
	    }

	    public static void calculation(TextField input) {
	        Double ans=0.0;
	        switch (operator) {
	            case "+": ans = Double.parseDouble(a) + Double.parseDouble(b);
	            break;
	            case "-": ans = Double.parseDouble(a) - Double.parseDouble(b);
	            break;
	            case "*": ans = Double.parseDouble(a) + Double.parseDouble(b);
	            break;
	            case "/": ans = Double.parseDouble(a) + Double.parseDouble(b);
	            break;
	        }
	        input.setText(""+ans);
	    }
	}
