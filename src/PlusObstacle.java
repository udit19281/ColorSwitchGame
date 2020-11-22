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

public class PlusObstacle extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();

        rectangle.setX(130.0f);
        rectangle.setY(200.0f);
        rectangle.setWidth(20.0f);
        rectangle.setHeight(200.0f);
        rectangle.setFill(Color.RED);

        rectangle2.setX(40.0f);
        rectangle2.setY(290.0f);
        rectangle2.setWidth(200.0f);
        rectangle2.setHeight(20.0f);
        rectangle2.setFill(Color.YELLOW);

        rectangle3.setX(350.5f);
        rectangle3.setY(200.0f);
        rectangle3.setWidth(20.0f);
        rectangle3.setHeight(200.0f);
        rectangle3.setFill(Color.VIOLET);

        rectangle4.setX(260.0f);
        rectangle4.setY(290.0f);
        rectangle4.setWidth(200.0f);
        rectangle4.setHeight(20.0f);
        rectangle4.setFill(Color.GREEN);

        Rotate rotate = new Rotate();
        rotate.setAngle(45);
        rotate.setPivotX(360.5f);
        rotate.setPivotY(300.0f);
        rectangle3.getTransforms().addAll(rotate);
        rectangle4.getTransforms().addAll(rotate);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(rectangle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(4000));
        rotateTransition2.setNode(rectangle2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition3 = new RotateTransition();
        rotateTransition3.setDuration(Duration.millis(4000));
        rotateTransition3.setNode(rectangle3);
        rotateTransition3.setByAngle(360);
        rotateTransition3.setCycleCount(50);
        rotateTransition3.setAutoReverse(false);
        rotateTransition3.play();

        RotateTransition rotateTransition4 = new RotateTransition();
        rotateTransition4.setDuration(Duration.millis(4000));
        rotateTransition4.setNode(rectangle4);
        rotateTransition4.setByAngle(360);
        rotateTransition4.setCycleCount(50);
        rotateTransition4.setAutoReverse(false);
        rotateTransition4.play();

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
