import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
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
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
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
            Group root2 = CircleObstacle();
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
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
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
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
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
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(img4);

        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
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
        clip1.setFill(Color.BLUE);
        Shape clip2= Shape.subtract(arc2,circ2);
        clip2.setFill(Color.RED);
        Shape clip3= Shape.subtract(arc3,circ3);
        clip3.setFill(Color.YELLOW);
        Shape clip4= Shape.subtract(arc4,circ4);
        clip4.setFill(Color.DARKVIOLET);

        Group root=new Group(clip1,clip2,clip3,clip4);

//        Scene scene=new Scene(root,600,600);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
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

        Image image = new Image("star.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setX(110);
        imageView.setY(200);
        imageView.setPreserveRatio(true);

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
        root.getChildren().add(imageView);
        BorderPane border=new BorderPane();
        VBox ver=new VBox(btn1,btn2);
        ver.setSpacing(10);
        ver.setAlignment(Pos.TOP_LEFT);
        border.setLeft(ver);
        border.setCenter(root);
        border.setRight(text);

        border.setStyle("-fx-background-color: #000000;");
        stage.setTitle("Play Game");
        scene.setRoot(border);
        stage.setScene(scene);
        stage.show();

    }
    }



