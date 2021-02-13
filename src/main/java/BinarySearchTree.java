import lombok.AllArgsConstructor;
import lombok.Getter;

public class BinarySearchTree {

    @Getter
    private Node root;

    public void insert(int element) {
        if (root == null) {
            root = new Node(element, null, null);
        }

        insert(root, element);
    }

    private void insert(Node node, int element) {
        if (element < node.value) {
            if (node.getLeft() != null) {
                insert(node.left, element);
            } else {
                node.left = new Node(element, null, null);
            }
        }

        if (element > node.value) {
            if (node.getRight() != null) {
                insert(node.right, element);
            } else {
                node.right = new Node(element, null, null);
            }
        }
    }

    public Node lookup(int element) {
        if (root == null) {
            return null;
        }

        return lookup(root, element);
    }

    private Node lookup(Node node, int element) {
        if (node == null) return null;

        if (element < node.value) {
            return lookup(node.left, element);
        } else if (element > node.value) {
            return lookup(node.right, element);
        }

        return node;
    }

    @Getter
    @AllArgsConstructor
    public static class Node {
        private final int value;
        private Node left;
        private Node right;
    }
}
