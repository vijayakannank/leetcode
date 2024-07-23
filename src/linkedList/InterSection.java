package linkedList;

public class InterSection {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);
        getIntersectionNode(headA, headB);
    }
    static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            if(a == null){
                a = headB;
            } else {
                a = a.next;
            }

            if(b == null){
                b = headA;
            } else {
                b = b.next;
            }

        }
        return a;
    }
}
