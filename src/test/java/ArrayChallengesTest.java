import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayChallengesTest {

    @Test
    @DisplayName("find the index of the pair where its sum is equal to the target")
    void twoSum() {
        final int[] numbers = {2, 7, 11, 15};
        final int target = 9;

        Assertions.assertArrayEquals(ArrayChallenges.twoSum(numbers, target), new int[]{0, 1});
    }

    @Test
    @DisplayName("should return empty array when none of the pairs sum matches the target")
    void twoSum_whenNoPairMatches() {
        final int[] numbers = {2, 7, 11, 15};
        final int target = 16;

        Assertions.assertArrayEquals(ArrayChallenges.twoSum(numbers, target), new int[0]);
    }

    @Test
    @DisplayName("should move zeros to the end of the array keeping the natural order")
    void moveZeros() {
        final int[] numbers = {1, 0, 6, 0, 3, 5, 12};

        Assertions.assertArrayEquals(ArrayChallenges.moveZeros(numbers), new int[]{1, 6, 3, 5, 12, 0, 0});
    }

    @Test
    @DisplayName("should keep natural order if no zeros are found")
    void moveZeros_whenNoZerosAreFound() {
        final int[] numbers = {1, 6, 12};

        Assertions.assertArrayEquals(ArrayChallenges.moveZeros(numbers), new int[]{1, 6, 12});
    }

    @Test
    @DisplayName("should return true when there are duplicated values within the array")
    void containsDuplicate() {
        final int[] numbers = {1, 0, 6, 0, 3, 5, 12};

        Assertions.assertTrue(ArrayChallenges.containsDuplicate(numbers));
    }

    @Test
    @DisplayName("should return false when there are no duplicated values within the array")
    void containsDuplicate_falseScenario() {
        final int[] numbers = {1, 6, 3, 5, 12};

        Assertions.assertFalse(ArrayChallenges.containsDuplicate(numbers));
    }

    @Test
    @DisplayName("should rotate elements of an array to the right x times based on a given parameter")
    void rotateArray() {
        final int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        final int stepsToRotate = 3;

        Assertions.assertArrayEquals(ArrayChallenges.rotateArray(numbers, stepsToRotate), new int[]{5, 6, 7, 1, 2, 3, 4});
    }
}