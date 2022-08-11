import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {
    // generic implementation of maximum heap
    private T[] heap;
    private int currsize;

    public static void main(String[] args) {

        // main to test max heap
        MaxHeap<Integer> heap = new MaxHeap<Integer>(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        System.out.println(heap);

    }

    public MaxHeap(int maxSize) {
        // initialize heap size with maximus size
        heap = (T[]) new Comparable[maxSize + 1];

    }

    public boolean isEmpty() {
        // checking if heap is empty
        return currsize == 0;
    }

    public void insert(T k) {
        // inserting at end of heap array ,correcting if any violation happens with swim
        // function
        heap[++currsize] = k;
        swim(currsize);
    }

    public T delMax() {
        // deleting the maximum by swapping with last item in heap
        // then using sink on the new root to fix viaolation
        T max = heap[1];
        swap(currsize, 1);
        currsize--;
        sink(1);
        heap[currsize + 1] = null; // to let grabage collector free unused index
        return max;
    }

    private void swim(int k) {
        // if child>parent we switch
        // child index =k with parent index=k/2
        // do upwards untill reach the root
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        // if parent<child we switch with largest of the childs
        // childs index =2k & 2k+1 ,parent index=k/2
        // do upwards untill reach the root
        while (2 * k <= currsize) {
            int j = 2 * k;
            if (j < currsize && less(j, j + 1)) {
                j++;
            }
            if (!(less(k, j)))
                break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public String toString() {
        return Arrays.toString(heap);
    }

}
