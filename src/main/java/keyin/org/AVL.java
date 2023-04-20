package keyin.org;

//Imports Gson:
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Creates public class AVL, extends BST class
public class AVL extends BST {

    //Sets up variables:
    private final int UNBALANCED_RIGHT = -2;
    private final int SLIGHTLY_UNBALANCED_RIGHT = -1;
    private final int UNBALANCED_LEFT = 2;
    private final int SLIGHTLY_UNBALANCED_LEFT = 1;
    private final int BALANCED = 0;

    //Public constructor AVL, which uses super to send variables to BST class:
    public AVL(){
        super();
    }

    //getNodeHeight method:
    int getNodeHeight(Node node){
        if(node == null){
            return -1;
        }
        return Math.max(this.getNodeHeight(node.left), this.getNodeHeight(node.right)) +
                1;
    }

    //getNode Method:
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

    //rotateLeftLeft Method
    public Node rotateLeftLeft(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    //rotateRightRight Method:
    public Node rotateRightRight(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    //rotateLeftRight Method:
    public Node rotateLeftRight(Node node){
        node.left = this.rotateRightRight(node.left);
        return this.rotateLeftLeft(node);
    }

    //rotateRightLeft Method:
    public Node rotateRightLeft(Node node){
        node.right = this.rotateLeftLeft(node.right);
        return this.rotateRightRight(node);
    }

    //insert Method:
    @Override
    public void insert(int key){
        this.root = insertNodeAvl(root,key);
        System.out.println("Inserted element: " + key);
        }

        //insertNodeAvl Method
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

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

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
        return node;
    }


    //getBalanceFactor Method:
    int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //rotateRight Method
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

    //rotateLeft Method:
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

    //removeNodeAVL Method:
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

    //getRoot Method:
    public Node getRoot() {
        return root;
    }

    //getJSONRepresentation Method:
    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }

}


