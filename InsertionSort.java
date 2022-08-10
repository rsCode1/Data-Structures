import java.util.Arrays;

public class InsertionSort {
    // implementation of Insertion sort
    public static void main(String[] args) {
        // main to test Insertion sort
        Integer a[] = { 1, 5, 2, 4, 7, 8, -1 };
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (lessThan(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable<T>> boolean lessThan(T a, T b) {
        // a generic funciton that checks if a is less than b according to comparTo
        return a.compareTo(b) < 0;
    }

    public static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        // a generic function that swaps two values in array
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
