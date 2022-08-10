import java.util.Arrays;
import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {
        // main to test Selection sort
        Integer a[] = { 1, 5, 2, 4, 7, 8, -1 };
        Shuffle.shuffle(a);
        System.out.println(Arrays.toString(a));

    }

    // implementation of shuffle algorithm
    public static void shuffle(Object[] a) {
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(i + 1);
            swap(a, i, r);
        }
    }

    public static <T> void swap(T[] a, int i, int j) {
        // a generic function that swaps two values in array
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
