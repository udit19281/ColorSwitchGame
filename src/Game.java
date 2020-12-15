import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Game extends Application implements Serializable {
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
    transient private Colorswitcher colorswitcher;
    private int bestScore;
    private double SaveArray[];

    public Game(){
        Circle=new CircleObstacle();
        Line=new LineObstacle();
        Plus=new PlusObstacle();
        IsClicked=false;

        Square=new SquareObstacle();
        Star=new Star();
        colorswitcher= new Colorswitcher();
        bestScore=0;
        SaveArray=new double[5];
    }
    @Override
    public void start(Stage stage) throws Exception {
        String source = new File("Music/track.mp3").toURI().toString();
        Media media = null;
        media = new Media(source);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(200);
      //  mediaPlayer.setAutoPlay(true);
      //  mediaPlayer.play();
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
            GamePlay(stage,scene,false);
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

        Button btn1 = new Button("Save");
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
            System.out.println("Save Game");
          //Save save=new Save(SaveArray);
          try{
              serialize();
              System.out.println("DONE SERIALIZE");
              //show game saved Succefully
          }
          catch (Exception ignored){

              System.out.println("ERROR IN SERIALIZE:221");
            }
        });

        Button btn2 = new Button(" Resume");
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
            GamePlay(stage,scene,true);
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
        text.setX(200);
        text.setY(200);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setFill(Color.WHITE);

        VBox Contents=new VBox();
        ArrayList<String> SavedGameFileName=new ArrayList<String>();
        File folder = new File("SavedGames/");
        File[] listOfFiles = folder.listFiles();
        Button button;
        ArrayList<Button> buttonArrayList=new ArrayList<Button>();

        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            if (listOfFiles[i].isFile()) {
                SavedGameFileName.add(i,listOfFiles[i].getName());
                button=new Button(listOfFiles[i].getName());
                buttonArrayList.add(button);
                button.setStyle("-fx-font-size: 1.5em;" +
                        "-fx-background-color: #000000;" +
                        "-fx-text-fill:#ffffff;");
              String FileName=SavedGameFileName.get(i);
                button.setOnAction(actionEvent -> {
                    try{
                        SaveArray=deserialize(FileName);
                        System.out.println("Done Deserialize");
                        GamePlay(stage,scene,true);
                    }
                    catch (Exception err){
                        System.out.println(err);
                        System.out.println("ERROR IN DESERIALIZE");
                    }
                });
                Contents.getChildren().add(button);
            }
        }

        Button btn1 = new Button("Delete All");
        btn1.setMinSize(150, 25);

//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 138px; -fx-max-height: 138px;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setOnAction(e->{
            System.out.println("Removed Saved Games");
           // Save save=new Save();
            File fold = new File("SavedGames/");
            for(File file: Objects.requireNonNull(fold.listFiles()))
                if (!file.isDirectory())
                    file.delete();
                MainMenuGUI(stage);
        });
        Contents.setSpacing(5);
        Contents.setLayoutX(200);
        Contents.setLayoutY(250);
        Contents.getChildren().add(btn1);
        parent.getChildren().addAll(text,Contents);
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
            GamePlay(stage,scene,true);
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
            GamePlay(stage,scene,false);
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
    public void GamePlay (Stage stage,Scene scene,boolean CallFromSave) {
        if(CallFromSave){
            score=(int)SaveArray[0];
            bestScore=(int)SaveArray[3];
        }
        else{
            score =0;
        }

        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setX(470);
        text.setY(25);
        text.setText("SCORE:"+score);
        text.setFill(Color.WHITE);
        Button btn1 = new Button("Pause");
        btn1.setMinSize(100, 25);
//        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setStyle("-fx-font-size: 2em;" +
                "-fx-background-color: #000000;" +
                "-fx-text-fill:#ffffff;");
        btn1.setOnAction(e->{

            System.out.println("Pause the game");
            PauseGameGUI(stage,scene,SaveArray);
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

        javafx.scene.shape.Circle ball=new Circle();
        ball.setRadius(12);
        ball.setLayoutX(294);
        ball.setLayoutY(450);
        ball.setFill(Color.YELLOW);

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
        Group root5= Circle.getObstacle();

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
                //mediaPlayer.setAutoPlay(true);

            //  mediaPlayer.play();

        });
        if(CallFromSave){
            //code
            score=(int)SaveArray[0];
            gridPane.setTranslateY(SaveArray[2]);
            ball.setTranslateY(SaveArray[1]);
            bestScore=(int)SaveArray[3];
            pos_star= (int)SaveArray[4];
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


                oldtime = System.currentTimeMillis();
                if(ball.getTranslateY()>-100) {
                    TranslateTransition translateTransition = new TranslateTransition();
                    translateTransition.setDuration(Duration.millis(100));
                    translateTransition.setNode(ball);
                    translateTransition.setByY(-35);
                    translateTransition.setCycleCount(1);
                    translateTransition.play();

                }
                else
                    Moveball(gridPane);
            }
        };
        btn3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
               // System.out.println("GRID HEIGHT: "+gridPane.getTranslateY());
                if(btn3.isPressed()){
                    IsClicked=true;
                }
                if(System.currentTimeMillis()-oldtime>=200 && IsClicked)
                {
                    if(ball.getTranslateY()<=-25)
                    {
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
                    System.out.println("SEYYYYYYYYYYYYYYYYYTTTTTTTTT");
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
                    System.out.println("HERE");
                    //sleep(5000);
                    SaveArray[0] = score;
                    SaveArray[1] = ball.getTranslateY();
                    SaveArray[2] = gridPane.getTranslateY();
                    SaveArray[3] = bestScore;
                    SaveArray[4]= GridPane.getRowIndex(star);
                    stop();
                    //MainMenuGUI(stage);
                    PauseGameGUI(stage, scene, SaveArray);
                } else if (btn2.isPressed()) {
                    System.out.println("EXIT");
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
                        // System.out.println(d2);
                    }
                    catch (Exception evt) {
                        // System.err.println(evt.getMessage());
                    }
                    if( d.equals(colors[0]) || d.equals(colors[1]) || d.equals(colors[2]) || d2.equals(colors[0]) || d2.equals(colors[1]) || d2.equals(colors[2]))
                    {
                        //System.out.println(d);
                        System.out.println("end");
                         stop();
                        GameScoreGUI(stage,scene);
                    }
                    if(screenBounds.intersects(star.localToScreen(star.getBoundsInLocal())))
                    {
                        if(gridPane.getTranslateY()<1890){
                            gridPane.getChildren().remove(star);
                            score++;
                            text.setText("SCORE:"+score);
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
                       //     mediaPlayer.play();
                        }
                    }
                    else if(screenBounds.intersects(switcher.localToScreen(switcher.getBoundsInLocal())))
                    {
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

        VBox ver2=new VBox(btn3,imageView);
        ver2.setAlignment(Pos.BOTTOM_CENTER);
        ver2.setSpacing(5);
        ver2.setLayoutX(250);
        ver2.setLayoutY(500);
        //border.setStyle("-fx-background-color: #000000;");
        stage.setTitle("Play Game");
        Group mainroot = new Group(ver,gridPane,ball,ver2,text);
        scene.setRoot(mainroot);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();

    }
    public Color awtToJavaFX(java.awt.Color c) {
        return javafx.scene.paint.Color.rgb(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha() / 255.0);
    }
    public java.awt.Color toawt(Color fx)
    {
        java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),(float) fx.getGreen(), (float) fx.getBlue(), (float) fx.getOpacity());
        return awtColor;
    }
    public void Moveball(GridPane gridPane) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(100));
        translateTransition.setNode(gridPane);
        translateTransition.setByY(35);
        translateTransition.play();
    }
    public double[] deserialize(String fileName) throws IOException,ClassNotFoundException {

        ObjectInputStream in = null;
        Game retrieve=null;
        try {
            in = new ObjectInputStream (new FileInputStream("SavedGames/"+fileName));
            retrieve= (Game) in.readObject();
        } finally {
            assert in != null;
            in.close();
        }
        return retrieve.SaveArray;
    }
    public void serialize() throws IOException {
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
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
        if(score>=bestScore){
            bestScore=score;
        }
        BackgroundImage myBI= new BackgroundImage(new Image("mainbg.jpg",600,660,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Text text = new Text();
        text.setText("SCORE: "+score);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text.setFill(Color.WHITE);
        text.setX(160);
        text.setY(280);
        Text text2 = new Text();
        text2.setText("BEST SCORE: "+bestScore);
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        text2.setFill(Color.WHITE);
        text2.setX(140);
        text2.setY(350);
        Button btn3 = new Button("Exit to Main Menu");
        btn3.setMinSize(150, 25);
        btn3.setLayoutX(200);
        btn3.setLayoutY(400);
        btn3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
//        btn3.setStyle("-fx-font-size: 1.5em; ");
        btn3.setStyle("-fx-font-size: 2em;" +
                "-fx-min-width: 80px; -fx-min-height: 80px;" +
                " -fx-max-width: 250px; -fx-max-height: 188px;" +
                "-fx-background-color: #2C3539;" +
                "-fx-text-fill:#ffffff;");
        btn3.setOnAction(e->{
            System.out.println("Pressed button 3 in exit menu");
            stage.close();
            MainMenuGUI(new Stage());
        });
        parent.getChildren().addAll(text,text2,btn3);
        parent.setBackground(new Background(myBI));
        scene.setRoot(parent);
        stage.setScene(scene);
        stage.show();

    }
}
