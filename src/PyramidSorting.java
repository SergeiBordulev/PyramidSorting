import java.util.Arrays;

public class PyramidSorting {
    private static void heapSort(int[] array) {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            sift(array, array.length, i);
        }

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            sift(array, i, 0);
        }
    }

    private static void sift(int[] array, int heapLength, int siftedNumberIndex) {
        int largestElementIndex = siftedNumberIndex;

        while (largestElementIndex < heapLength / 2) {
            int leftIndex = 2 * siftedNumberIndex + 1;
            int rightIndex = 2 * siftedNumberIndex + 2;

            if (array[leftIndex] > array[largestElementIndex]) {
                largestElementIndex = leftIndex;
            }

            if (rightIndex < heapLength && array[rightIndex] > array[largestElementIndex]) {
                largestElementIndex = rightIndex;
            }

            if (largestElementIndex == siftedNumberIndex) {
                break;
            }

            int temp = array[siftedNumberIndex];
            array[siftedNumberIndex] = array[largestElementIndex];
            array[largestElementIndex] = temp;

            siftedNumberIndex = largestElementIndex;
        }
    }

    public static void main(String[] args) {
        // int[] array = {17, 16, 5, 14, 13, 12, 11, 15, 4, 3};
        int[] array = {7, 5, 6, 4, 9, 8, 2, 1, 3, 17, 16, 14, 13, 12, 11, 15, 19, 23, 65, 48};

        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
