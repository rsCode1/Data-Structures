public class MyQueue<E> {
    // implementation of Queue with linked list
    // two pointers to head and tail of linked list
    private Node head = null;
    private Node tail = null;

    private class Node {
        E e;
        Node next;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(E element) {
        // insert element at end of linked list
        Node oldTail = tail;
        tail = new Node();
        tail.e = element;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
    }

    public E dequeue() {
        E returnValue = head.e;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        return returnValue;
    }
}
