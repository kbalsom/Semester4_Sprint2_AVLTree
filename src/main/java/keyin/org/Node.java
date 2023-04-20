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

    public Node(int key, Node left, Node right, Node parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public Node(int i, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}