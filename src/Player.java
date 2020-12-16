import javafx.animation.TranslateTransition;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.Serializable;

public class Player implements Serializable {
    private Game currentGame;
    private int totalStars;
    private Ball ball;
    public Player(Game game)
    {
        this.currentGame= game;
        this.ball = new Ball();
        this.totalStars = 0;
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
