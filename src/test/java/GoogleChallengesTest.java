import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GoogleChallengesTest {

    private final GoogleChallenges challenge = new GoogleChallenges();


    @Test
    @DisplayName("should the first pair of elements that matches sum")
    void findPairThatMatchesSumInSortedList() {
        final int[] secondArray = new int[]{1, 2, 4, 4};
        final int sum = 8;


        Assertions.assertArrayEquals(challenge.findPairThatMatchesSumInSortedCollection(secondArray, sum), new int[]{4, 4});
    }

    @Test
    @DisplayName("should return an empty array if no pair of elements matches sum")
    void findPairInSortedList() {
        final int[] array = new int[]{1, 2, 3, 9};
        final int sum = 8;

        Assertions.assertArrayEquals(challenge.findPairThatMatchesSumInSortedCollection(array, sum), new int[0]);
    }

    @Test
    @DisplayName("should return true if a pair of elements matches sum")
    void isTherePairThatMatchesSum() {
        final int[] array = new int[]{1, 7, 4, 2, 6};
        final int sum = 9;

        Assertions.assertTrue(challenge.isTherePairThatMatchesSum(array, sum));
    }

    @Test
    @DisplayName("should return false if no pair matches sum")
    void doesNotFindAnyPairThatMatchesSum() {
        final int[] array = new int[]{9, 1, 3, 2};
        final int sum = 9;

        Assertions.assertFalse(challenge.isTherePairThatMatchesSum(array, sum));
    }
}