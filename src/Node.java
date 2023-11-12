
public class Node{
    private int key;
    private Node left, right, parent;
    public Node(){
        this(-1, null, null, null);
    }

    //4 argument constructor
    public Node(int key, Node left, Node right, Node parent){
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    //1 argument constructor
    public Node(int key){
        this(key, null, null, null);
    }

    //helper methods for determining children
    public boolean hasLeftChild(){
        return this.left != null;
    }
    public boolean hasRightChild(){
        return this.right != null;
    }
    //helper method for determining if a node is a leaf or not
    public boolean isLeaf(){
        return !hasLeftChild() && !hasRightChild();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) { this.key = key; }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString(){
        return String.valueOf(getKey());
    }
}