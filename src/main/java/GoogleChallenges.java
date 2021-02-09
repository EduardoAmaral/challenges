import java.util.HashSet;
import java.util.Set;

public class GoogleChallenges {

    public int[] findPairThatMatchesSumInSortedCollection(int[] array, int sum) {
        int lowIndex = 0;
        int highIndex = array.length - 1;

        while (lowIndex < highIndex) {
            final int s = array[lowIndex] + array[highIndex];
            if (s > sum) {
                highIndex--;
                continue;
            }

            if (s < sum) {
                lowIndex++;
                continue;
            }

            return new int[]{array[lowIndex], array[highIndex]};
        }

        return new int[0];
    }

    public boolean isTherePairThatMatchesSum(int[] array, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int num : array) {
            if (complements.contains(num)) return true;
            complements.add(sum - num);
        }

        return false;
    }
}
