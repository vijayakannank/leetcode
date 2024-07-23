package linkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node = Node.buildLinkedList();
        Node reverse = reverse(node);
        Node.print(reverse);
    }


    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
}
