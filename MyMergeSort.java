import java.util.Arrays;

public class MyMergeSort {

    public static void main(String[] args) {
        // main to test merge sort
        int a[] = { 1, 5, 2, 4, 7, 8, -1 };
        MyMergeSort.mergeSort(a);
        System.out.println(Arrays.toString(a));

    }

    // implementation of mergeSort for integers.
    public static void mergeSort(int[] array) {
        int N = array.length;
        if (N < 2) {
            return;
        }
        int mid = N / 2;
        int[] left = new int[mid];
        int[] right = new int[N - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < N; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public static void merge(int[] array, int[] left, int[] right) {

        // merge two sorted left and right arrays into one sorted array
        int i = 0, j = 0, k = 0;
        int leftSize = left.length;
        int rightSize = right.length;
        while (i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }

    }
}
