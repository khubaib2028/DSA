/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = doubleRecursive(head);     
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }       
        return head;
    }    
    private int doubleRecursive(ListNode node) {
        if (node == null) {
            return 0;
        }
        int carry = doubleRecursive(node.next);
        int newVal = node.val * 2 + carry;
        node.val = newVal % 10;
        return newVal / 10;
    }
}