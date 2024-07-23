package array;

public class  MyCircularQueue {


    private int[] arr;
    private int front, rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.front = -1;
        this.rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        arr[rear] = value;
        if (front == -1) front = rear;
        rear = (rear + 1)%arr.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        int val = arr[front];
        front = (front+1)%arr.length;
        if (front == rear) front = -1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return arr[(rear-1+arr.length)%arr.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (front == -1);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (front == rear);
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
    }

}
