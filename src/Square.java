import javafx.application.Application;
import javafx.animation.TranslateTransition;
import javafx.animation.RotateTransition;
import javafx.scene.transform.Rotate;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Square extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();

        rectangle.setX(150.0f);
        rectangle.setY(200.0f);
        rectangle.setWidth(15.0f);
        rectangle.setHeight(200.0f);
        rectangle.setFill(Color.RED);

        rectangle2.setX(40.0f);
        rectangle2.setY(290.0f);
        rectangle2.setWidth(15.0f);
        rectangle2.setHeight(200.0f);
        rectangle2.setFill(Color.YELLOW);

        rectangle3.setX(150.0f);
        rectangle3.setY(200.0f);
        rectangle3.setWidth(200.0f);
        rectangle3.setHeight(15.0f);
        rectangle3.setFill(Color.VIOLET);

        rectangle4.setX(165.0f);
        rectangle4.setY(200.0f);
        rectangle4.setWidth(200.0f);
        rectangle4.setHeight(15.0f);
        rectangle4.setFill(Color.GREEN);


        Group root = new Group(rectangle,rectangle2,rectangle3,rectangle4);
        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("Drawing a Rectangle");

        stage.setScene(scene);

        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
