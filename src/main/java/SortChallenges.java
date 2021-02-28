import java.util.Arrays;

public class SortChallenges {

    public int[] insertionSort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int current = elements[i];
            if (elements[i] < elements[0]) {
                System.arraycopy(elements, 0, elements, 1, i);
                elements[0] = current;
            } else {
                for (int j = 1; j < i; j++) {
                    if (elements[i] > elements[j - 1] && elements[i] < elements[j]) {
                        System.arraycopy(elements, j, elements, j + 1, i - j);
                        elements[j] = current;
                    }
                }
            }
        }

        return elements;
    }

    public int[] mergeSort(int[] elements) {
        if (elements.length == 1) return elements;
        int length = elements.length;

        int[] left = Arrays.copyOfRange(elements, 0, (length + 1) / 2);
        int[] right = Arrays.copyOfRange(elements, (length + 1) / 2, length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int resultIndex = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[resultIndex] = left[i];
                i++;
            } else {
                result[resultIndex] = right[j];
                j++;
            }
            resultIndex++;
        }

        while (i < left.length) {
            result[resultIndex] = left[i];
            resultIndex++;
            i++;
        }

        while (j < right.length) {
            result[resultIndex] = right[j];
            resultIndex++;
            j++;
        }

        return result;
    }

}
