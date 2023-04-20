package keyin.org;

//Creates public class Node:
public class Node {

    //Sets up variables:
    int key;
    Node left;
    Node right;
    int height;

    //Node constructor:
    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    //Node constructor:
    public Node(int key, Node left, Node right, Node parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    //Node constructor:
    public Node(int i, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    //getKey Method:
    public int getKey() {
        return key;
    }

    //setKey Method:
    public void setKey(int key) {
        this.key = key;
    }

    //getLeft Method:
    public Node getLeft() {
        return left;
    }

    //setLeft Method:
    public void setLeft(Node left) {
        this.left = left;
    }

    //getRight Method:
    public Node getRight() {
        return right;
    }

    //setRight Method:
    public void setRight(Node right) {
        this.right = right;
    }

    //getHeight Method:
    public int getHeight() {
        return height;
    }

    //setHeight Method:
    public void setHeight(int height) {
        this.height = height;
    }
}