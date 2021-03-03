import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class SearchChallengesTest {

    @Test
    @DisplayName("given a ordered tree, should return the list of elements using BFS algorithm - level by level")
    void transverseWithBFS() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        final Integer[] expected = new Integer[]{9, 4, 20, 1, 6, 15, 170};

        final List<Integer> result = SearchChallenges.transverseWithBreadthFistSearch(tree);

        Assertions.assertArrayEquals(expected, result.toArray());
    }

    @Test
    @DisplayName("given a ordered tree, should return the list of elements using DFS in order algorithm - deepest element on left parent right")
    void transverseInOrderWithDFS() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        final Integer[] expected = new Integer[]{1, 4, 6, 9, 15, 20, 170};

        final List<Integer> result = SearchChallenges.transverseWithDepthFistSearchInOrder(tree);

        Assertions.assertArrayEquals(expected, result.toArray());
    }
}