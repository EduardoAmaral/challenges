import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortChallengesTest {

    @Test
    @DisplayName("should use insertion algorithm to sort elements in ascending order")
    void insertionSort() {
        int[] elements = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] expectedResult = new int[]{0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283};

        final int[] sorted = new SortChallenges().insertionSort(elements);

        Assertions.assertArrayEquals(expectedResult, sorted);
    }

    @Test
    @DisplayName("should use merge sort to sort elements in ascending order")
    void mergeSort() {
        int[] elements = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] expectedResult = new int[]{0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283};

        final int[] sorted = new SortChallenges().mergeSort(elements);

        Assertions.assertArrayEquals(expectedResult, sorted);
    }
}