package linkedList;

public class DeleteMiddleOfTheList {

    public static void main(String[] args) {
        Node result = deleteMiddleOfTheList(Node.buildLinkedList());
        Node.print(result);
    }

    static Node deleteMiddleOfTheList(Node node){
        if(node == null){
            return null;
        }
        Node slow = node;
        Node fast = node;
        Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return node;
    }
}
