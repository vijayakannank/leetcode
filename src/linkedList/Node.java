package linkedList;

public class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public static Node buildLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        return head;
    }

    public static void print(Node head) {
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
