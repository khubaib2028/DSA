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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        
       
        int chunkSize = n / k;
        int extra = n % k;
        
        ListNode[] result = new ListNode[k];
        curr = head;
        
        for (int i = 0; i < k; i++) {
            result[i] = curr; 
            

            int currentPartSize = chunkSize + (i < extra ? 1 : 0); 
            ListNode prev = null;
            for (int j = 0; j < currentPartSize; j++) {
                prev = curr;
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (prev != null) {
                prev.next = null;
            }     
        }
        return result;
    }
}