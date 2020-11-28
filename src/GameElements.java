import java.util.ArrayList;

public abstract class GameElements {
    protected ArrayList<Integer> position;
    public GameElements(){
        this.position=new ArrayList<Integer>();
    }
    public void setPosition(){

    }
    public ArrayList<Integer> getPosition(){
        return this.position;
    }
    public abstract void role();
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
    public void role(){

    }
}
class Star extends GameElements{
    @Override
    public void role()
    {

    }
    public void disappear()
    {

    }
}
class Obstacle extends GameElements{
    private String type_of_obstacle;
    private int rotation_speed;

    public int getRotation_speed() {
        return rotation_speed;
    }

    public void setRotation_speed(int rotation_speed) {
        this.rotation_speed = rotation_speed;
    }
    public String getType_of_obstacle(){
        return this.type_of_obstacle;
    }

    public void setType_of_obstacle(String type_of_obstacle) {
        this.type_of_obstacle = type_of_obstacle;
    }

    @Override
    public void role()
    {

    }
}
class LineObstacle extends Obstacle{
    private int length;
    public void setPosition(int s) {
        this.length=s;
    }

    public int getLength() {
        return length;
    }
}
class CircleObstacle extends Obstacle{
    private int radius;
    public void setRadius(int s) {
        this.radius=s;
    }

    public int getRadius() {
        return radius;
    }
}
class SquareObstacle extends Obstacle{
    private int sideLength;
    public void setSideLength(int s) {
        this.sideLength=s;
    }

    public int getSideLength() {
        return sideLength;
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
}
class PlusObstacle extends Obstacle{
    private int length;
    public void setPosition(int s) {
        this.length=s;
    }

    public int getLength() {
        return length;
    }
}
