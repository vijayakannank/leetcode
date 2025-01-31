package linkedList;

public class MergeTwoSortedLinkedList {

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
