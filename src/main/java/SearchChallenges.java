import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SearchChallenges {

    public List<Integer> transverseWithBreadthFistSearch(BinarySearchTree tree) {
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
}
