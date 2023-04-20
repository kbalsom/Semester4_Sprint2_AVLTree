package keyin.org;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

public class BST {

    public static Node root;

    public BST() {
        this.root = null;
    }

    //Is this needed??
    public void insert(int key){
        this.root = insert(root, key);
    }

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

    public int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void deleteNode(int key) {
        deleteNode(this.root, key);
    }

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

    public Node findMinNode(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return findMinNode(root.left);
        }
    }


    public int findMaxData(Node root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.key;
        }
    }

    public int findMinData(Node root) {
        if (root.left != null) {
            return findMinData(root.left);
        } else {
            return root.key;
        }
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println("Node " + root.key + " has height " + getHeight(root));
        inorder(root.right);
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public boolean search(int value) {
        return search(this.root, value);
    }

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


    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }
}
