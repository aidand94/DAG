import java.util.HashSet;

public class Node{
    private int value;
    private HashSet<Edge> inEdges;
    private HashSet<Edge> outEdges;

    public Node(int value) {
        this.value = value;
        inEdges = new HashSet<Edge>();
        outEdges = new HashSet<Edge>();
    }

    public HashSet<Edge> getInEdges() {
        return inEdges;
    }

    public HashSet<Edge> getOutEdges() {
        return outEdges;
    }

    public int getValue() {
        return this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setInEdges(HashSet<Edge> inEdges) {
        this.inEdges = inEdges;
    }

    public void setOutEdges(HashSet<Edge> outEdges) {
        this.outEdges = outEdges;
    }

    public Node addEdge(Node node){
        Edge e = new Edge(this, node);
        outEdges.add(e);
        node.inEdges.add(e);

        return this;
    }
}
