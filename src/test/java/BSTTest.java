package keyin.org;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsert() {
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);
        bst.insert(9);
        assertTrue(bst.search(1));
        assertTrue(bst.search(2));
        assertTrue(bst.search(3));
        assertTrue(bst.search(5));
        assertTrue(bst.search(6));
        assertTrue(bst.search(8));
        assertTrue(bst.search(9));
        assertFalse(bst.search(10));
    }

    @Test
    public void testDelete() {
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);
        bst.insert(9);
        bst.deleteNode(2);
        assertFalse(bst.search(2));
        bst.deleteNode(5);
        assertFalse(bst.search(5));
        bst.deleteNode(9);
        assertFalse(bst.search(9));
        assertTrue(bst.search(1));
        assertTrue(bst.search(3));
        assertTrue(bst.search(6));
        assertTrue(bst.search(8));
    }

    @Test
    public void testFindMaxData() {
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);
        bst.insert(9);
        assertEquals(9, bst.findMaxData(bst.root));
    }

    @Test
    public void testFindMinData() {
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);
        bst.insert(9);
        assertEquals(1, bst.findMinData(bst.root));
    }

    @Test
    public void testInorder() {
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);
        bst.insert(9);
        bst.inOrder(bst.root);
    }

    @Test
    public void testJSONRepresentation() {
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        String expected = "{\n" +
                "  \"key\": 10,\n" +
                "  \"right\": {\n" +
                "    \"key\": 20,\n" +
                "    \"right\": {\n" +
                "      \"key\": 30,\n" +
                "      \"height\": 0\n" +
                "    },\n" +
                "    \"height\": 0\n" +
                "  },\n" +
                "  \"height\": 0\n" +
                "}";
        assertEquals(expected, bst.getJSONRepresentation());
    }
}
