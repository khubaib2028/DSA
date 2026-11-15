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
    public ListNode partition(ListNode head, int x) {
        // Step 1: Create two dummy heads for the "less than x" and "greater/equal" lists
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        
        // Step 2: Traverse the original list and distribute nodes into the two partitions
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                before.next = curr;
                before = before.next;
            } else {
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }
        
        // Step 3: Crucial step — terminate the 'after' list to prevent infinite cycles
        after.next = null;
        
        // Step 4: Connect the tail of the 'before' list to the head of the 'after' list
        before.next = afterHead.next;
        
        // Step 5: Return the combined list starting right after the dummy head
        return beforeHead.next;
    }
}