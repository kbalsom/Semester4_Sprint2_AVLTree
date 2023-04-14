package keyin.org;

public class Node {
    int key;
    Node left;
    Node right;
    int height;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
