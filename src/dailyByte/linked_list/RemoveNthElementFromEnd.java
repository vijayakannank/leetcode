package dailyByte.linked_list;

public class RemoveNthElementFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode resultNode = removeElements(head,3);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    static public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode temp = head;

        while(temp != null && temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }

        return head;
    }
}
