package keyin.org;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTest {

    private AVL avl;

    @Before
    public void setUp() {
        avl = new AVL();
    }

    private String inorderTraversal(Node node) {
        if (node == null) {
            return "";
        }
        return inorderTraversal(node.left) + node.key + " " + inorderTraversal(node.right);
    }

    @Test
    public void testInsert() {
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        assertEquals("10 20 30 ", inorderTraversal(avl.getRoot()));
    }

    @Test
    public void testRemove() {
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.removeNodeAVL(avl.getRoot(), 10);
        assertEquals("20 30 ", inorderTraversal(avl.getRoot()));
    }

        // Test getNodeHeight()
    @Test
    public void testGetNodeHeight() {
        AVL avl = new AVL();
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);

        // Build tree
        root.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;

        assertEquals(4, avl.getNodeHeight(root));
        assertEquals(3, avl.getNodeHeight(node1));
        assertEquals(2, avl.getNodeHeight(node2));
        assertEquals(1, avl.getNodeHeight(node3));
        assertEquals(0, avl.getNodeHeight(node4));
        assertEquals(-1, avl.getNodeHeight(null));
    }

    @Test
    public void testJSONRepresentation() {
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        String expected = "{\n" +
                "  \"key\": 20,\n" +
                "  \"left\": {\n" +
                "    \"key\": 10,\n" +
                "    \"height\": 0\n" +
                "  },\n" +
                "  \"right\": {\n" +
                "    \"key\": 30,\n" +
                "    \"height\": 0\n" +
                "  },\n" +
                "  \"height\": 1\n" +
                "}";
        assertEquals(expected, avl.getJSONRepresentation());
    }
}

















