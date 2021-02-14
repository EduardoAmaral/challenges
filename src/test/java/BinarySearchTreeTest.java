import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("should return false when tree is empty")
    void remove_withEmptyTree() {
        final BinarySearchTree tree = new BinarySearchTree();
        assertFalse(tree.remove(1));
    }

    @Test
    @DisplayName("should return false if elements does not belong to the tree")
    void remove_whenElementIsNotFound() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        assertFalse(tree.remove(1));
    }

    @Test
    @DisplayName("should clean up tree if the only element is the root")
    void remove_onlyElement() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        assertTrue(tree.remove(1));
        assertNull(tree.getRoot());
    }

    @Test
    @DisplayName("remove should shift the left child to be the root when root has only children on the left")
    void remove_whenRootHasOnlyLeftChildren() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);

        assertTrue(tree.remove(5));
        assertEquals(3, tree.getRoot().getValue());
    }

    @Test
    @DisplayName("remove should shift the right child to be the root when root has only children on the right")
    void remove_rootThatHasOnlyRightChildren() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(8);

        assertTrue(tree.remove(5));
        assertEquals(8, tree.getRoot().getValue());
    }

    @Test
    @DisplayName("remove should promote the right child to be the root when deleting root with children on both side")
    void remove_rootWithChildren() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(4);

        assertTrue(tree.remove(5));
        assertEquals(8, tree.getRoot().getValue());
    }

    @Test
    @DisplayName("remove should promote the left child to parent when the deleted element has only left children")
    void remove_withOnlyLeftChildren() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);

        assertEquals(3, tree.getRoot().getLeft().getValue());
        assertTrue(tree.remove(3));
        assertEquals(1, tree.getRoot().getLeft().getValue());
    }

    @Test
    @DisplayName("remove should promote the right child to parent when the deleted element has only right children")
    void remove_withOnlyRightChildren() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(9);
        assertEquals(8, tree.getRoot().getRight().getValue());
        assertTrue(tree.remove(8));
        assertEquals(9, tree.getRoot().getRight().getValue());
    }

    @Test
    @DisplayName("should promote the lowest element (on the left edge) from the right side of the deleted node when it has right and left children - left side")
    void remove_withChildrenOnLeft() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(45);
        tree.insert(30);
        tree.insert(25);
        tree.insert(32);
        tree.insert(33);

        assertEquals(30, tree.getRoot().getLeft().getValue());
        assertTrue(tree.remove(30));
        assertEquals(32, tree.getRoot().getLeft().getValue());
    }

    @Test
    @DisplayName("should promote the lowest element (on the left edge) from the right side of the deleted node when it has right and left children - right side")
    void remove_withChildrenOnRight() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(45);
        tree.insert(55);
        tree.insert(50);
        tree.insert(70);
        tree.insert(60);
        tree.insert(75);

        assertEquals(55, tree.getRoot().getRight().getValue());
        assertTrue(tree.remove(55));
        assertEquals(60, tree.getRoot().getRight().getValue());
    }
}