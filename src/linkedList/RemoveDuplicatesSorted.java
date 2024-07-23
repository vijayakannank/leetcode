package linkedList;

public class RemoveDuplicatesSorted {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next = new Node(4);

        Node.print(removeDuplicate(node));

    }


    static Node removeDuplicate(Node head) {

        Node node = head;

        while(node != null && node.next != null){

            if(node.next.val == node.val){
                node.next = node.next.next;
            }
            else node = node.next;
        }
        return head;
    }
}
