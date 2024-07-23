package common;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Node> map;
    Node tail;
    Node head;
    int cacheCapacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.tail = new Node();
        this.head = new Node();
        this.cacheCapacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            deleteNode(node);
            addNode(node);
        }
        return node != null ? node.val :-1;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            deleteNode(node);
            node.val= value;
        }
        else {

            if(cacheCapacity <= map.size())
                deleteNode(map.remove(tail.prev.key));
            node = new Node(key,value);
        }
        map.put(key, node);
        addNode(node);
    }
    void deleteNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(){}
        Node(int key,int val ){
            this.val = val;
            this.key =key;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2,2);
        cache.put(3, 3);
        cache.put(4,4);
        System.out.println("hi");
    }
}
