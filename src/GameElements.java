import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class GameElements {
    protected ArrayList<Integer> position;
    public GameElements(){
        this.position=new ArrayList<Integer>();
    }
    public ArrayList<Integer> getPosition(){
        return this.position;
    }
    public abstract Group getObstacle();
}
class Ball extends GameElements{
private int color;

    public int getColor() {
        return this.color;
    }
    public void changeColor(int c){
        this.color=c;
    }
    @Override
    public Group getObstacle() {
        return null;
    }
}
class Star extends GameElements{
    @Override
    public Group getObstacle() {
        Image image = new Image("star.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(imageView);
        scaleTransition.setByY(0.4);
        scaleTransition.setByX(0.4);
        scaleTransition.setCycleCount(500);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        Group star=new Group(imageView);
        return star;
    }

}
class Obstacle extends GameElements{
    private String type_of_obstacle;

    public String getType_of_obstacle(){
        return this.type_of_obstacle;
    }

    public void setType_of_obstacle(String type_of_obstacle) {
        this.type_of_obstacle = type_of_obstacle;
    }
    @Override
    public Group getObstacle() {
        return null;
    }
}
class LineObstacle extends Obstacle{

    @Override
    public Group getObstacle() {
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
        rectangle.setFill(Color.AQUA);

        rectangle2.setX(65.0f);
        rectangle2.setY(75.0f);
        rectangle2.setWidth(15.0f);
        rectangle2.setHeight(120.0f);
        rectangle2.setFill(Color.YELLOW);

        rectangle3.setX(115.0f);
        rectangle3.setY(75.0f);
        rectangle3.setWidth(15.0f);
        rectangle3.setHeight(120.0f);
        rectangle3.setFill(Color.BLUE);
        rectangle4.setX(165.0f);
        rectangle4.setY(75.0f);
        rectangle4.setWidth(15.0f);
        rectangle4.setHeight(120.0f);
        rectangle4.setFill(Color.DEEPPINK);

        rectangle5.setX(215.0f);
        rectangle5.setY(75.0f);
        rectangle5.setWidth(15.0f);
        rectangle5.setHeight(120.0f);
        rectangle5.setFill(Color.AQUA);

        rectangle6.setX(265.0f);
        rectangle6.setY(75.0f);
        rectangle6.setWidth(15.0f);
        rectangle6.setHeight(120.0f);
        rectangle6.setFill(Color.YELLOW);
        rectangle7.setX(315.0f);
        rectangle7.setY(75.0f);
        rectangle7.setWidth(15.0f);
        rectangle7.setHeight(120.0f);
        rectangle7.setFill(Color.BLUE);

        rectangle8.setX(365.0f);
        rectangle8.setY(75.0f);
        rectangle8.setWidth(15.0f);
        rectangle8.setHeight(120.0f);
        rectangle8.setFill(Color.DEEPPINK);
        Group root1 = new Group(rectangle,rectangle2,rectangle3,rectangle4);
        Group root2 = new Group(rectangle5,rectangle6,rectangle7,rectangle8);
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400);
        translate.setToX(200);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(root1);
        translate.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setByX(400);
        translate2.setToX(-200);
        translate2.setDuration(Duration.millis(3000));
        translate2.setCycleCount(500);
        translate2.setAutoReverse(true);
        translate2.setNode(root2);
        translate2.play();

        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(6000));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setCycleCount(1000);
        fade.setAutoReverse(false);
        fade.setNode(root1);
        fade.play();

        FadeTransition fade2 = new FadeTransition();
        fade2.setDuration(Duration.millis(6000));
        fade2.setFromValue(1);
        fade2.setToValue(0);
        fade2.setCycleCount(1000);
        fade2.setAutoReverse(false);
        fade2.setNode(root2);
        fade2.play();
        Group root = new Group(root1,root2);
        return root;

    }
}
class CircleObstacle extends Obstacle{

    @Override
    public Group getObstacle() {
        Arc arc1=new Arc();
        Arc arc2=new Arc();
        Arc arc3=new Arc();
        Arc arc4=new Arc();
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);

        arc1.setCenterX(150.0f);
        arc1.setCenterY(250.0f);
        arc2.setCenterX(150.0f);
        arc2.setCenterY(250.0f);
        arc3.setCenterX(150.0f);
        arc3.setCenterY(250.0f);
        arc4.setCenterX(150.0f);
        arc4.setCenterY(250.0f);

        arc1.setRadiusX(150.0f);
        arc1.setRadiusY(150.0f);
        arc2.setRadiusX(150.0f);
        arc2.setRadiusY(150.0f);
        arc3.setRadiusX(150.0f);
        arc3.setRadiusY(150.0f);
        arc4.setRadiusX(150.0f);
        arc4.setRadiusY(150.0f);

        arc1.setStartAngle(0.0f);
        arc2.setStartAngle(90.0f);
        arc3.setStartAngle(180.0f);
        arc4.setStartAngle(270.0f);

        arc1.setLength(100.0f);
        arc2.setLength(100.0f);
        arc3.setLength(100.0f);
        arc4.setLength(100.0f);

        Circle circ1=new Circle(150.0f,250.0f,135.0f);
        Circle circ2=new Circle(150.0f,250.0f,135.0f);
        Circle circ3=new Circle(150.0f,250.0f,135.0f);
        Circle circ4=new Circle(150.0f,250.0f,135.0f);

        Shape clip1= Shape.subtract(arc1,circ1);
        clip1.setFill(Color.AQUA);
        Shape clip2= Shape.subtract(arc2,circ2);
        clip2.setFill(Color.BLUE);
        Shape clip3= Shape.subtract(arc3,circ3);
        clip3.setFill(Color.YELLOW);
        Shape clip4= Shape.subtract(arc4,circ4);
        clip4.setFill(Color.DEEPPINK);

        Group root=new Group(clip1,clip2,clip3,clip4);

//        Scene scene=new Scene(root,600,600);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(200);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        Scale scale = new Scale();
        scale.setPivotX(150);
        scale.setPivotY(250);
        scale.setX(0.8);
        scale.setY(0.8);
        root.getTransforms().addAll(scale);
        return root;
    }
    public Group Big_circle(){
        Arc arc1=new Arc();
        Arc arc2=new Arc();
        Arc arc3=new Arc();
        Arc arc4=new Arc();
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);

        arc1.setCenterX(150.0f);
        arc1.setCenterY(250.0f);
        arc2.setCenterX(150.0f);
        arc2.setCenterY(250.0f);
        arc3.setCenterX(150.0f);
        arc3.setCenterY(250.0f);
        arc4.setCenterX(150.0f);
        arc4.setCenterY(250.0f);

        arc1.setRadiusX(150.0f);
        arc1.setRadiusY(150.0f);
        arc2.setRadiusX(150.0f);
        arc2.setRadiusY(150.0f);
        arc3.setRadiusX(150.0f);
        arc3.setRadiusY(150.0f);
        arc4.setRadiusX(150.0f);
        arc4.setRadiusY(150.0f);

        arc1.setStartAngle(0.0f);
        arc2.setStartAngle(90.0f);
        arc3.setStartAngle(180.0f);
        arc4.setStartAngle(270.0f);

        arc1.setLength(100.0f);
        arc2.setLength(100.0f);
        arc3.setLength(100.0f);
        arc4.setLength(100.0f);

        Circle circ1=new Circle(150.0f,250.0f,135.0f);
        Circle circ2=new Circle(150.0f,250.0f,135.0f);
        Circle circ3=new Circle(150.0f,250.0f,135.0f);
        Circle circ4=new Circle(150.0f,250.0f,135.0f);

        Shape clip1= Shape.subtract(arc1,circ1);
        clip1.setFill(Color.AQUA);
        Shape clip2= Shape.subtract(arc2,circ2);
        clip2.setFill(Color.BLUE);
        Shape clip3= Shape.subtract(arc3,circ3);
        clip3.setFill(Color.YELLOW);
        Shape clip4= Shape.subtract(arc4,circ4);
        clip4.setFill(Color.DEEPPINK);

        Group root=new Group(clip1,clip2,clip3,clip4);
        Arc arc11=new Arc();
        Arc arc22=new Arc();
        Arc arc33=new Arc();
        Arc arc44=new Arc();
        arc11.setType(ArcType.ROUND);
        arc22.setType(ArcType.ROUND);
        arc33.setType(ArcType.ROUND);
        arc44.setType(ArcType.ROUND);

        arc11.setCenterX(150.0f);
        arc11.setCenterY(250.0f);
        arc22.setCenterX(150.0f);
        arc22.setCenterY(250.0f);
        arc33.setCenterX(150.0f);
        arc33.setCenterY(250.0f);
        arc44.setCenterX(150.0f);
        arc44.setCenterY(250.0f);

        arc11.setRadiusX(100.0f);
        arc11.setRadiusY(100.0f);
        arc22.setRadiusX(100.0f);
        arc22.setRadiusY(100.0f);
        arc33.setRadiusX(100.0f);
        arc33.setRadiusY(100.0f);
        arc44.setRadiusX(100.0f);
        arc44.setRadiusY(100.0f);

        arc11.setStartAngle(0.0f);
        arc22.setStartAngle(90.0f);
        arc33.setStartAngle(180.0f);
        arc44.setStartAngle(270.0f);

        arc11.setLength(100.0f);
        arc22.setLength(100.0f);
        arc33.setLength(100.0f);
        arc44.setLength(100.0f);

        Circle circ11=new Circle(150.0f,250.0f,85.0f);
        Circle circ22=new Circle(150.0f,250.0f,85.0f);
        Circle circ33=new Circle(150.0f,250.0f,85.0f);
        Circle circ44=new Circle(150.0f,250.0f,85.0f);

        Shape clip11= Shape.subtract(arc11,circ11);
        clip11.setFill(Color.AQUA);
        Shape clip22= Shape.subtract(arc22,circ22);
        clip22.setFill(Color.BLUE);
        Shape clip33= Shape.subtract(arc33,circ33);
        clip33.setFill(Color.YELLOW);
        Shape clip44= Shape.subtract(arc44,circ44);
        clip44.setFill(Color.DEEPPINK);

        Group root2=new Group(clip11,clip22,clip33,clip44);
//        Scene scene=new Scene(root,600,600);
        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setNode(root2);
        rotateTransition2.setDuration(Duration.millis(3450));
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(200);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setDuration(Duration.millis(3500));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(200);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        Scale scale = new Scale();
        scale.setPivotX(150);
        scale.setPivotY(250);
        scale.setX(0.8);
        scale.setY(0.8);
        root.getTransforms().addAll(scale);
        root2.getTransforms().addAll(scale);
        Group root3=new Group(root,root2);
        return root3;
    }
}
class SquareObstacle extends Obstacle{

    @Override
    public Group getObstacle() {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();

        rectangle.setX(150.0f);
        rectangle.setY(200.0f);
        rectangle.setWidth(15.0f);
        rectangle.setHeight(200.0f);
        rectangle.setFill(Color.AQUA);

        rectangle2.setX(350.0f);
        rectangle2.setY(200.0f);
        rectangle2.setWidth(15.0f);
        rectangle2.setHeight(200.0f);
        rectangle2.setFill(Color.YELLOW);

        rectangle3.setX(150.0f);
        rectangle3.setY(200.0f);
        rectangle3.setWidth(200.0f);
        rectangle3.setHeight(15.0f);
        rectangle3.setFill(Color.DEEPPINK);

        rectangle4.setX(165.0f);
        rectangle4.setY(385.0f);
        rectangle4.setWidth(200.0f);
        rectangle4.setHeight(15.0f);
        rectangle4.setFill(Color.BLUE);


        Group root = new Group(rectangle,rectangle2,rectangle3,rectangle4);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(500);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        return root;
    }
}
class TriangleObstacle extends Obstacle{
    private int sideLength;
    public void setSideLength(int s) {
        this.sideLength=s;
    }

    public int getSideLength() {
        return sideLength;
    }
    @Override
    public Group getObstacle() {
        return null;
    }
}
class PlusObstacle extends Obstacle{

    @Override
    public Group getObstacle() {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();

        rectangle.setX(180.0f);
        rectangle.setY(200.0f);
        rectangle.setWidth(15.0f);
        rectangle.setHeight(70.0f);
        rectangle.setFill(Color.AQUA);

        rectangle2.setX(180.0f);
        rectangle2.setY(270.0f);
        rectangle2.setWidth(15.0f);
        rectangle2.setHeight(70.0f);
        rectangle2.setFill(Color.YELLOW);

        rectangle3.setX(117.5f);
        rectangle3.setY(262.5f);
        rectangle3.setWidth(70.0f);
        rectangle3.setHeight(15.0f);
        rectangle3.setFill(Color.BLUE);

        rectangle4.setX(187.5f);
        rectangle4.setY(262.5f);
        rectangle4.setWidth(70.0f);
        rectangle4.setHeight(15.0f);
        rectangle4.setFill(Color.DEEPPINK);


        Group root = new Group(rectangle,rectangle2,rectangle3,rectangle4);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setDuration(Duration.millis(8500));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(500);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        Scale scale = new Scale();
        scale.setPivotX(195);
        scale.setPivotY(270);
        scale.setX(1.7);
        scale.setY(1.7);
        root.getTransforms().addAll(scale);

        return root;
    }
}
