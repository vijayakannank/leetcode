package linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveDupUnSort {

    public static void main(String[] args) {
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(1);
       head.next.next.next = new Node(3);
       head.next.next.next.next = new Node(3);
       head.next.next.next.next.next = new Node(3);
       head.next.next.next.next.next.next = new Node(4);

       Node.print(removeDup(head));
    }

    static Node removeDup(Node head) {
        Node node = head;
        Map<Integer, Boolean> map = new HashMap<>();
        Node prev = null;

        while(node != null){

            if(map.containsKey(node.val)){
                prev.next = node.next;
            } else {
                prev = node;
                map.put(node.val, true);
            }
            node = node.next;
        }
        return head;
    }
}
