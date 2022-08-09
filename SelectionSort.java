import java.util.Arrays;

public class SelectionSort {
    // implementation of Selection sort
    public static void main(String[] args) {
        // main to test Selection sort
        Integer a[] = { 1, 5, 2, 4, 7, 8, -1 };
        SelectionSort.sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i; // index of currently smallest element
            for (int j = i + 1; j < N; j++) {
                if (lessThan(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
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
