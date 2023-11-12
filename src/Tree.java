import java.util.*;
public class Tree {
    private Node root;

    //default constructor
    public Tree(){
        root = null;
    }
    //1 argument constructor
    public Tree(Node root){
        this.root = root;
    }
    //leftMostHeight is the left most node's height; we use this height to compare against all other leaves
    //then, we do pre-order traversal of the tree, comparing leftMostHeight to all leaves
    //whenever we encounter a leaf which has more than 1 level difference from leftMostHeight, we return false
    public boolean balanced(){
        int leftMostHeight = getLeftMost(root);
        return balancedHelper(root, leftMostHeight, 1);
    }

    private boolean balancedHelper(Node current, int leftMostHeight, int height) {
        boolean balanced = true;
        if(current.isLeaf()){
            if(!(leftMostHeight - height == 0 || leftMostHeight - height == -1 || leftMostHeight - height == 1)){
                return false;
            }
        }
        if(current.hasLeftChild()) {
            balanced = balancedHelper(current.getLeft(), leftMostHeight, height + 1);
        }
        if(current.hasRightChild()){
            balanced = balancedHelper(current.getRight(), leftMostHeight, height + 1);
        }
        return balanced;
    }

    private int getLeftMost(Node current) {
        if (current.isLeaf()) {
            return 1;
        } else if (!current.hasLeftChild()) {
            return 1 + getLeftMost(current.getRight());
        } else {
            return 1 + getLeftMost(current.getLeft());
        }
    }
    //initializes minimum Node to null; then calls findRightMost
    public Node floor(int x){
        Node minimum = null;
        return findRightMost(root, x, minimum);
    }
    //recursively does in-order traversal while comparing all node's keys to x
    //updates minimum Node if it finds a righter node than previous
    private Node findRightMost(Node current, int x, Node minimum) {
        if (current.hasLeftChild()) {
            minimum = findRightMost(current.getLeft(), x, minimum);
        }
        if (current.getKey() <= x) {
            minimum = current;
        }
        if (current.hasRightChild()){
            minimum = findRightMost(current.getRight(), x, minimum);
        }
        return minimum;
    }
    //creates a linked list and calls the helper method
    public List keysAtDepth(int d){
        List<Integer> list = new LinkedList<>();
        keysAtDepthHelper(root, d, list);
        return list;
    }
    //does a minimized in-order traversal while appending the nodes at depth xyz to the linked list
    //does not change the original tree
    private void keysAtDepthHelper(Node current, int d, List list) {
        if (d == 1) {
            list.add(current);
        } else {
            if (current.hasLeftChild()) {
                keysAtDepthHelper(current.getLeft(), d - 1, list);
            }
            if (current.hasRightChild()) {
                keysAtDepthHelper(current.getRight(), d - 1, list);
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
