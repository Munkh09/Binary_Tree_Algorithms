
public class Main {
    public static void main(String[] args) {
        //building an array of size 10
        int[] A = new int[10];
        A[0] = 12;
        A[1] = 5;
        A[2] = 9;
        A[3] = 19;
        A[4] = 10;
        A[5] = 6;
        A[6] = 1;
        A[7] = 3;
        A[8] = 16;
        A[9] = 11;

        //building a tree
        Tree tree1 = new Tree(new Node(1));
        tree1.getRoot().setLeft(new Node(19));
        tree1.getRoot().setRight(new Node(16));
        tree1.getRoot().getLeft().setLeft(new Node(5));
        tree1.getRoot().getLeft().setRight(new Node(6));
        tree1.getRoot().getLeft().getLeft().setLeft(new Node(12));
        tree1.getRoot().getLeft().getLeft().setRight(new Node(9));
        tree1.getRoot().getLeft().getRight().setLeft(new Node(10));
        tree1.getRoot().getRight().setLeft(new Node(3));
        tree1.getRoot().getRight().setRight(new Node(11));

        //testing question 1; Is the tree above balanced?
        System.out.println("Is the tree balanced?");
        System.out.println(tree1.balanced());

        //testing question 2; What is the right most node containing a value lesser than or equal to the input?
        System.out.println("What is the right most node containing a value lesser than or equal to the input?");
        System.out.println((tree1.floor(5).getKey()));
        System.out.println((tree1.floor(11).getKey()));
        System.out.println((tree1.floor(19).getKey()));
        System.out.println((tree1.floor(12).getKey()));

        //testing question 3; What are the nodes (from left to right) at depth xyz?
        System.out.println("What are the nodes from left to right at input depth?");
        System.out.println((tree1.keysAtDepth(3)).toString());
        System.out.println((tree1.keysAtDepth(2)).toString());
        System.out.println((tree1.keysAtDepth(4)).toString());
        System.out.println((tree1.keysAtDepth(1)).toString());

    }




}