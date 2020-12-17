import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game extends Application implements Serializable {
    transient private Player player;
    private static final long serialVersionUID = 40L;
    //transient private static String FileName;
    transient private static long oldtime;
    private static boolean IsClicked;
    transient private static int pos_star;
    transient private static int score;
    transient private CircleObstacle Circle;
    transient private LineObstacle Line;
    transient private PlusObstacle Plus;
    transient private SquareObstacle Square;
    transient private Star Star;
    transient private ColorSwitcher colorswitcher;
    private int bestScore;
   // private double SaveArray[];
    private double[] SaveArray;

    public int getBestScore(){
        return this.bestScore;
    }

    public Game(){
        player=Player.getInstance(this);
        Circle=(CircleObstacle) GameElements.getInstance("CircleObstacle");
        Line=(LineObstacle) GameElements.getInstance("LineObstacle");
        Plus=(PlusObstacle) GameElements.getInstance("PlusObstacle");
        IsClicked=false;
        Square=(SquareObstacle) GameElements.getInstance("SquareObstacle");
        Star=(Star) GameElements.getInstance("Star");
        colorswitcher=(ColorSwitcher) GameElements.getInstance("ColorSwitcher");
        bestScore=0;
        SaveArray=new double[5];
    }
 transient private MediaPlayer mediaPlayer;
    @Override
    public void start(Stage stage) throws Exception {
        String source = new File("Music/track.mp3").toURI().toString();
        Media media = null;
        media = new Media(source);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
         mediaPlayer.setAutoPlay(true);
         mediaPlayer.play();
        MainMenuGUI(stage);
    }
    public void MainMenuGUI(Stage stage) {
        stage.setTitle("Color Switch");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);
        Pane parent = new Pane();
        ImageView img=new ImageView();
        img.setImage(new Image("Images/mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("Images/ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("Images/ring.png"));
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
        BackgroundImage myBI= new BackgroundImage(new Image("Images/mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        Scene scene = new Scene(parent);
        Button btn1 = new Button("New Game");
        //    btn1.setMinSize(150, 25);
        btn1.setLayoutX(200);
        btn1.setLayoutY(210);
        btn1.setPrefWidth(200);
        btn1.setStyle(
                "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: #FF008F;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: #FF008F;");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in main menu");
            GamePlay(stage,scene,false);
        });

        Button btn2 = new Button("Resume");
        // btn2.setMinSize(150, 25);
        btn2.setLayoutX(200);
        btn2.setLayoutY(310);
        btn2.setPrefWidth(200);
        btn2.setStyle(
                "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: cyan;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: cyan;");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in main menu");
            SavedGames(stage,scene);
        });

        Button btn3 = new Button("Exit");
        btn3.setLayoutX(200);
        btn3.setLayoutY(410);
        btn3.setPrefWidth(200);
        // btn3.setMinSize(150, 25);
        btn3.setStyle(
                "-fx-border-radius: 60px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: yellow;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: yellow;");
        btn3.setOnAction(e->{
            System.out.println("Pressed button 3 in main menu");
            Platform.exit();
        });

        parent.getChildren().addAll(btn1,btn2,btn3);
        stage.setScene(scene);
        stage.show();
    }
    public void PauseGameGUI(Stage stage,Scene scene,double[] SaveArray) {
        stage.setTitle("Pause Menu");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);

        Pane parent = new Pane();
        ImageView img=new ImageView();
        img.setImage(new Image("Images/mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("Images/ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("Images/ring.png"));
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
        BackgroundImage myBI= new BackgroundImage(new Image("Images/mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);

        Button btn1 = new Button("Save");
        btn1.setMinSize(150, 25);
        btn1.setPrefWidth(200);
        btn1.setStyle(
                "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: FF0AF2;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: #ED33E3;");
        btn1.setLayoutX(190);
        btn1.setLayoutY(230);
        btn1.setOnAction(e->{
            System.out.println("Save Game");
            try{
                serialize();
                System.out.println("DONE SERIALIZE");
            }
            catch (Exception ignored){
                System.out.println("ERROR IN SERIALIZE:221");
            }
        });

        Button btn2 = new Button(" Resume");
        btn2.setMinSize(150, 25);
        btn2.setLayoutX(190);
        btn2.setLayoutY(330);
        btn2.setPrefWidth(200);
//        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setStyle(
                "-fx-border-radius: 60px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: cyan;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: cyan;");
        btn2.setOnAction(e->{
         ResumeGameTemp(stage, scene);
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
        img.setImage(new Image("Images/mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("Images/ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("Images/ring.png"));
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
        BackgroundImage myBI= new BackgroundImage(new Image("Images/mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);
        Text text = new Text();
        text.setText("SELECT GAME");
        text.setX(200);
        text.setY(180);
        text.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setFill(Color.valueOf("#00FFCD"));
        VBox Contents=new VBox();
        ArrayList<String> SavedGameFileName=new ArrayList<String>();
        File folder = new File("SavedGames/");
        File[] listOfFiles = folder.listFiles();
        Button button;
        Button btn1 = new Button("Delete All");
        btn1.setLayoutX(220);
        btn1.setLayoutY(200);
       // btn1.setMinSize(150, 25);
        btn1.setStyle(
                "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: #FF009B;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 15px;" + "-fx-border-width:0.09em;"+ "-fx-border-color: #FF009B;");
        btn1.setOnAction(e->{
            System.out.println("Removed Saved Games");
            // Save save=new Save();
            File fold = new File("SavedGames/");
            for(File file: Objects.requireNonNull(fold.listFiles()))
                if (!file.isDirectory())
                    file.delete();
            MainMenuGUI(stage);
        });

        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            if (listOfFiles[i].isFile()) {
                SavedGameFileName.add(i,listOfFiles[i].getName());}
        }

        Image imageexit = new Image("Images/exit2.png");
        ImageView exit = new ImageView(imageexit);
        exit.setFitHeight(60);
        exit.setFitWidth(60);
        exit.setPreserveRatio(true);
        Button btn2 = new Button();
        btn2.setStyle("-fx-background-color: black; ");
        btn2.setGraphic(exit);
        btn2.setPrefSize(60, 60);
        btn2.setOnAction(e->{
        //    System.out.println("exit");
            MainMenuGUI(stage);
        });
        btn2.setLayoutX(5);
        btn2.setLayoutY(25);
        parent.getChildren().add(btn2);
    //Iterator Design Pattern
        Iterator itr= SavedGameFileName.iterator();
        while(itr.hasNext()){
            Object obj=itr.next();
            String s=(String)obj;
                button=new Button(s);
                button.setStyle(
                        "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: cyan;" + "-fx-font-family: serif;" +
                                "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 10px;" + "-fx-border-width:0.07em;"+ "-fx-border-color: cyan;");
            button.setOnAction(actionEvent -> {
                    try{
                        SaveArray=deserialize(s).SaveArray;
                        GamePlay(stage,scene,true);
                    }
                    catch (Exception err){
                        System.out.println(err);
                    }
                });
                Contents.getChildren().add(button);
            }

        Contents.setSpacing(5);
        Contents.setLayoutX(180);
        Contents.setLayoutY(265);

        parent.getChildren().addAll(text,btn1,Contents);
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
        img.setImage(new Image("Images/mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("Images/ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        parent.getChildren().add(img3);

        ImageView img4=new ImageView();
        img4.setImage(new Image("Images/ring.png"));
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
        BackgroundImage myBI= new BackgroundImage(new Image("Images/mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);

        Button btn1 = new Button("Continue");
        btn1.setMinSize(150, 25);
        btn1.setLayoutX(190);
        btn1.setLayoutY(210);
        btn1.setPrefWidth(200);
        btn1.setStyle(
                "-fx-border-radius: 60px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: yellow;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: yellow;");
        btn1.setOnAction(e->{
           ResumeGameTemp(stage,scene);
        });

        Button btn2 = new Button("Restart");
        btn2.setMinSize(150, 25);
        btn2.setLayoutX(190);
        btn2.setLayoutY(310);
        btn2.setPrefWidth(200);
        btn2.setStyle(
                "-fx-border-radius: 60px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: cyan;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: cyan;");
        btn2.setOnAction(e->{
            GamePlay(stage,scene,false);
         //   System.out.println("Pressed button 2 in exit menu");
        });

        Button btn3 = new Button("Main Menu");
        btn3.setMinSize(150, 25);
        btn3.setLayoutX(190);
        btn3.setLayoutY(410);
        btn3.setPrefWidth(200);
        btn3.setStyle(
                "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: FF0AF2;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: #ED33E3;");
        btn3.setOnAction(e->{
        //    System.out.println("Pressed button 3 in exit menu");
            stage.close();
            MainMenuGUI(new Stage());
        });
        parent.getChildren().addAll(btn1,btn2,btn3);
        stage.setScene(scene);
        stage.show();
    }
    public void GamePlay (Stage stage,Scene scene,boolean CallFromSave) {
        if(CallFromSave){
            score= (int) SaveArray[0];
            bestScore=(int) SaveArray[3];
        }
        else {
            score =0;
        }

        Image imagescore = new Image("Images/scorestars.png");
        ImageView scorestar = new ImageView(imagescore);
        scorestar.setFitHeight(40);
        scorestar.setFitWidth(80);
        scorestar.setLayoutX(500);
        scorestar.setLayoutY(10);
        Text text = new Text();
        text.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 50));
        text.setX(520);
        text.setY(100);
        text.setText(""+score);
        text.setFill(Color.WHITE);

        Image imagepause = new Image("Images/pause1.png");
        ImageView pause = new ImageView(imagepause);
        pause.setFitHeight(60);
        pause.setFitWidth(60);
        pause.setPreserveRatio(true);
        Button btn1 = new Button();
        btn1.setPrefSize(60, 60);
        btn1.setStyle("-fx-background-color: black; ");
        btn1.setGraphic(pause);
        btn1.setOnAction(e->{
        //    System.out.println("Pause the game");
            PauseGameGUI(stage,scene,SaveArray);
        });

        Image imageexit = new Image("Images/exit2.png");
        ImageView exit = new ImageView(imageexit);
        exit.setFitHeight(60);
        exit.setFitWidth(60);
        exit.setPreserveRatio(true);
        Button btn2 = new Button();
        btn2.setStyle("-fx-background-color: black; ");
        btn2.setGraphic(exit);
        btn2.setPrefSize(60, 60);
        btn2.setOnAction(e->{
          //  System.out.println("exit");
            ExitGUI(stage,scene);
        });

        javafx.scene.shape.Circle ball= player.getBall().getBall();
        ball.setFill(Color.YELLOW);

        Image image = new Image("Images/text.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);

        Image image2 = new Image("Images/hand2.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(60);
        imageView2.setFitWidth(60);
        imageView2.setPreserveRatio(true);

        BorderPane border=new BorderPane();
        border.setStyle("-fx-background: black; -fx-border-color: black;");
        VBox ver=new VBox(btn1,btn2);
        ver.setSpacing(10);
        ver.setAlignment(Pos.TOP_LEFT);
        Group switcher= colorswitcher.getObstacle();
        Group star = Star.getObstacle();
        GridPane gridPane = new GridPane();
        //gridPane.setMaxWidth(350);
        //gridPane.setPrefWidth(350);
        gridPane.setMaxHeight(Double.MAX_VALUE);
        //gridPane.setPrefHeight(Double.MAX_VALUE);
        gridPane.setVgap(200);
        gridPane.setLayoutX(150);
        gridPane.setLayoutY(-1920);
        gridPane.setStyle("-fx-background: transparent; -fx-border-color: transparent;");
        gridPane.setAlignment(Pos.CENTER);
        Group root = Circle.Big_circle();
        Group root2 = Square.getObstacle();
        Group root3 = Circle.getObstacle();
        Group root4 = Plus.getObstacle();
        CircleObstacle Circle2=(CircleObstacle) GameElements.getInstance("CircleObstacle");
        Group root5= Circle2.getObstacle();
        gridPane.add(root3, 0, 0);
        gridPane.add(root, 0, 1);
        gridPane.add(root4, 0, 3);
        gridPane.add(root2, 0, 4);
        gridPane.add(root5, 0, 5);
        gridPane.add(switcher, 0, 2);
        GridPane.setHalignment(root, HPos.CENTER);
        GridPane.setHalignment(root3, HPos.CENTER);
        GridPane.setHalignment(root2, HPos.CENTER);
        GridPane.setHalignment(root4, HPos.LEFT);
        GridPane.setHalignment(root5, HPos.CENTER);
        GridPane.setHalignment(switcher, HPos.CENTER);
        gridPane.add(star, 0, 5); //column
        GridPane.setHalignment(star, HPos.CENTER);
        Button btn3 = new Button();
        btn3.setMinSize(60, 60);
//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn3.setStyle("-fx-font-size: 2em;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn3.setGraphic(imageView2);
        btn3.setOnAction(e->{
            String source = new File("Music/jump.wav").toURI().toString();
            Media media = null;
            media = new Media(source);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(1);
            //   mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();

        });
        if(CallFromSave){
            score=(int) SaveArray[0];
            gridPane.setTranslateY(SaveArray[2]);
            ball.setTranslateY(SaveArray[1]);
            bestScore=(int) SaveArray[3];
            pos_star= (int) SaveArray[4];
       //     System.out.println("Updated pos_star: "+pos_star);
            IsClicked=false;
            gridPane.getChildren().remove(star);
            gridPane.add(star, 0, pos_star);
        }
        else{
            pos_star= GridPane.getRowIndex(star);
        }
        oldtime = System.currentTimeMillis();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

         //       System.out.println(Circle.getRotation());
                oldtime = System.currentTimeMillis();
                if(ball.getTranslateY()>-100) {
                    TranslateTransition translateTransition = new TranslateTransition();
                    translateTransition.setDuration(Duration.millis(150));
                    translateTransition.setNode(ball);
                    translateTransition.setByY(-35);
                    translateTransition.setCycleCount(1);
                    translateTransition.play();

                }
                else
                    player.Moveball(gridPane);
            }
        };
        btn3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        VBox ver2=new VBox(btn3,imageView);
        ver2.setAlignment(Pos.BOTTOM_CENTER);
        ver2.setSpacing(3);
        ver2.setLayoutX(230);
        ver2.setLayoutY(500);
        ver.setLayoutX(5);
        ver.setLayoutY(20);
        Group mainroot = new Group(ver,gridPane,ball,ver2,text,scorestar);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(btn3.isPressed()){
                    IsClicked=true;
                }
                if(System.currentTimeMillis()-oldtime>=200 && IsClicked)
                {
                    if(ball.getTranslateY()<=-25) {
                        TranslateTransition translateTransition = new TranslateTransition();
                        translateTransition.setDuration(Duration.millis(100));
                        translateTransition.setNode(ball);
                        translateTransition.setByY(25);
                        translateTransition.setCycleCount(1);
                        translateTransition.play();
                    }
                    else {
                        if(gridPane.getTranslateY()>=25) {
                            TranslateTransition translateTransition = new TranslateTransition();
                            translateTransition.setDuration(Duration.millis(100));
                            translateTransition.setNode(gridPane);
                            translateTransition.setByY(-25);
                            translateTransition.play();
                        }
                    }
                }
                if(gridPane.getTranslateY()>=1920){
                    gridPane.setTranslateY(4);
                    gridPane.getChildren().remove(star);
                    pos_star=5;
                    gridPane.add(star, 0, pos_star);
                    if(gridPane.getChildren().contains(switcher)){
                        gridPane.getChildren().remove(switcher);
                        gridPane.add(switcher, 0, 2);
                    }
                    else{
                        gridPane.add(switcher, 0, 2);
                    }
                }
            }
        }.start();

        java.awt.Color colors[] = new java.awt.Color[3];
        colors[0]= new java.awt.Color(255,20,147);
        colors[1]= java.awt.Color.BLUE;
        colors[2]= java.awt.Color.CYAN;

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (btn1.isPressed()) {
                    SaveArray[0]= (double)score;
                    SaveArray[1]= ball.getTranslateY();
                    SaveArray[2]= gridPane.getTranslateY();
                    SaveArray[3]= (double)bestScore;
                    SaveArray[4]= (double)GridPane.getRowIndex(star);
               //     System.out.println("Star Pos:"+ SaveArray[4]);
                    stop();
                    PauseGameGUI(stage, scene, SaveArray);
                } else if (btn2.isPressed()) {
                    SaveArray[0]= (double)score;
                    SaveArray[1]= ball.getTranslateY();
                    SaveArray[2]= gridPane.getTranslateY();
                    SaveArray[3]= (double)bestScore;
                    SaveArray[4]= (double)GridPane.getRowIndex(star);
             //       System.out.println("EXIT");
                    stop();
                }
                else{
                    Bounds bounds = ball.getBoundsInLocal();
                    Bounds screenBounds = ball.localToScreen(bounds);
                    int x = (int) screenBounds.getMinX()+(int) (screenBounds.getWidth()/2);
                    int y2= (int) screenBounds.getMinY()-1;
                    int y3= (int) screenBounds.getMaxY()+1;
                    java.awt.Color d = null;
                    java.awt.Color d2 = null;
                    try {
                        Robot r = new Robot();
                        d = r.getPixelColor(x,y2 );
                        d2 = r.getPixelColor(x,y3 );
                    }
                    catch (Exception ignored) {
                    }
                    if( d.equals(colors[0]) || d.equals(colors[1]) || d.equals(colors[2]) || d2.equals(colors[0]) || d2.equals(colors[1]) || d2.equals(colors[2])) {
                        stop();
                        GameScoreGUI(stage,scene);
                    }
                    if(screenBounds.intersects(star.localToScreen(star.getBoundsInLocal()))) {
                        if(gridPane.getTranslateY()<1890){
                            gridPane.getChildren().remove(star);
                            score++;
                            if(score==bestScore+1)
                            {
                                String source = new File("Music/win.mp3").toURI().toString();
                                Media media = null;
                                media = new Media(source);
                                MediaPlayer mediaPlayer = new MediaPlayer(media);
                                mediaPlayer.setCycleCount(1);
                                mediaPlayer.setAutoPlay(true);
                                mediaPlayer.play();
                                Image image = new Image("Images/trophy.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setFitHeight(180);
                                imageView.setFitWidth(90);
                                imageView.setPreserveRatio(true);
                                imageView.setLayoutY(130);
                                imageView.setLayoutX(490);
                                ScaleTransition scaleTransition = new ScaleTransition();
                                scaleTransition.setDuration(Duration.millis(2000));
                                scaleTransition.setNode(imageView);
                                scaleTransition.setByY(0.6);
                                scaleTransition.setByX(0.6);
                                scaleTransition.setCycleCount(2);
                                scaleTransition.setAutoReverse(true);
                                scaleTransition.play();
                                mainroot.getChildren().add(imageView);
                            }
                            if(score>9)
                                text.setX(500);
                            text.setText(""+score);
                            pos_star= pos_star-1;
                            if(pos_star==2)
                                pos_star=pos_star-1;
                            gridPane.add(star, 0, pos_star);
                            GridPane.setHalignment(root5, HPos.CENTER);

                            String source = new File("Music/star.wav").toURI().toString();
                            Media media = null;
                            media = new Media(source);
                            MediaPlayer mediaPlayer = new MediaPlayer(media);
                            mediaPlayer.setCycleCount(1);
                            mediaPlayer.setAutoPlay(true);
                            mediaPlayer.play();
                            if(((score%5)==0)  && (score!=0)){
                                Duration dur1=Circle.getRotation();
                                Circle.SetRotation(dur1.subtract(Duration.millis(100)));
                                Duration dur2=Circle.getRotation2();
                                Circle.SetRotation2(dur2.subtract(Duration.millis(150)));
                                Duration dur3=Circle2.getRotation();
                                Circle2.SetRotation(dur3.subtract(Duration.millis(100)));
                                Duration dur4=Plus.getRotation();
                                Plus.SetRotation(dur4.subtract(Duration.millis(500)));
                                Duration dur5=Square.getRotation();
                                Square.SetRotation(dur5.subtract(Duration.millis(140)));
                            }
                        }
                    }
                    else if(screenBounds.intersects(switcher.localToScreen(switcher.getBoundsInLocal()))) {
                        gridPane.getChildren().remove(switcher);
                        Random rand = new Random();
                        int random = rand.nextInt(3);
                        java.awt.Color temp=null;
                        java.awt.Color awt2=toawt((Color)ball.getFill());
                        temp=colors[random];
                        colors[random]=awt2;
                        awt2=temp;
                        ball.setFill(awtToJavaFX(awt2));
                    }
                }
            }
        }.start();
        stage.setTitle("Play Game");
        scene.setRoot(mainroot);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
    public Color awtToJavaFX(java.awt.Color c) {
        return javafx.scene.paint.Color.rgb(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha() / 255.0);
    }
    public java.awt.Color toawt(Color fx) {
        java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),(float) fx.getGreen(), (float) fx.getBlue(), (float) fx.getOpacity());
        return awtColor;
    }
    public Game deserialize(String fileName) throws IOException,ClassNotFoundException {

        ObjectInputStream in = null;
        Game retrieve=null;
        try {
            in = new ObjectInputStream (new FileInputStream("SavedGames/"+fileName));
            retrieve= (Game) in.readObject();
        } finally {
            assert in != null;
            in.close();
        }
        return retrieve;
    }
    public Game deserializeResume() throws IOException,ClassNotFoundException {

        ObjectInputStream in = null;
        Game retrieve=null;
        try {
            in = new ObjectInputStream (new FileInputStream("Music/temp.txt"));
            retrieve= (Game) in.readObject();
        } finally {
            assert in != null;
            in.close();
        }
        return retrieve;
    }
    public void serializeResume() throws IOException {
        String file = ("Music/temp.txt") ;
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream(file));
            out.writeObject(this);
        } finally {
            assert out != null;
            out.close();
        }
    }
    public void serialize() throws IOException {
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH-mm-ss") ;
        String file = ("SavedGames/"+dateFormat.format(date) + ".txt") ;
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream(file));
            out.writeObject(this);
        } finally {
            assert out != null;
            out.close();
        }
    }
    public void GameScoreGUI(Stage stage,Scene scene){
        stage.setTitle("GAME OVER");
        stage.setHeight(695);
        stage.setWidth(600);
        stage.setResizable(false);
        Pane parent=new Pane();
        ImageView img4=new ImageView();
        img4.setImage(new Image("Images/ring.png"));
        img4.setFitHeight(150);
        img4.setFitWidth(150);
        img4.setLayoutX(420);
        img4.setLayoutY(253);

        parent.getChildren().add(img4);
        ImageView img=new ImageView();
        img.setImage(new Image("Images/mainbg.jpg"));
        ImageView img3=new ImageView();
        img3.setImage(new Image("Images/ring.png"));
        img3.setFitHeight(150);
        img3.setFitWidth(150);
        img3.setLayoutX(20);
        img3.setLayoutY(250);
        RotateTransition rotateTransition2=new RotateTransition();
        rotateTransition2.setNode(img3);
        parent.getChildren().add(img3);
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

        if(score>bestScore){
            bestScore=score;
            Image image = new Image("Images/trophy.png");
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(180);
            imageView.setFitWidth(90);
            imageView.setPreserveRatio(true);
            imageView.setLayoutY(60);
            imageView.setLayoutX(450);
            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setDuration(Duration.millis(2000));
            scaleTransition.setNode(imageView);
            scaleTransition.setByY(0.6);
            scaleTransition.setByX(0.6);
            scaleTransition.setCycleCount(Animation.INDEFINITE);
            scaleTransition.setAutoReverse(true);
            scaleTransition.play();
            parent.getChildren().add(imageView);
            Image image2 = new Image("Images/trophy.png");
            ImageView imageView2 = new ImageView(image2);
            imageView2.setFitHeight(180);
            imageView2.setFitWidth(90);
            imageView2.setPreserveRatio(true);
            imageView2.setLayoutY(60);
            imageView2.setLayoutX(50);
            ScaleTransition scaleTransition2 = new ScaleTransition();
            scaleTransition2.setDuration(Duration.millis(2000));
            scaleTransition2.setNode(imageView2);
            scaleTransition2.setByY(0.6);
            scaleTransition2.setByX(0.6);
            scaleTransition2.setCycleCount(Animation.INDEFINITE);
            scaleTransition2.setAutoReverse(true);
            scaleTransition2.play();
            parent.getChildren().add(imageView2);
        }
        BackgroundImage myBI= new BackgroundImage(new Image("Images/mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Text text = new Text();
        text.setText("SCORE: "+score);
        text.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 35));
        text.setFill(Color.valueOf("#FF008F"));
        text.setX(220);
        text.setY(220);
        Text text2 = new Text();
        text2.setText("BEST SCORE: "+bestScore);
        text2.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text2.setFill(Color.valueOf("#FF008F"));
        text2.setX(190);
        text2.setY(280);
        parent.getChildren().addAll(text,text2);
        Button btn4=null;
        if(bestScore>=5 && score>=5){
         //   System.out.println("Continue");
            btn4 = new Button("Continue Game");
            btn4.setMinSize(150, 25);
            btn4.setLayoutX(200);
            btn4.setLayoutY(300);
            btn4.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 20));
            btn4.setStyle(
                    "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: #00FFCF;" + "-fx-font-family: serif;" +
                            "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 18px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: #00FFCF;");
        }
        Button btn3 = new Button("Exit to Main Menu");
        btn3.setMinSize(150, 25);
        btn3.setLayoutX(200);
        btn3.setLayoutY(380);
        btn3.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 30));
//        btn3.setStyle("-fx-font-size: 1.5em; ");
        btn3.setStyle(
                "-fx-border-radius: 57px;" +"-fx-background-color: #000000;"+ "-fx-text-fill: #00FFCF;" + "-fx-font-family: serif;" +
                        "-fx-font-size: 20px;" + "-fx-font-weight: 200;" + "-fx-padding: 20px;" + "-fx-border-width:0.22em;"+ "-fx-border-color: #00FFCF;");
        btn3.setOnAction(e->{
         //   System.out.println("Pressed button 3 in exit menu");
           // stage.close();
            MainMenuGUI(stage);
        });
        if(btn4!=null && score>=5){
            btn4.setOnAction(e->{
                SaveArray[0]= (double) (score - 5);
                try{
                    serializeResume();
                    this.SaveArray=deserializeResume().SaveArray;
                //    System.out.println("DONE Resuming");
                    GamePlay(stage,scene,true);
                    //show game saved Succefully
                }
                catch (Exception i){
                    System.out.println(i);
                  //  System.out.println("ERROR at line 959");
                }

            });
            parent.getChildren().add(btn4);
        }
        parent.getChildren().add(btn3);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);
        stage.setScene(scene);
        stage.show();

    }
    //Template Design Pattern
    public final void ResumeGameTemp(Stage stage,Scene scene){
        try{
            serializeResume();
            this.SaveArray=deserializeResume().SaveArray;
            GamePlay(stage,scene,true);
        }
        catch (Exception i){
            System.out.println(i);
        }
    }

}
