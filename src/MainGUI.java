import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        MainMenuGUI(stage);
    }
    public void MainMenuGUI(Stage stage){
        stage.setTitle("Color Switch");

        GridPane parent = new GridPane();
        parent.setAlignment(Pos.CENTER);
        BackgroundImage image = new BackgroundImage(new Image("colorswitch.png", 800, 700, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        parent.setBackground(new Background(image));
        Scene scene = new Scene(parent, 800, 700);

        Button btn1 = new Button("New Game");
        btn1.setMinSize(150, 25);
        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in main menu");
        });

        Button btn2 = new Button("Resume");
        btn2.setMinSize(150, 25);
        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in main menu");
            PauseGameGUI(stage,scene);
        });

        Button btn3 = new Button("Exit");
        btn3.setMinSize(150, 25);
        btn3.setStyle("-fx-font-size: 1.5em; ");
        btn3.setOnAction(e->{
            System.out.println("Pressed button 3 in main menu");
            ExitGUI(stage,scene);
        });

        parent.setVgap(5);
        parent.add(btn1, 1, 0);
        parent.add(btn2, 1, 2);
        parent.add(btn3, 1, 4);

        stage.setScene(scene);
        stage.show();
    }
    public void PauseGameGUI(Stage stage,Scene scene){
        stage.setTitle("Pause Menu");
        GridPane parent = new GridPane();
        parent.setAlignment(Pos.CENTER);
        BackgroundImage image = new BackgroundImage(new Image("colorswitch.png", 800, 700, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        parent.setBackground(new Background(image));

        scene.setRoot(parent);

        Button btn1 = new Button("Save Game");
        btn1.setMinSize(150, 25);
        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in pause menu");
        });

        Button btn2 = new Button("Resume Game");
        btn2.setMinSize(150, 25);
        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in pause menu");
        });

        parent.setVgap(5);
        parent.add(btn1, 1, 0);
        parent.add(btn2, 1, 2);

        stage.setScene(scene);
        stage.show();
    }
    public void ExitGUI(Stage stage,Scene scene){
        stage.setTitle("Exit Menu");
        GridPane parent = new GridPane();
        parent.setAlignment(Pos.CENTER);
        BackgroundImage image = new BackgroundImage(new Image("colorswitch.png", 800, 700, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        parent.setBackground(new Background(image));

        scene.setRoot(parent);

        Button btn1 = new Button("Continue Game");
        btn1.setMinSize(150, 25);
        btn1.setStyle("-fx-font-size: 1.5em; ");
        btn1.setOnAction(e->{
            System.out.println("Pressed button 1 in exit menu");
        });

        Button btn2 = new Button("Restart Game");
        btn2.setMinSize(150, 25);
        btn2.setStyle("-fx-font-size: 1.5em; ");
        btn2.setOnAction(e->{
            System.out.println("Pressed button 2 in exit menu");
        });

        Button btn3 = new Button("Main Menu ");
        btn3.setMinSize(150, 25);
        btn3.setStyle("-fx-font-size: 1.5em; ");
        btn3.setOnAction(e->{
            System.out.println("Pressed button 3 in exit menu");
        });

        parent.setVgap(5);
        parent.add(btn1, 1, 0);
        parent.add(btn2, 1, 2);
        parent.add(btn3,1,3);

        stage.setScene(scene);
        stage.show();
    }

}


