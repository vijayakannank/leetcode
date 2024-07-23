package ownimpl;

import java.lang.reflect.Array;
import java.util.*;

public class QueueImpl {

    int rear;
    int front;
    int maxSize;
    int currentSize=0;
    int[] queue;
//    T[] queue;

//    QueueImpl(Class<T> clazz, int size){
//        queue = get(clazz, size);
//        maxSize = size;
//        front = 0;
//        rear = -1;
//    }
//    public T[] get(Class<T> clazz, int capacity) {
//        return (T[]) Array.newInstance(clazz, capacity);
//    }

    QueueImpl(int size){
        queue = new int[size];
        rear = -1;
        maxSize = size;
    }
    void add(int i){
        if(isQueueFull()){
            System.out.println("queue is full");
            return;
        }
        if(rear+1 == maxSize)
            rear = -1;
        queue[++rear] = i;
        currentSize++;
    }

    int remove(){
        if(isQueueEmpty()){
            System.out.println("queu is empty");
            return 0;
        }
        int result = queue[front++];
        if(front == maxSize)
            front = 0;
        currentSize--;
        return result;
    }

    boolean isQueueEmpty(){
        return currentSize ==0;
    }
    boolean isQueueFull(){
        return currentSize == maxSize;
    }
    int peek(){
        return queue[front];
    }

    public static void main(String[] args) {
//        QueueImpl<Integer> t = new QueueImpl<>(Integer.class,2);

        QueueImpl queue = new QueueImpl(2);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        queue.add(4);
        queue.peek();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(5);
        System.out.println(queue.remove());


    }

}
