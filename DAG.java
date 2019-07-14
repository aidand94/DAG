import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DAG {

    public static boolean isDag(ArrayList<Node> nodes) {
        // sortedNodes ← Empty list that will contain the sorted elements
        ArrayList<Node> sortedNodes = new ArrayList<Node>();

        // noIncEdges ← Set of all nodes with no incoming edge
        HashSet<Node> noIncEdges = new HashSet<Node>();

        // Add all the nodes with no incoming edges to set
        for(Node n : nodes){
            if(n.getInEdges().size() == 0){
                noIncEdges.add(n);
            }
        }

        // while noIncEdges is non-empty do
        while(!noIncEdges.isEmpty()){
            // remove a node n from noIncEdges
            Node n = noIncEdges.iterator().next();
            noIncEdges.remove(n);

            // insert n into sortedNodes
            sortedNodes.add(n);

            // for each node m with an edge e from n to m do
            Iterator<Edge> it = n.getOutEdges().iterator();
            while(it.hasNext()){
                // remove edge e from the graph
                Edge e = it.next();
                Node m = e.getTo();
                it.remove();// Remove edge from n
                m.getInEdges().remove(e);// Remove edge from m

                // if m has no other incoming edges then insert m into sortedNodes
                if(m.getInEdges().isEmpty()){
                    noIncEdges.add(m);
                }
            }
        }

        // Check to see if all edges are removed
        for(Node n : nodes){
            if(!n.getInEdges().isEmpty()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Node> nodes1 = new ArrayList<>();
        ArrayList<Node> nodes2 = new ArrayList<>();

        for(int i = 1; i<6; i++){
            nodes1.add(new Node(i));
            nodes2.add(new Node(i));
        }

        // Nodes1: {1,2},{1,3},{1,4},{3,4},{3,5},{5,1}
        // Nodes2: {1,2},{1,3},{1,4},{3,4},{3,5}

        nodes1.get(0).addEdge(nodes1.get(1));
        nodes2.get(0).addEdge(nodes2.get(1));
        nodes1.get(0).addEdge(nodes1.get(2));
        nodes2.get(0).addEdge(nodes2.get(2));
        nodes1.get(0).addEdge(nodes1.get(3));
        nodes2.get(0).addEdge(nodes2.get(3));
        nodes1.get(2).addEdge(nodes1.get(3));
        nodes2.get(2).addEdge(nodes2.get(3));
        nodes1.get(2).addEdge(nodes1.get(4));
        nodes2.get(2).addEdge(nodes2.get(4));
        nodes1.get(4).addEdge(nodes1.get(0));

        System.out.println(isDag(nodes1));
        System.out.println(isDag(nodes2));

    }
}