package linkedList;

public class DoubleLinkedList {
    int val;
    DoubleLinkedList prev;
    DoubleLinkedList next;

    public DoubleLinkedList(int val, DoubleLinkedList prev, DoubleLinkedList next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
