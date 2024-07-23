package linkedList;

public class swapPairs {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
//        ListNode node = swapPairs.swapPairs(head);
        Node.print(swapPairs.swapPairs(head));

    }

    static Node swapPairs(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        int count = 0;
        while(current!=null ){
            if(count == 1){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count = 0;
            } else {
                prev = current;
               current =  current.next;
                count++;
            }


        }
        return prev;
    }
}
