package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromUnsortedList {

    public static void main(String[] args) {
        Node node = Node.buildLinkedList();
        Node result = new RemoveDuplicateFromUnsortedList().remove(node);
        Node.print(result);
    }

    Node remove(Node head){
        Node node = head;
        Set<Integer> set = new HashSet<>();
        Node prev = head;
        while(node != null){
            if (!set.add(node.val)) {
                prev.next = node.next;
            } else {
                prev = node;
            }

            node = node.next;
        }
        System.out.println(prev);
        return head;
    }
}
