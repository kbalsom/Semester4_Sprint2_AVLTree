package keyin.org;

//Imports Gson:
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Creates public class BST:
public class BST {

    //Sets up variable:
    public static Node root;

    //BST Constructor:
    public BST() {
        this.root = null;
    }

    //insert Method:
    public void insert(int key){
        this.root = insert(root, key);
    }

    //insert Method:
    private Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    //getHeight Method:
    public int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //deleteNode Method:
    public void deleteNode(int key) {
        deleteNode(this.root, key);
    }

    //deleteNode Method:
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node temp = findMinNode(root.right);
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }
        return root;
    }

    //findMinNode Method:
    public Node findMinNode(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return findMinNode(root.left);
        }
    }

    //findMaxData Method:
    public int findMaxData(Node root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.key;
        }
    }

    //findMinData Method:
    public int findMinData(Node root) {
        if (root.left != null) {
            return findMinData(root.left);
        } else {
            return root.key;
        }
    }

    //inOrder Method:
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println("Node " + root.key + " has height " + getHeight(root));
        inOrder(root.right);
    }

    //preOrder void Method:
    public void preOrder() {
        preOrder(root);
    }

    //preOrder Method:
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    //search Method:
    public boolean search(int value) {
        return search(this.root, value);
    }

    //search Method:
    private boolean search(Node root, int value) {
        if (root == null) {
            return false;
        } else if (root.key == value) {
            return true;
        } else if (root.key > value) {
            return search(root.left, value);
        }
        return search(root.right, value);
    }


    //getJSONRepresentation Method:
    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }
}
