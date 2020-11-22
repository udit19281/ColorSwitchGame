import javafx.application.Application;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class LineObstacle extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();
        Rectangle rectangle5 = new Rectangle();
        Rectangle rectangle6 = new Rectangle();
        Rectangle rectangle7 = new Rectangle();
        Rectangle rectangle8 = new Rectangle();

        rectangle.setX(15.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(15.0f);
        rectangle.setHeight(120.0f);
        rectangle.setFill(Color.RED);

        rectangle2.setX(65.0f);
        rectangle2.setY(75.0f);
        rectangle2.setWidth(15.0f);
        rectangle2.setHeight(120.0f);
        rectangle2.setFill(Color.YELLOW);

        rectangle3.setX(115.0f);
        rectangle3.setY(75.0f);
        rectangle3.setWidth(15.0f);
        rectangle3.setHeight(120.0f);
        rectangle3.setFill(Color.VIOLET);

        rectangle4.setX(165.0f);
        rectangle4.setY(75.0f);
        rectangle4.setWidth(15.0f);
        rectangle4.setHeight(120.0f);
        rectangle4.setFill(Color.GREEN);

        rectangle5.setX(215.0f);
        rectangle5.setY(75.0f);
        rectangle5.setWidth(15.0f);
        rectangle5.setHeight(120.0f);
        rectangle5.setFill(Color.RED);

        rectangle6.setX(265.0f);
        rectangle6.setY(75.0f);
        rectangle6.setWidth(15.0f);
        rectangle6.setHeight(120.0f);
        rectangle6.setFill(Color.YELLOW);

        rectangle7.setX(315.0f);
        rectangle7.setY(75.0f);
        rectangle7.setWidth(15.0f);
        rectangle7.setHeight(120.0f);
        rectangle7.setFill(Color.VIOLET);

        rectangle8.setX(365.0f);
        rectangle8.setY(75.0f);
        rectangle8.setWidth(15.0f);
        rectangle8.setHeight(120.0f);
        rectangle8.setFill(Color.GREEN);


        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400);
        translate.setToX(250);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(rectangle);
        translate.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setByX(400);
        translate2.setToX(250);
        translate2.setDuration(Duration.millis(3000));
        translate2.setCycleCount(500);
        translate2.setAutoReverse(true);
        translate2.setNode(rectangle2);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setByX(400);
        translate3.setToX(250);
        translate3.setDuration(Duration.millis(3000));
        translate3.setCycleCount(500);
        translate3.setAutoReverse(true);
        translate3.setNode(rectangle3);
        translate3.play();

        TranslateTransition translate4 = new TranslateTransition();
        translate4.setByX(400);
        translate4.setToX(250);
        translate4.setDuration(Duration.millis(3000));
        translate4.setCycleCount(500);
        translate4.setAutoReverse(true);
        translate4.setNode(rectangle4);
        translate4.play();

        TranslateTransition translate5 = new TranslateTransition();
        translate5.setByX(400);
        translate5.setToX(-200);
        translate5.setDuration(Duration.millis(3000));
        translate5.setCycleCount(500);
        translate5.setAutoReverse(true);
        translate5.setNode(rectangle5);
        translate5.play();

        TranslateTransition translate6 = new TranslateTransition();
        translate6.setByX(400);
        translate6.setToX(-200);
        translate6.setDuration(Duration.millis(3000));
        translate6.setCycleCount(500);
        translate6.setAutoReverse(true);
        translate6.setNode(rectangle6);
        translate6.play();

        TranslateTransition translate7 = new TranslateTransition();
        translate7.setByX(400);
        translate7.setToX(-200);
        translate7.setDuration(Duration.millis(3000));
        translate7.setCycleCount(500);
        translate7.setAutoReverse(true);
        translate7.setNode(rectangle7);
        translate7.play();

        TranslateTransition translate8 = new TranslateTransition();
        translate8.setByX(400);
        translate8.setToX(-200);
        translate8.setDuration(Duration.millis(3000));
        translate8.setCycleCount(500);
        translate8.setAutoReverse(true);
        translate8.setNode(rectangle8);
        translate8.play();


        Group root = new Group(rectangle,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8);
        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("Drawing a Rectangle");

        stage.setScene(scene);

        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}