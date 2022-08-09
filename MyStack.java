public class MyStack <E> {
    //implementation of stack using linked list.
    private Node head = null;

    private class Node {
        E e;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(E element) {
        Node oldHead = head;
        head = new Node();
        head.e = element;
        head.next = oldHead;
    }

    public E pop() {
        E returnValue = head.e;
        head = head.next;
        return returnValue;
    }
}