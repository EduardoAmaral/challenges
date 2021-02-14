import lombok.AllArgsConstructor;
import lombok.Getter;

public class BinarySearchTree {

    @Getter
    private Node root;

    public void insert(int element) {
        if (root == null) {
            root = new Node(element, null, null);
            return;
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
        } else {
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

    public boolean remove(int element) {
        if (root == null) return false;

        Node current = root;
        Node parent = null;
        while (current != null) {
            if (element < current.value) {
                parent = current;
                current = current.left;
            } else if (element > current.value) {
                parent = current;
                current = current.right;
            } else {
                if (current.right == null) {
                    if (parent == null) {
                        root = current.left;
                    } else {
                        parent.left = current.left;
                    }
                } else if (current.left == null) {
                    if (parent == null) {
                        root = current.right;
                    } else {
                        parent.right = current.right;
                    }
                } else {
                    if (parent == null) {
                        current.right.left = current.left;
                        root = current.right;
                    } else {
                        Node lowest = current.right;
                        Node lowestParent = null;
                        while (lowest.left != null) {
                            lowestParent = lowest;
                            lowest = lowest.left;
                        }
                        if (lowestParent != null) lowestParent.left = lowest.right;
                        lowest.left = current.left;
                        lowest.right = current.right;
                        if (element < parent.value) {
                            parent.left = lowest;
                        } else {
                            parent.right = lowest;
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    @Getter
    @AllArgsConstructor
    public static class Node {
        private final int value;
        private Node left;
        private Node right;
    }
}
