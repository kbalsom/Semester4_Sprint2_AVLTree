package keyin.org;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class AVL extends BST {


    private final int UNBALANCED_RIGHT = -2;
    private final int SLIGHTLY_UNBALANCED_RIGHT = -1;
    private final int UNBALANCED_LEFT = 2;
    private final int SLIGHTLY_UNBALANCED_LEFT = 1;
    private final int BALANCED = 0;

    public AVL(){
        super();
    }

    int getNodeHeight(Node node){
        if(node == null){
            return -1;
        }
        return Math.max(this.getNodeHeight(node.left), this.getNodeHeight(node.right)) +
                1;
    }

    public Node getNode(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.getKey()) {
                return current;
            } else if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    Node rotateLeftLeft(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    Node rotateRightRight(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    Node rotateLeftRight(Node node){
        node.left = this.rotateRightRight(node.left);
        return this.rotateLeftLeft(node);
    }

    private Node rotateRightLeft(Node node){
        node.right = this.rotateLeftLeft(node.right);
        return this.rotateRightRight(node);
    }

    @Override
    public void insert(int key){
        this.root = insertNodeAvl(root,key);
        System.out.println("Inserted element: " + key);
        }

    public Node insertNodeAvl(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insertNodeAvl(node.left, key);
        } else if (key > node.key) {
            node.right = insertNodeAvl(node.right, key);
        } else {
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Check if node is balanced
        int balanceFactor = getBalanceFactor(node);

        // Perform necessary rotations to balance tree
        if (balanceFactor > 1 && key < node.left.key) {
            return rotateRight(node);
        }
        if (balanceFactor < -1 && key > node.right.key) {
            return rotateLeft(node);
        }
        if (balanceFactor > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balanceFactor < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        // Return balanced node
        return node;
    }


    int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        Node rightOfLeft = left.right;

        // Perform rotation
        left.right = node;
        node.left = rightOfLeft;

        // Update heights
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;

        // Return new root
        return left;
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        Node leftOfRight = right.left;

        // Perform rotation
        right.left = node;
        node.right = leftOfRight;

        // Update heights
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;

        // Return new root
        return right;
    }


    public Node removeNodeAVL(Node root, int key){
        root = super.deleteNode(root,key);
        if (root == null){
            return null;
        }
        int balanceFactor = this.getBalanceFactor(root);
        if(balanceFactor == UNBALANCED_LEFT){
            int balanceFactorLeft = getBalanceFactor(root.left);
            if(balanceFactorLeft >= SLIGHTLY_UNBALANCED_LEFT || balanceFactorLeft == BALANCED){
                return this.rotateLeftLeft(root);
            }
            if(balanceFactorLeft == SLIGHTLY_UNBALANCED_RIGHT){
                return this.rotateLeftRight(root.left);
            }
        }
        if(balanceFactor == UNBALANCED_RIGHT){
            int balanceFactorRight = getBalanceFactor(root.right);
            if(balanceFactorRight <= SLIGHTLY_UNBALANCED_RIGHT || balanceFactorRight == BALANCED){
                return this.rotateRightRight(root);
            }
            if(balanceFactorRight == SLIGHTLY_UNBALANCED_LEFT){
                return this.rotateRightLeft(root.right);
            }
        }
        return root;
    }

    public Node getRoot() {
        return root;
    }

    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }

}


