import java.io.*;
public class Save {
    Game saveMe;
    Save(Game g){
        this.saveMe=g;
    }
    public void serialize() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("out.txt"));
            out.writeObject(saveMe);
        } finally {
            out.close();
        }
    }

    public Game deserialize() throws IOException,ClassNotFoundException {
        ObjectInputStream in = null;
        Game retrieve=null;
        try {
            in = new ObjectInputStream (new FileInputStream("out.txt"));
             retrieve= (Game) in.readObject();
            //System.out.println(s1.getName());
        } finally {
            in.close();
        }
        return retrieve;
    }
}
