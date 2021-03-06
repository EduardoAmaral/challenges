import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Slf4j
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

    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length < 2) return nums;
        int stepsToRotate = k > nums.length ? k % nums.length : k;
        if (k < 0) return nums;

        int[] aux = copyElementsToRotate(nums, stepsToRotate);
        moveElementsToRight(nums, stepsToRotate);
        insertRotatedElements(nums, stepsToRotate, aux);

        return nums;
    }

    private static int[] copyElementsToRotate(int[] array, int stepsToRotate) {
        int[] aux = new int[stepsToRotate];

        System.arraycopy(array, array.length - stepsToRotate, aux, 0, stepsToRotate);

        return aux;
    }

    private static void moveElementsToRight(int[] array, int stepsToRotate) {
        System.arraycopy(array, 0, array, stepsToRotate, array.length - stepsToRotate);
    }

    private static void insertRotatedElements(int[] array, int stepsToRotate, int[] aux) {
        System.arraycopy(aux, 0, array, 0, stepsToRotate);
    }

    public static boolean containsCommonElement(String[] a, String[] b) {
        final Instant start = Instant.now();

        final Set<String> elements = new HashSet<>(Arrays.asList(a));

        for (String i : b) {
            if (elements.contains(i)) {
                log.info("containsCommonElement took {} milliseconds to finish", Duration.between(start, Instant.now()).toMillis());
                return true;
            }
        }

        log.info("containsCommonElement took {} milliseconds to finish", Duration.between(start, Instant.now()).toMillis());
        return false;
    }

    public static String reverse(String s) {
        if (s == null || s.trim().equals("")) return "";
        final String[] strings = s.split("");
        StringBuilder builder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}
