
import java.util.ArrayList;

public class Node {

    private Option identifier;
    private ArrayList<Option> children;

    // Constructor
    public Node(Option identifier) {
        this.identifier = identifier;
        children = new ArrayList<Option>();
    }

    // Properties
    public Option getIdentifier() {
        return identifier;
    }

    public ArrayList<Option> getChildren() {
        return children;
    }

    // Public interface
    public void addChild(Option identifier) {
        children.add(identifier);
    }
}
