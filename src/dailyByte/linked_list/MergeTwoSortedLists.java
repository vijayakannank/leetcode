package dailyByte.linked_list;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(4);

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(list, list1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val ) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 == null)
            temp.next = l2;
        if(l2 == null)
            temp.next = l1;
        return head.next;
    }
}
