import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayChallenges {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indexByComplement = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (indexByComplement.containsKey(num)) {
                return new int[]{indexByComplement.get(num), i};
            }

            indexByComplement.put(target - num, i);
        }

        return new int[0];
    }

    public static int[] moveZeros(int[] numbers) {
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                numbers[index++] = numbers[i];
            }
        }

        for (int i = index; i < numbers.length; i++) {
            numbers[i] = 0;
        }

        return numbers;
    }

    public static boolean containsDuplicate(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) return true;
        }

        return false;
    }

    public static int[] rotateArray(int[] numbers, int stepsToRotate) {
        int arraySize = numbers.length;
        while (stepsToRotate > 0) {
            int temp = numbers[arraySize - 1];
            for (int i = arraySize - 1; i > 0; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = temp;
            stepsToRotate--;
        }

        return numbers;
    }
}
