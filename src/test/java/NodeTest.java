package keyin.org;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    private Node node;

    @Before
    public void setUp() throws Exception {
        node = new Node(10);
    }

    @Test
    public void testConstructorWithChildren() {
        Node left = new Node(5);
        Node right = new Node(15);
        node = new Node(10, left, right);
        assertEquals(left, node.getLeft());
        assertEquals(right, node.getRight());
        assertEquals(0, node.getHeight());
    }
}
