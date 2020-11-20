import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainMenu extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            stage.setTitle("Color Switch");
            GridPane parent = new GridPane();
            parent.setAlignment(Pos.CENTER);
            BackgroundImage image = new BackgroundImage(new Image("colorswitch.png", 800, 700, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            parent.setBackground(new Background(image));

            Button btn1 = new Button("New Game");
            btn1.setMinSize(150, 25);
            btn1.setStyle("-fx-font-size: 1.5em; ");
            btn1.setOnAction(new button1());

            Button btn2 = new Button("Resume");
            btn2.setMinSize(150, 25);
            btn2.setStyle("-fx-font-size: 1.5em; ");
            btn2.setOnAction(new button2());

            Button btn3 = new Button("Exit");
            btn3.setMinSize(150, 25);
            btn3.setStyle("-fx-font-size: 1.5em; ");
            btn3.setOnAction(new button3());

            parent.setVgap(5);
            parent.add(btn1, 1, 0);
            parent.add(btn2, 1, 2);
            parent.add(btn3, 1, 4);

            Scene s1 = new Scene(parent, 800, 700);
            stage.setScene(s1);
            stage.show();
        }
}
class button1 implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Button 1 is pressed");
    }
}
class button2 implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Button 2 is pressed");
    }
}
class button3 implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Button 3 is pressed");
    }
}