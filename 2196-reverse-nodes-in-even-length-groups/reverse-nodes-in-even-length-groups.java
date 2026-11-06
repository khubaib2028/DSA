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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = head; 
        int groupSize = 2;   
        
        while (prev.next != null) {
            
            ListNode curr = prev;
            int actualSize = 0;
            for (int i = 0; i < groupSize && curr.next != null; i++) {
                curr = curr.next;
                actualSize++;
            }
            
        
            if (actualSize % 2 == 0) {
                ListNode groupStart = prev.next;
                ListNode nextGroupStart = curr.next;
                
                ListNode p = groupStart;
                ListNode q = nextGroupStart;
                for (int i = 0; i < actualSize; i++) {
                    ListNode temp = p.next;
                    p.next = q;
                    q = p;
                    p = temp;
                }
                
             
                prev.next = q;
          
                prev = groupStart;
            } else {         
                for (int i = 0; i < actualSize; i++) {
                    prev = prev.next;
                }
            }    
            groupSize++;
        }   
        return head;
    }
}