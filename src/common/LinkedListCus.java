package common;

public class LinkedListCus {
    Node head = new Node();
    Node tmp;
    LinkedListCus(){
        tmp = head;
    }
    void add(int i){
        tmp.val = i;
        tmp.next = new Node();
        tmp = tmp.next;
    }
    Integer get(int i){
        int pos = 0;
        Node node = head;
        while(node != null && pos < i){
            node = node.next;
            pos++;
        }

        return node != null ? node.val : -1;
    }


    class Node {
        int val;
        Node next;
        Node(){

        }
        Node(int val){
            this.val = val;

        }
    }

    public static void main(String[] args) {
        LinkedListCus cus = new LinkedListCus();
        cus.add(1);
        cus.add(2);
        cus.add(3);
        cus.add(4);
        System.out.println(cus.get(31));

    }
}
