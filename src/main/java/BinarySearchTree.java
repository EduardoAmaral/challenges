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

    @Getter
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node left;
        private Node right;
    }
}
