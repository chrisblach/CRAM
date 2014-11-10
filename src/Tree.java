
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Tree {

    private final static int ROOT = 0;

    private HashMap<Option, Node> nodes;
    private TraversalStrategy traversalStrategy;
    public static Option option = new Option(null,3,2,1,0);

    // Constructors
    public Tree() {
        this(TraversalStrategy.DEPTH_FIRST);
    }

    public Tree(TraversalStrategy traversalStrategy) {
        this.nodes = new HashMap<Option, Node>();
        this.traversalStrategy = traversalStrategy;
    }

    // Properties
    public HashMap<Option, Node> getNodes() {
        return nodes;
    }

    public TraversalStrategy getTraversalStrategy() {
        return traversalStrategy;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {
        this.traversalStrategy = traversalStrategy;
    }

    // Public interface
    public Node addNode(Option identifier) {
        return this.addNode(identifier, null);
    }

    public Node addNode(Option identifier, Option parent) {
        Node node = new Node(identifier);
        nodes.put(identifier, node);

        if (parent != null) {
            nodes.get(parent).addChild(identifier);
        }

        return node;
    }

    public void display(Option identifier) {
        this.display(identifier, ROOT);
    }

    public void display(Option identifier, int depth) {
        ArrayList<Option> children = nodes.get(identifier).getChildren();

        if (depth == ROOT) {
            option = nodes.get(identifier).getIdentifier();
        } else {
            String tabs = String.format("%0" + depth + "d", 0).replace("0", "    "); // Four spaces
            System.out.println(tabs + nodes.get(identifier).getIdentifier());
        }
        depth++;
        for (Option child : children) {

            // Recursive call
            this.display(child, depth);
        }
    }

   /* public Iterator<Node> iterator(String identifier) {
        return this.iterator(identifier, traversalStrategy);
    }

    public Iterator<Node> iterator(String identifier, TraversalStrategy traversalStrategy) {
        return traversalStrategy == TraversalStrategy.BREADTH_FIRST ?
                new BreadthFirstTreeIterator(nodes, identifier) :
                new DepthFirstTreeIterator(nodes, identifier);
    }*/
}
