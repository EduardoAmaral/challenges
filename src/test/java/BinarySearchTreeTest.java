import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    @DisplayName("should insert the element on root when no root exists")
    void insert() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        assertEquals(10, tree.getRoot().getValue());
    }

    @Test
    @DisplayName("should insert on left if the element is lower than the root value")
    void insertToLeft() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(1);
        assertEquals(1, tree.getRoot().getLeft().getValue());
    }

    @Test
    @DisplayName("should insert on right if the element is greater than the root value")
    void insertToRight() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(13);
        assertEquals(13, tree.getRoot().getRight().getValue());
    }

    @Test
    @DisplayName("should insert element on the left edge if it is lower than all nodes")
    void insertToLeftEdge() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);
        assertEquals(1, tree.getRoot().getLeft().getLeft().getValue());
    }

    @Test
    @DisplayName("should insert element on the right edge if it is greater than all nodes")
    void insertToRightEdge() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(24);
        assertEquals(24, tree.getRoot().getRight().getRight().getValue());
    }
}