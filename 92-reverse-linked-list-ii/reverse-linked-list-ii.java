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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        // Step 1: Use a dummy head to handle edge cases where left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Step 2: Advance `prev` to the node just before the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        // `curr` points to the first node of the sublist to be reversed
        ListNode curr = prev.next;
        
        // Step 3: Reverse the sublist of length (right - left) using standard pointer rotation
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        
        // Step 4: Return the updated list head
        return dummy.next;
    }
}