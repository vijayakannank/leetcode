package linkedList;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNoAndReverse {

    int carry = 0;
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1 != null ||  l2 != null){
            int val1 = l1 == null? 0 : l1.val;
            int val2 = l2 == null? 0: l2.val;
            int sum = val1+val2+carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;
            temp = temp.next;
            l1 = l1== null?null:l1.next;
            l2 = l2== null?null:l2.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return result.next;

    }
    public ListNode util(int v1, int v2) {
        int x = v1 + v2 + carry;
        carry = x/10;
        ListNode temp = new ListNode(x%10);
        return temp;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }