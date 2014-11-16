
import java.util.*;

public class GenericTree<T> {

    private GenericTreeNode<T> root;

    public GenericTree() {
        super();
    }

    public GenericTreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(GenericTreeNode<T> root) {
        this.root = root;
    }

    public int getNumberOfNodes() {
        int numberOfNodes = 0;

        if(root != null) {
            numberOfNodes = auxiliaryGetNumberOfNodes(root) + 1; //1 for the root!
        }

        return numberOfNodes;
    }

    private int auxiliaryGetNumberOfNodes(GenericTreeNode<T> node) {
        int numberOfNodes = node.getNumberOfChildren();

        for(GenericTreeNode<T> child : node.getChildren()) {
            numberOfNodes += auxiliaryGetNumberOfNodes(child);
        }

        return numberOfNodes;
    }

    public boolean exists(T dataToFind) {
        return (find(dataToFind) != null);
    }

    public GenericTreeNode<T> find(T dataToFind) {
        GenericTreeNode<T> returnNode = null;

        if(root != null) {
            returnNode = auxiliaryFind(root, dataToFind);
        }

        return returnNode;
    }

    private GenericTreeNode<T> auxiliaryFind(GenericTreeNode<T> currentNode, T dataToFind) {
        GenericTreeNode<T> returnNode = null;
        int i = 0;

        if (currentNode.getData().equals(dataToFind)) {
            returnNode = currentNode;
        }

        else if(currentNode.hasChildren()) {
            i = 0;
            while(returnNode == null && i < currentNode.getNumberOfChildren()) {
                returnNode = auxiliaryFind(currentNode.getChildAt(i), dataToFind);
                i++;
            }
        }

        return returnNode;
    }
    
    public boolean buildTree (GenericTreeNode<Option> startnode,int row,int col) {
    	
        if(root != null) {
         return auxBuildTree(startnode,row,col);
        }
		return false;

     
    }
    
    private boolean auxBuildTree (GenericTreeNode<Option> currentNode, int row, int onCol) {
        int i = 0;
        if (currentNode.equals(root) && !currentNode.hasChildren()) {
        	System.out.println("Am i still in here for some reason?");
        	for (int r = row;r <= Functions.getNumofrows() - 1;r++){
    			for (int col = onCol; col <= Functions.getNumofcols() - 1;col++){
    				if (Functions.canPlaceHor (currentNode.getData().getGrid(),r,col)){
        					if (col == Functions.getNumofcols() - 1){
        						
        					}
        					else Functions.placeOption(currentNode.getData().getGrid(),r,col,r,col + 1, currentNode);
    				}
    				if (Functions.canPlaceVer (currentNode.getData().getGrid(),r,col)){
    					if (r == Functions.getNumofrows() - 1){
    						
    					}
    					else Functions.placeOption(currentNode.getData().getGrid(),r,col,r + 1,col,currentNode);
    				}
    			}
    		}
    		/*for (int j = 0;j < Functions.getTree().getRoot().getNumberOfChildren() - 1;j++){
    			int one = Functions.getTree().getRoot().getChildAt(j).getData().getRowOne();
    			int two = Functions.getTree().getRoot().getChildAt(j).getData().getRowTwo();
    			int three =  Functions.getTree().getRoot().getChildAt(j).getData().getColOne();
    			int four = Functions.getTree().getRoot().getChildAt(j).getData().getColTwo();
    			System.out.println("Row1:" + one + " Col1:" + three + "\nRow2:" + two + " Col2:" + four + "\n\n");
    		}
    		*/
    		auxBuildTree(currentNode,row,onCol);
    		return false;
    	}
         
        else if(currentNode.hasChildren()) {
            i = 0;
            System.out.println("So i am in here?");
            while(i < currentNode.getNumberOfChildren()) {
            	/*System.out.println("Grid in node: \n");
            	for(int k = 0; k < Functions.getNumofrows(); k++)
				   {
				      for(int j = 0; j < Functions.getNumofcols(); j++)
				      {
				    	  
				         System.out.printf("%5d ", currentNode.getChildAt(i).getData().getGrid()[k][j]);
				      }
				      
				      System.out.println();
				   }
				 System.out.println("\n");*/
            	for (int r = row;r <= Functions.getNumofrows() - 1;r++){
        			for (int col = onCol; col <= Functions.getNumofcols() - 1;col++){
        				if (Functions.canPlaceHor (currentNode.getChildAt(i).getData().getGrid(),r,col)){
        					if (col == Functions.getNumofcols() - 1){
        						
        					}
        					else Functions.placeOption(currentNode.getChildAt(i).getData().getGrid(),r,col,r,col + 1, currentNode);
    				}
    				if (Functions.canPlaceVer (currentNode.getChildAt(i).getData().getGrid(),r,col)){
    					if (r == Functions.getNumofrows() - 1){
    						
    					}
    					else Functions.placeOption(currentNode.getChildAt(i).getData().getGrid(),r,col,r + 1,col,currentNode);
    				}
    			}
    		}
        		i++;
        		if (i > currentNode.getNumberOfChildren())
               auxBuildTree(currentNode.getChildAt(i),row,onCol);
                
            }
        }
		return false;

       
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public List<GenericTreeNode<T>> build(GenericTreeTraversalOrderEnum traversalOrder) {
        List<GenericTreeNode<T>> returnList = null;

        if(root != null) {
            returnList = build(root, traversalOrder);
        }

        return returnList;
    }

    public List<GenericTreeNode<T>> build(GenericTreeNode<T> node, GenericTreeTraversalOrderEnum traversalOrder) {
        List<GenericTreeNode<T>> traversalResult = new ArrayList<GenericTreeNode<T>>();

        if(traversalOrder == GenericTreeTraversalOrderEnum.PRE_ORDER) {
            buildPreOrder(node, traversalResult);
        }

        else if(traversalOrder == GenericTreeTraversalOrderEnum.POST_ORDER) {
            buildPostOrder(node, traversalResult);
        }

        return traversalResult;
    }

    private void buildPreOrder(GenericTreeNode<T> node, List<GenericTreeNode<T>> traversalResult) {
        traversalResult.add(node);

        for(GenericTreeNode<T> child : node.getChildren()) {
            buildPreOrder(child, traversalResult);
        }
    }

    private void buildPostOrder(GenericTreeNode<T> node, List<GenericTreeNode<T>> traversalResult) {
        for(GenericTreeNode<T> child : node.getChildren()) {
            buildPostOrder(child, traversalResult);
        }

        traversalResult.add(node);
    }

    public Map<GenericTreeNode<T>, Integer> buildWithDepth(GenericTreeTraversalOrderEnum traversalOrder) {
        Map<GenericTreeNode<T>, Integer> returnMap = null;

        if(root != null) {
            returnMap = buildWithDepth(root, traversalOrder);
        }

        return returnMap;
    }

    public Map<GenericTreeNode<T>, Integer> buildWithDepth(GenericTreeNode<T> node, GenericTreeTraversalOrderEnum traversalOrder) {
        Map<GenericTreeNode<T>, Integer> traversalResult = new LinkedHashMap<GenericTreeNode<T>, Integer>();

        if(traversalOrder == GenericTreeTraversalOrderEnum.PRE_ORDER) {
            buildPreOrderWithDepth(node, traversalResult, 0);
        }

        else if(traversalOrder == GenericTreeTraversalOrderEnum.POST_ORDER) {
            buildPostOrderWithDepth(node, traversalResult, 0);
        }

        return traversalResult;
    }

    private void buildPreOrderWithDepth(GenericTreeNode<T> node, Map<GenericTreeNode<T>, Integer> traversalResult, int depth) {
        traversalResult.put(node, depth);

        for(GenericTreeNode<T> child : node.getChildren()) {
            buildPreOrderWithDepth(child, traversalResult, depth + 1);
        }
    }

    private void buildPostOrderWithDepth(GenericTreeNode<T> node, Map<GenericTreeNode<T>, Integer> traversalResult, int depth) {
        for(GenericTreeNode<T> child : node.getChildren()) {
            buildPostOrderWithDepth(child, traversalResult, depth + 1);
        }

        traversalResult.put(node, depth);
    }

    public String toString() {
        /*
        We're going to assume a pre-order traversal by default
         */

        String stringRepresentation = "";

        if(root != null) {
            stringRepresentation = build(GenericTreeTraversalOrderEnum.PRE_ORDER).toString();

        }

        return stringRepresentation;
    }

    public String toStringWithDepth() {
        /*
        We're going to assume a pre-order traversal by default
         */

        String stringRepresentation = "";

        if(root != null) {
            stringRepresentation = buildWithDepth(GenericTreeTraversalOrderEnum.PRE_ORDER).toString();
        }

        return stringRepresentation;
    }
}
