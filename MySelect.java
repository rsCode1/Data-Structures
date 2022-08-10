
public class MySelect {

    public static void main(String[] args) {
        // main to test quick sort
        Integer a[] = { 1, 5, 2, 4, 7, 8, -1 };
        System.out.println(MySelect.select(a, 2));// should print 2

    }

    public static <T extends Comparable<T>> Comparable<T> select(T[] a, int k) {
        // return k'th smallest element
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                return a[k];
        }
        return a[k];
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
