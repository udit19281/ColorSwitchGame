import javafx.animation.TranslateTransition;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.Serializable;

public class Player implements Serializable {
    private Game currentGame;
    private Ball ball;
    private int totalStars;
    private static Player instance;
    //Singleton Design pattern
    private Player(Game game)
    {
        this.currentGame= game;
        this.ball = new Ball();
        this.totalStars = 0;
        this.totalStars= currentGame.getBestScore();
    }
    public static Player getInstance(Game game){
        if(instance==null){
            instance=new Player(game);
        }
        return instance;
    }
    public int getTotalStars(){
        return totalStars;
    }

    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }

    public Ball getBall() {
        return ball;
    }

    public void Moveball(GridPane gridPane) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(150));
        translateTransition.setNode(gridPane);
        translateTransition.setByY(35);
        translateTransition.play();
    }
}
