import java.util.ArrayList;

public class DAG {

    public static boolean isDag(ArrayList<Node> nodes) {

       return true;
    }

    public static void main(String[] args) {

        ArrayList<Node> nodes = new ArrayList<>();
        System.out.println(isDag(nodes));
    }
}