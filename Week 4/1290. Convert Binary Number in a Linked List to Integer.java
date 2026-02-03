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
    public int getDecimalValue(ListNode head) {
        int n=0;
        ListNode p1=head;
        while(p1 != null){
            n++;
            p1=p1.next;
        }
        int ans=0;
        p1=head;
        while(p1 != null){
            ans=ans + p1.val*(int)Math.pow(2,--n);
            p1=p1.next;
        }
        return ans;
    }
}
