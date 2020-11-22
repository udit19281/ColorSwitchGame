import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.animation.ScaleTransition;
import javafx.scene.image.ImageView;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.transform.Scale;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        MainMenuGUI(stage);
    }
    public void MainMenuGUI(Stage stage) {
        stage.setTitle("Color Switch");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);

        Pane parent = new Pane();
        ImageView img=new ImageView();
        img.setImage(new Image("mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("ring.png"));
        img4.setFitHeight(150);
        img4.setFitWidth(150);
        img4.setLayoutX(420);
        img4.setLayoutY(253);
        parent.getChildren().add(img4);
        RotateTransition rotateTransition2=new RotateTransition();
        rotateTransition2.setNode(img3);

        rotateTransition2.setDuration(Duration.millis(3000));
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(200);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(200);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        BackgroundImage myBI= new BackgroundImage(new Image("mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        Scene scene = new Scene(parent);
        Button btn1 = new Button("New Game");
        btn1.setMinSize(150, 25);
        btn1.setLayoutX(250);
        btn1.setLayoutY(200);

        btn1.setStyle("-fx-font-size: 2.5em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 188px; -fx-max-height: 188px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in main menu");
            Group root2 = LineObstacle();
            GamePlay(stage,scene,root2);
        });

        Button btn2 = new Button("Resume");
        btn2.setMinSize(150, 25);
        btn2.setLayoutX(250);
        btn2.setLayoutY(250);
        btn2.setStyle("-fx-font-size: 2.5em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in main menu");
            SavedGames(stage,scene);
        });

        Button btn3 = new Button("Exit");
        btn3.setLayoutX(250);
        btn3.setLayoutY(300);
        btn3.setMinSize(150, 25);
        btn3.setStyle("-fx-font-size: 2.5em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn3.setOnAction(e->{
            System.out.println("Pressed button 3 in main menu");
            ExitGUI(stage,scene);
        });

        parent.getChildren().addAll(btn1,btn2,btn3);
        stage.setScene(scene);
        stage.show();
    }
    public void PauseGameGUI(Stage stage,Scene scene){
        stage.setTitle("Pause Menu");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);

        Pane parent = new Pane();
        ImageView img=new ImageView();
        img.setImage(new Image("mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("ring.png"));
        img4.setFitHeight(150);
        img4.setFitWidth(150);
        img4.setLayoutX(420);
        img4.setLayoutY(253);
        parent.getChildren().add(img4);
        RotateTransition rotateTransition2=new RotateTransition();
        rotateTransition2.setNode(img3);

        rotateTransition2.setDuration(Duration.millis(3000));
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(200);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(200);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        BackgroundImage myBI= new BackgroundImage(new Image("mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);

        Button btn1 = new Button("Saved");
        btn1.setMinSize(150, 25);
        btn1.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setLayoutX(250);
        btn1.setLayoutY(200);
//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in pause menu");
        });

        Button btn2 = new Button("Resume");
        btn2.setMinSize(150, 25);
        btn2.setLayoutX(250);
        btn2.setLayoutY(250);
//        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in pause menu");
        });
        parent.getChildren().addAll(btn1,btn2);
        stage.setScene(scene);
        stage.show();
    }

    public void SavedGames(Stage stage,Scene scene){
        stage.setTitle("Saved Games List");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);

        Pane parent = new Pane();
        ImageView img=new ImageView();
        img.setImage(new Image("mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("ring.png"));
        img4.setFitHeight(150);
        img4.setFitWidth(150);
        img4.setLayoutX(420);
        img4.setLayoutY(253);
        parent.getChildren().add(img4);
        RotateTransition rotateTransition2=new RotateTransition();
        rotateTransition2.setNode(img3);

        rotateTransition2.setDuration(Duration.millis(3000));
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(200);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(200);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        BackgroundImage myBI= new BackgroundImage(new Image("mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);
        Text text = new Text();
        text.setText("SELECT GAME");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setFill(Color.WHITE);

        Button btn1 = new Button("Game 1");
        btn1.setMinSize(150, 25);
        btn1.setLayoutX(250);
        btn1.setLayoutY(200);
//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in pause menu");
        });

        Button btn2 = new Button("Game 2");
        btn2.setMinSize(150, 25);
        btn2.setLayoutX(250);
        btn2.setLayoutY(250);
//        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in pause menu");
        });
        parent.getChildren().addAll(btn1,btn2);
        stage.setScene(scene);
        stage.show();
    }

    public void ExitGUI(Stage stage,Scene scene){
        stage.setTitle("Exit Menu");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);

        Pane parent = new Pane();
        ImageView img=new ImageView();
        img.setImage(new Image("mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("ring.png"));
        img4.setFitHeight(150);
        img4.setFitWidth(150);
        img4.setLayoutX(420);
        img4.setLayoutY(253);
        parent.getChildren().add(img4);
        RotateTransition rotateTransition2=new RotateTransition();
        rotateTransition2.setNode(img3);

        rotateTransition2.setDuration(Duration.millis(3000));
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(200);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(200);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        BackgroundImage myBI= new BackgroundImage(new Image("mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);

        Button btn1 = new Button("Continue");
        btn1.setMinSize(150, 25);
        btn1.setLayoutX(250);
        btn1.setLayoutY(200);
//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in exit menu");
        });

        Button btn2 = new Button("Restart");
        btn2.setMinSize(150, 25);
        btn2.setLayoutX(250);
        btn2.setLayoutY(250);
//        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in exit menu");
        });

        Button btn3 = new Button("Main Menu");
        btn3.setMinSize(150, 25);
        btn3.setLayoutX(250);
        btn3.setLayoutY(300);
//        btn3.setStyle("-fx-font-size: 1.5em; ");
        btn3.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn3.setOnAction(e->{
            System.out.println("Pressed button 3 in exit menu");
            stage.close();
            MainMenuGUI(new Stage());
        });
        parent.getChildren().addAll(btn1,btn2,btn3);
        stage.setScene(scene);
        stage.show();
    }
    public Group CircleObstacle(){
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

        Image image = new Image("star.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        imageView.setX(120);
        imageView.setY(215);
        imageView.setPreserveRatio(true);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(imageView);
        scaleTransition.setByY(0.4);
        scaleTransition.setByX(0.4);
        scaleTransition.setCycleCount(200);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        Group root=new Group(clip1,clip2,clip3,clip4,imageView);

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

    public Group LineObstacle() {
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


        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400);
        translate.setToX(200);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(rectangle);
        translate.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setByX(400);
        translate2.setToX(200);
        translate2.setDuration(Duration.millis(3000));
        translate2.setCycleCount(500);
        translate2.setAutoReverse(true);
        translate2.setNode(rectangle2);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setByX(400);
        translate3.setToX(200);
        translate3.setDuration(Duration.millis(3000));
        translate3.setCycleCount(500);
        translate3.setAutoReverse(true);
        translate3.setNode(rectangle3);
        translate3.play();

        TranslateTransition translate4 = new TranslateTransition();
        translate4.setByX(400);
        translate4.setToX(200);
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
        return root;

    }

    public Group SquareObstacle() {
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

        Image image = new Image("star.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setX(240);
        imageView.setY(275);
        imageView.setPreserveRatio(true);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(imageView);
        scaleTransition.setByY(0.4);
        scaleTransition.setByX(0.4);
        scaleTransition.setCycleCount(500);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        Group root = new Group(rectangle,rectangle2,rectangle3,rectangle4,imageView);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(500);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        return root;
    }
    public Group PlusObstacle() {

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
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(500);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        return root;
    }

    public void GamePlay (Stage stage,Scene scene,Group root) {

        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setX(50);
        text.setY(130);
        text.setText("SCORE: 0  ");
        text.setFill(Color.WHITE);


        Button btn1 = new Button("Pause");
        btn1.setMinSize(100, 25);
//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setStyle("-fx-font-size: 2em;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setOnAction(e->{
            System.out.println("Pause the game");
            PauseGameGUI(stage,scene);
        });
        Button btn2 = new Button("Exit");
        btn2.setMinSize(100, 25);
//        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setStyle("-fx-font-size: 2em;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn2.setOnAction(e->{
            System.out.println("exit");
            ExitGUI(stage,scene);
        });


        Circle ball=new Circle();
        ball.setRadius(14);
        ball.setFill(Color.YELLOW);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setNode(ball);
        translateTransition.setByY(-50);
        translateTransition.setToY(-50);
        translateTransition.setCycleCount(200);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

        Image image = new Image("text.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        Image image2 = new Image("hand2.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(50);
        imageView2.setFitWidth(50);
        imageView2.setPreserveRatio(true);

        BorderPane border=new BorderPane();
        VBox ver=new VBox(btn1,btn2);
        ver.setSpacing(10);
        ver.setAlignment(Pos.TOP_LEFT);
        border.setLeft(ver);
        border.setCenter(root);
        border.setRight(text);

        VBox ver2=new VBox(ball,imageView2,imageView);
        ver2.setSpacing(5);
        ver2.setAlignment(Pos.BOTTOM_CENTER);
        border.setBottom(ver2);


        border.setStyle("-fx-background-color: #000000;");
        stage.setTitle("Play Game");
        scene.setRoot(border);
        stage.setScene(scene);
        stage.show();

    }
    }



