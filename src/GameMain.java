public class GameMain {
    private Player player;
    private int bestScore;
    public GameMain(){
        this.player=new Player(this);
        this.bestScore=0;
    }

    public void newGame(){

    }
    public void resumeGame(){

    }
    public void exitGame(){

    }
    public void selectFromSavedGames(){

    }
    public void reloadGame(){

    }
    public int getBestScore(){
        return this.bestScore;
    }
    public void setBestScore(){

    }

}

class Player
{
    private GameMain currentGame;
    private int totalStars;
    private Ball ball;
    public Player(GameMain game)
    {
        this.currentGame= game;
        this.ball = new Ball();
        this.totalStars = 0;
    }
    public int getTotalStar(){
       return totalStars;
    }
    public void collectStar(){
        totalStars++;
    }
    public boolean checkHitObstacle(){
        return true;
    }
    public boolean compareBestScore(){
        return true;
    }
    public void moveBall(){

    }
    public void restartGame(){

    }
    public void pauseGame(){

    }
    public void saveGame(){

    }
    public void loadGame() {

    }
    public void ContinueGame(){

    }
    public void exitToMainMenu(){

    }

}
