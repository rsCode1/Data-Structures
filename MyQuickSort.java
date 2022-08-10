import java.util.Arrays;

public class MyQuickSort {

    public static void main(String[] args) {
        // main to test quick sort
        Integer a[] = { 1, 5, 2, 4, 7, 8, -1 };
        MyQuickSort.sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        //sort left of partition and right of partition recursively
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo; // pivot
        int j = hi + 1;
        while (true) {
            while (a[++i].compareTo(a[lo]) < 0) { // find item on left to swap (is bigger than pivot)
                if (i == hi) {
                    break;
                }
            }
            while (a[lo].compareTo(a[--j]) < 0) {// find item on right to swap (is smaller than pivot)
                if (j == lo) {
                    break;
                }
            }

            if (i >= j)
                break;
            swap(a, i, j);// swap to get ordering
        }
        swap(a, lo, j); // after breaking from loop ,j is the right most item to left of pivot,so we
                        // swap
        return j;
    }

    public static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        // a generic function that swaps two values in array
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
