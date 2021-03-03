import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SearchChallenges {

    public static List<Integer> transverseWithBreadthFistSearch(BinarySearchTree tree) {
        List<Integer> result = new ArrayList<>();
        Queue<BinarySearchTree.Node> queue = new ArrayDeque<>();
        queue.add(tree.getRoot());

        while (!queue.isEmpty()) {
            final BinarySearchTree.Node currentNode = queue.poll();
            result.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        return result;
    }

    public static List<Integer> transverseWithDepthFistSearchInOrder(BinarySearchTree tree) {
        return transverseInOrder(tree.getRoot(), new ArrayList<>());
    }

    private static List<Integer> transverseInOrder(BinarySearchTree.Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            transverseInOrder(node.getLeft(), list);
        }

        list.add(node.getValue());

        if (node.getRight() != null) {
            transverseInOrder(node.getRight(), list);
        }

        return list;
    }

    private static List<Integer> transversePreOrder(BinarySearchTree.Node node, List<Integer> list) {
        list.add(node.getValue());
        if (node.getLeft() != null) transversePreOrder(node.getLeft(), list);
        if (node.getRight() != null) transversePreOrder(node.getRight(), list);
        return list;
    }

    public static List<Integer> transverseWithDepthFistSearchPreOrder(BinarySearchTree tree) {
        return transversePreOrder(tree.getRoot(), new ArrayList<>());
    }

}
