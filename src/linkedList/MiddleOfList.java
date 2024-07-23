package linkedList;

public class MiddleOfList {

    public static void main(String[] args) {

        System.out.println(middle(Node.buildLinkedList()));
    }

    static int middle(Node node){
        if (node == null){
            return 0;
        }
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow.val;
    }
}
