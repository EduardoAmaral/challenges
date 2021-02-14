import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchTreeTest {

    @Test
    @DisplayName("should insert the element on root when no root exists")
    void insert() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        assertEquals(10, tree.getRoot().getValue());
    }

    @Test
    @DisplayName("should add duplicated notes on the right")
    void insertDuplicatedNodes() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(10);
        assertEquals(10, tree.getRoot().getValue());
        assertEquals(10, tree.getRoot().getRight().getValue());
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

    @Test
    @DisplayName("should include element on the root -> left -> right when element is lower than root but greater than the root left leaf")
    void insertOnLeftRight() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(3);
        tree.insert(5);
        assertEquals(5, tree.getRoot().getLeft().getRight().getValue());
    }

    @Test
    @DisplayName("should include element on the root -> right -> left when element is greater than root but lower than the root right leaf")
    void insertOnRightLeft() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(13);
        assertEquals(13, tree.getRoot().getRight().getLeft().getValue());
    }

    @Test
    @DisplayName("should return the element if it is the root of the tree")
    void lookup() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        assertEquals(10, tree.lookup(10).getValue());
    }

    @Test
    @DisplayName("should return null if the tree has no elements")
    void lookup_noElements() {
        final BinarySearchTree tree = new BinarySearchTree();
        assertNull(tree.lookup(100));
    }

    @Test
    @DisplayName("should return null if the element was not found")
    void lookup_notFound() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(101);
        assertNull(tree.lookup(100));
    }

    @Test
    @DisplayName("should return the element if it is a left node on the tree")
    void lookup_left() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        assertEquals(5, tree.lookup(5).getValue());
        assertEquals(1, tree.lookup(1).getValue());
    }

    @Test
    @DisplayName("should return the element if it is a right node on the tree")
    void lookup_right() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(13);
        tree.insert(12);
        tree.insert(7);
        tree.insert(6);
        tree.insert(1);
        assertEquals(6, tree.lookup(6).getValue());
        assertEquals(13, tree.lookup(13).getValue());
    }
}